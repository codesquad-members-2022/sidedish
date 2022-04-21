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
        addSampleData()
    }

    private func registerXib() {
        let nibName = UINib(nibName: String(describing: HomeCollectionViewCell.self), bundle: nil)
        collectionView.register(nibName, forCellWithReuseIdentifier: String(describing: HomeCollectionViewCell.self))
    }
    
    private func addSampleData() {
        for _ in 1...25 {
            let model = HomeModel(image: "img01",
                                  name: "뜨끈한 국밥",
                                  description: "아주 따뜻해유",
                                  discountedPrice: "12,370원",
                                  originalPrice: "18,380원",
                                  specialMessage: "이벤트특가")
            products.append(model)
        }
        collectionView.reloadData()
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
        guard let cell = collectionView.dequeueReusableCell(withReuseIdentifier: String(describing: HomeCollectionViewCell.self),
                                                            for: indexPath) as? HomeCollectionViewCell else {
            return UICollectionViewCell()
        }
        cell.imageView.image = UIImage(named: "img01")
        cell.nameLabel.text = products[indexPath.item].name
        cell.descriptionLabel.text = products[indexPath.item].description
        cell.discountedPriceLabel.text = products[indexPath.item].discountedPrice
        cell.originalPriceLabel.text = products[indexPath.item].originalPrice
        cell.specialMessagelabel.text = products[indexPath.item].specialMessage
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
        return CGSize(width: UIScreen.main.bounds.width, height: 130)
    }

    func collectionView(_ collectionView: UICollectionView,
                        viewForSupplementaryElementOfKind kind: String,
                        at indexPath: IndexPath) -> UICollectionReusableView {
        switch kind {
        case UICollectionView.elementKindSectionHeader:
            let headerView = collectionView.dequeueReusableSupplementaryView(ofKind: kind,
                                                                             withReuseIdentifier: String(describing: HomeHeaderCollectionReusableView.self),
                                                                             for: indexPath)
            
            guard let homeHeaderView = headerView as? HomeHeaderCollectionReusableView else { return headerView }
            return homeHeaderView
        default:
            assert(false, "Invalid element type")
        }
    }
}
