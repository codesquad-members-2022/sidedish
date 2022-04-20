//
//  MainViewController.swift
//  sidedish
//
//  Created by seongha shin on 2022/04/18.
//
import Combine
import UIKit

class MainViewController: UIViewController {
    private let model: MainViewModelBinding = MainViewModel()
    private var cancellables = Set<AnyCancellable>()
    
    private var collectionView: UICollectionView = {
        let flowLayout = UICollectionViewFlowLayout()
        flowLayout.scrollDirection = .vertical
        flowLayout.sectionInset = UIEdgeInsets(top: 0, left: 16, bottom: 8, right: 16)
        flowLayout.itemSize = CGSize(width: 400, height: 130)

        let collectionView = UICollectionView(frame: .zero, collectionViewLayout: flowLayout)
        collectionView.translatesAutoresizingMaskIntoConstraints = false
        collectionView.register(CustomCollectionCell.self, forCellWithReuseIdentifier: CustomCollectionCell.identifier)
        return collectionView
    }()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        bind()
        attritbute()
        layout()
    
        model.action.loadData.send() // loadData 호출 (이벤트가 발생했다!)
        
    }
    
    private func bind() {
        collectionView.delegate = self
        collectionView.dataSource = self
    
        view.addSubview(collectionView)
//        model.state.loadedData
//            .sink { index in
//                print(index)
//                self.collectionView.reloadData()
//            } .store(in: &cancellables)
        
    }
    
    private func attritbute() {
        title = "Ordering"
        view.backgroundColor = .white
    }
    
    private func layout() {
        collectionView.topAnchor.constraint(equalTo: view.safeAreaLayoutGuide.topAnchor).isActive = true
        collectionView.bottomAnchor.constraint(equalTo: view.bottomAnchor).isActive = true
        collectionView.leadingAnchor.constraint(equalTo: view.leadingAnchor).isActive = true
        collectionView.trailingAnchor.constraint(equalTo: view.trailingAnchor).isActive = true
    }
}

extension MainViewController: UICollectionViewDataSource, UICollectionViewDelegate {
    func numberOfSections(in collectionView: UICollectionView) -> Int { 3 }
    
    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int { 8 }
    
    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        guard let cell = collectionView.dequeueReusableCell(withReuseIdentifier: CustomCollectionCell.identifier, for: indexPath) as? CustomCollectionCell else {
            return UICollectionViewCell()
        }
        cell.changeTitleLabel(text: "테스트")
        cell.changeContentLabel(text: "djdjdjd")
        cell.changePriceLabel(text: "21514531")
        return cell
    }
}
