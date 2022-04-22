//
//  BanchanListViewController.swift
//  BanchanApp
//
//  Created by 송태환 on 2022/04/18.
//

import UIKit

class BanchanListViewController: UICollectionViewController {

    private let headerItem = ["모두가 좋아하는\n든든한 메인 요리", "정성이 담긴\n뜨끈뜨끈 국물 요리", "식탁을 풍성하게 하는\n정갈한 밑반찬"]

    override func viewDidLoad() {
        super.viewDidLoad()
        setCollectionLayout()
    }

    private func configureUI() {

    }

    private func setCollectionLayout() {
        if let layout = collectionView.collectionViewLayout as? UICollectionViewFlowLayout {
            let width = view.frame.width
            layout.sectionInset = UIEdgeInsets(top: 0, left: 16, bottom: 24, right: 16)
            layout.headerReferenceSize = CGSize(width: width, height: 144)
            layout.minimumLineSpacing = 8
            layout.estimatedItemSize = .zero
            let cellPadding = layout.sectionInset.left + layout.sectionInset.right
            layout.itemSize = CGSize(width: width - cellPadding, height: (width - cellPadding) * 0.38)
        }
    }

    override func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        return 10
    }

    override func numberOfSections(in collectionView: UICollectionView) -> Int {
        return headerItem.count
    }

    override func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        let cell = collectionView.dequeueReusableCell(withReuseIdentifier: "Cell", for: indexPath)
        return cell
    }

    override func collectionView(_ collectionView: UICollectionView, didSelectItemAt indexPath: IndexPath) {
        guard let viewController = UIStoryboard(name: "BanchanDetailViewController", bundle: nil)
            .instantiateInitialViewController() else { return }
        self.navigationController?.pushViewController(viewController, animated: true)
    }

    override func collectionView(_ collectionView: UICollectionView, viewForSupplementaryElementOfKind kind: String, at indexPath: IndexPath) -> UICollectionReusableView {
        guard let header = collectionView.dequeueReusableSupplementaryView(ofKind: kind, withReuseIdentifier: "header", for: indexPath) as? Header else { return UICollectionReusableView() }
        header.title.text = headerItem[indexPath.section]
        return header
    }

}
