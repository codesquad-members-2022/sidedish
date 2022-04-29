//
//  HomeViewController.swift
//  SideDish20
//
//  Created by 안상희 on 2022/04/19.
//

import UIKit

class HomeViewController: UIViewController {
    var products = [HomeModel]()
    @IBOutlet weak var collectionView: UICollectionView!

    override func viewDidLoad() {
        super.viewDidLoad()

        registerXib()
        
        let homeViewModel = HomeViewModel()
        
        homeViewModel.onUpdated = { [weak self] in
            guard let self = self else { return }
            self.products = homeViewModel.homeSubViewModel ?? [HomeModel]()
            
            DispatchQueue.main.async {
                self.collectionView.reloadData()
            }
        }

        homeViewModel.reload()
    }

    private func registerXib() {
        let nibName = UINib(nibName: String(describing: HomeCollectionViewCell.self), bundle: nil)
        collectionView.register(nibName, forCellWithReuseIdentifier: String(describing: HomeCollectionViewCell.self))
    }
}

extension HomeViewController: UICollectionViewDataSource, UICollectionViewDelegate, UICollectionViewDelegateFlowLayout {
    func numberOfSections(in collectionView: UICollectionView) -> Int {
        return 1
    }

    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        return products.count
    }

    func collectionView(_ collectionView: UICollectionView,
                        cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        guard let cell = collectionView
            .dequeueReusableCell(withReuseIdentifier: String(describing: HomeCollectionViewCell.self),
                                 for: indexPath) as? HomeCollectionViewCell else {
            return UICollectionViewCell()
        }
        cell.data = products[indexPath.item]
        return cell
    }

    func collectionView(_ collectionView: UICollectionView,
                        layout collectionViewLayout: UICollectionViewLayout,
                        insetForSectionAt section: Int) -> UIEdgeInsets {
        let inset: CGFloat = 10
        return UIEdgeInsets(top: inset, left: inset, bottom: inset, right: inset)
    }

    func collectionView(_ collectionView: UICollectionView,
                        layout collectionViewLayout: UICollectionViewLayout,
                        sizeForItemAt indexPath: IndexPath) -> CGSize {
        return CGSize(width: collectionView.frame.width, height: 130)
    }

    func collectionView(_ collectionView: UICollectionView,
                        viewForSupplementaryElementOfKind kind: String,
                        at indexPath: IndexPath) -> UICollectionReusableView {
        switch kind {
        case UICollectionView.elementKindSectionHeader:
            let headerView = collectionView
                .dequeueReusableSupplementaryView(ofKind: kind,
                                                  withReuseIdentifier:
                                                    String(describing: HomeHeaderCollectionReusableView.self),
                                                  for: indexPath)
            
            guard let homeHeaderView = headerView as? HomeHeaderCollectionReusableView else { return headerView }
            return homeHeaderView
        default:
            assert(false, "Invalid element type")
        }
    }
    
    func collectionView(_ collectionView: UICollectionView, didSelectItemAt indexPath: IndexPath) {
        
        let identifier = String(describing: DetailViewController.self)
        let dest = storyboard?.instantiateViewController(withIdentifier: identifier)
        
        guard let detailViewController = dest as? DetailViewController else {
            return
        }
        
        self.navigationController?.pushViewController(detailViewController, animated: true)
    }
}
