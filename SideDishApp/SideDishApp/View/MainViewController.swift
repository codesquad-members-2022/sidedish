//
//  ViewController.swift
//  SideDishApp
//
//  Created by Bumgeun Song on 2022/04/18.
//

import UIKit
import Toast_Swift

class MainViewController: UIViewController {

    @IBOutlet weak var mainCollectionView: UICollectionView!
    private var viewModel = MainCollectionViewModel()

    override func viewDidLoad() {
        super.viewDidLoad()
        configureNavigationBar()
        setCollectionViewLayout()
        configureCollectionView()
        registerViews()
        bindViewModel()
    }

    private func configureNavigationBar() {
        let navigationBar = navigationController?.navigationBar
        let navigationBarAppearance = UINavigationBarAppearance()
        navigationBarAppearance.shadowColor = .black
        navigationBar?.scrollEdgeAppearance = navigationBarAppearance
    }

    private func setCollectionViewLayout() {
        mainCollectionView.collectionViewLayout = CollectionViewLayoutFactory.createMainLayout()
    }

    private func configureCollectionView() {
        mainCollectionView.delegate = self
        mainCollectionView.dataSource = self
    }

    private func registerViews() {
        mainCollectionView.register(MainCollectionViewCell.nib(), forCellWithReuseIdentifier: MainCollectionViewCell.identifier)
        mainCollectionView.register(HeaderView.self, forSupplementaryViewOfKind: UICollectionView.elementKindSectionHeader, withReuseIdentifier: HeaderView.identifier)
    }
    private func bindViewModel() {
        CategoryType.allCases.forEach({ type in
            guard let categoryVM = viewModel.categoryVMs[type] else {return}
            self.mainCollectionView.performBatchUpdates {
                categoryVM.bind { _ in
                    DispatchQueue.main.async {
                        self.mainCollectionView.reloadData()
                    }
                }
            }
        })
        viewModel.fetchAllCategories()
    }

    private func bindHeaderViewModel() {
        CategoryType.allCases.forEach({ type in
            guard let headerVMs = viewModel.headerVMs[type] else {return}
            headerVMs.bind { _ in
                DispatchQueue.main.async {
                    self.mainCollectionView.reloadInputViews()
                }
            }
        })
    }

}

extension MainViewController: UICollectionViewDataSource, UICollectionViewDelegate {

    // MARK: Cell
    func numberOfSections(in collectionView: UICollectionView) -> Int {
        viewModel.countSection()
    }

    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        viewModel.countProduct(section: section)
    }

    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {

        guard let cell = mainCollectionView.dequeueReusableCell(withReuseIdentifier: MainCollectionViewCell.identifier, for: indexPath) as? MainCollectionViewCell, let productVM = viewModel[indexPath] else {return UICollectionViewCell()}
        viewModel.fetchImage(from: productVM.imageURL) { nsData in
            guard let nsData = nsData else { return }
            DispatchQueue.main.async {
                cell.mainImage.image = UIImage(data: Data(referencing: nsData))
            }
        }
        cell.configureCell(product: productVM)
        return cell
    }

    // MARK: Section Header
    func collectionView(_ collectionView: UICollectionView, viewForSupplementaryElementOfKind kind: String, at indexPath: IndexPath) -> UICollectionReusableView {

        guard let header = mainCollectionView.dequeueReusableSupplementaryView(ofKind: UICollectionView.elementKindSectionHeader, withReuseIdentifier: HeaderView.identifier, for: indexPath) as? HeaderView else {
            return HeaderView()
        }

        let productType = CategoryType.allCases[indexPath.section]
        header.setCounterView(viewModel.countProduct(section: indexPath.section))
        header.setTitle(text: productType.title)
        header.setType(type: productType)

//        header.counterView.isHidden = viewModel.headerHiddenStatus[productType] ?? true

        header.counterView.isHidden = viewModel.categoryVMs[productType]?.value?.headerHiddenStatus ?? true
        header.delegate = self
        return header
    }

}

// MARK: Header View delegate
extension MainViewController: HeaderViewDelegate {
    func didTapHeader(sender: UICollectionReusableView) {
        guard let tappedHeader = sender as? HeaderView, let type = tappedHeader.type else {return}
        tappedHeader.counterView.isHidden = !tappedHeader.counterView.isHidden
        viewModel.updateHeaderStatus(tappedHeader.counterView.isHidden, at: type)

//        viewModel.headerHiddenStatus[type] = tappedHeader.counterView.isHidden

    }

}
