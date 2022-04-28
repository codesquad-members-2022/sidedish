//
//  MainCollectionViewLayout.swift
//  SideDishApp
//
//  Created by Kai Kim on 2022/04/23.
//

import UIKit

struct CollectionViewLayoutFactory {

    static func createMainLayout() -> UICollectionViewCompositionalLayout {

        let layout = UICollectionViewCompositionalLayout { (sectionIndex: Int,
               _: NSCollectionLayoutEnvironment) -> NSCollectionLayoutSection? in

            // item
            let item = NSCollectionLayoutItem(layoutSize: NSCollectionLayoutSize(widthDimension: .fractionalWidth(1), heightDimension: .fractionalHeight(1)))

            // group
            let group = NSCollectionLayoutGroup.horizontal(layoutSize: NSCollectionLayoutSize(widthDimension: .fractionalWidth(1), heightDimension: .estimated(130)), subitems: [item])

            group.edgeSpacing = NSCollectionLayoutEdgeSpacing(leading: nil, top: nil, trailing: nil, bottom: .fixed(8))

            // Sections
            let section = NSCollectionLayoutSection(group: group)

            let sectionHeaderSize = NSCollectionLayoutSize(widthDimension: .fractionalWidth(1.0),
                                                           heightDimension: .absolute(96))

            let sectionHeader = NSCollectionLayoutBoundarySupplementaryItem(
                layoutSize: sectionHeaderSize,
                elementKind: UICollectionView.elementKindSectionHeader, alignment: .top)

            section.boundarySupplementaryItems = [sectionHeader]
            sectionHeader.edgeSpacing = NSCollectionLayoutEdgeSpacing(leading: nil, top: .fixed(100), trailing: nil, bottom: .fixed(8))

            if sectionIndex % 2 != 0 {
                section.decorationItems = [ NSCollectionLayoutDecorationItem.background(elementKind: MainBackgroundView.identifier)]
            }

            section.contentInsets = NSDirectionalEdgeInsets(top: 24, leading: 16, bottom: 16, trailing: 16)

            return section

        }

        layout.register(MainBackgroundView.self, forDecorationViewOfKind: MainBackgroundView.identifier)
        let config = UICollectionViewCompositionalLayoutConfiguration()

        layout.configuration = config

        // Return
        return layout
    }

}
