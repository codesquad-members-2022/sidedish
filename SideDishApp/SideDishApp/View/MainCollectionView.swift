//
//  MainCollectionView.swift
//  SideDishApp
//
//  Created by Kai Kim on 2022/04/23.
//

import UIKit

class MainCollectionView: UICollectionView {

    override init(frame: CGRect, collectionViewLayout layout: UICollectionViewLayout) {
        super.init(frame: frame, collectionViewLayout: layout)
        registerViews()
    }

    required init?(coder: NSCoder) {
        super.init(coder: coder)
        self.collectionViewLayout = CollectionViewLayoutFactory.createMainLayout()
        configureCollectionView()
        registerViews()
    }

    private func registerViews() {
        self.register(MainCollectionViewCell.nib(), forCellWithReuseIdentifier: MainCollectionViewCell.identifier)
        self.register(MainHeader.nib(), forSupplementaryViewOfKind: UICollectionView.elementKindSectionHeader, withReuseIdentifier: MainHeader.identifier)
        self.register(SideHeader.nib(), forSupplementaryViewOfKind: UICollectionView.elementKindSectionHeader, withReuseIdentifier: SideHeader.identifier)
        self.register(SoupHeader.nib(), forSupplementaryViewOfKind: UICollectionView.elementKindSectionHeader, withReuseIdentifier: SoupHeader.identifier)
    }

    private func configureCollectionView() {
        self.delegate = self
        self.dataSource = self
    }

}

extension MainCollectionView: UICollectionViewDataSource, UICollectionViewDelegate {

    // MARK: Cell
    func numberOfSections(in collectionView: UICollectionView) -> Int {
        3
    }

    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        3
    }

    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        let cell = self.dequeueReusableCell(withReuseIdentifier: MainCollectionViewCell.identifier, for: indexPath) as! MainCollectionViewCell

//        cell.setImage()

        return cell
    }

    // MARK: Section Header
    func collectionView(_ collectionView: UICollectionView, viewForSupplementaryElementOfKind kind: String, at indexPath: IndexPath) -> UICollectionReusableView {

        let section = indexPath.section

        switch section {
        case 0:
            return self.dequeueReusableSupplementaryView(ofKind: UICollectionView.elementKindSectionHeader, withReuseIdentifier: MainHeader.identifier, for: indexPath)
        case 1:
            return self.dequeueReusableSupplementaryView(ofKind: UICollectionView.elementKindSectionHeader, withReuseIdentifier: SoupHeader.identifier, for: indexPath)
        case 2:
            return self.dequeueReusableSupplementaryView(ofKind: UICollectionView.elementKindSectionHeader, withReuseIdentifier: SideHeader.identifier, for: indexPath)

        default:
            return UICollectionReusableView()
        }
    }

}
