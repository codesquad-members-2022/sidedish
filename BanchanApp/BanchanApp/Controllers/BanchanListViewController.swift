//
//  BanchanListViewController.swift
//  BanchanApp
//
//  Created by 송태환 on 2022/04/18.
//

import UIKit
import Toaster

class BanchanListViewController: UICollectionViewController {

    private let headerItem = ["모두가 좋아하는\n든든한 메인 요리", "정성이 담긴\n뜨끈뜨끈 국물 요리", "식탁을 풍성하게 하는\n정갈한 밑반찬"]

	var viewModel: BanchanListViewModel?

    override func viewDidLoad() {
        super.viewDidLoad()
		self.configureUI()
		self.bind()
		self.viewModel?.getProducts()
    }

	private func bind() {
        self.viewModel?.banchans.bind(subscriber: { _ in
			DispatchQueue.main.async {
				self.collectionView.reloadData()
			}
		})
	}

	private func configureUI() {
		let itemSize = NSCollectionLayoutSize(
			widthDimension: NSCollectionLayoutDimension.fractionalWidth(1),
			heightDimension: .estimated(130)
		)

		let item = NSCollectionLayoutItem(layoutSize: itemSize)
		let group = NSCollectionLayoutGroup.horizontal(layoutSize: itemSize, subitem: item, count: 1)
		let section = NSCollectionLayoutSection(group: group)

		section.contentInsets = NSDirectionalEdgeInsets(top: 0, leading: 16, bottom: 25, trailing: 16)
		section.interGroupSpacing = 10

		let headerFooterSize = NSCollectionLayoutSize(
			widthDimension: .fractionalWidth(1.0),
			heightDimension: .estimated(40)
		)

		let sectionHeader = NSCollectionLayoutBoundarySupplementaryItem(
			layoutSize: headerFooterSize,
			elementKind: UICollectionView.elementKindSectionHeader,
			alignment: .top
		)

		section.boundarySupplementaryItems = [sectionHeader]

		let layout = UICollectionViewCompositionalLayout(section: section)

		collectionView.collectionViewLayout = layout
		collectionView.register(ProductDetailCell.self, forCellWithReuseIdentifier: ProductDetailCell.identifier)
		collectionView.register(ProductSectionHeader.self, forSupplementaryViewOfKind: UICollectionView.elementKindSectionHeader, withReuseIdentifier: ProductSectionHeader.identifier)
	}

}

extension BanchanListViewController {

	override func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
		return self.viewModel?.getNumberOfItems(inSection: section) ?? 0
	}

	override func numberOfSections(in collectionView: UICollectionView) -> Int {
		return self.viewModel?.sectionCount ?? 0
	}

	override func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
		guard let cell = collectionView.dequeueReusableCell(withReuseIdentifier: ProductDetailCell.identifier, for: indexPath) as? ProductDetailCell else {
			return UICollectionViewCell()
		}

		guard let (title, description, salePrice, normalPrice, badges) = self.viewModel?.getBanchanInfo(withIndexPath: indexPath) else {
			return cell
		}

		cell.setInfoText(
			title: title,
			description: description,
			salePrice: salePrice,
			normalPrice: normalPrice,
			badges: badges
		)

        self.viewModel?.bindImage(at: indexPath , subscriber: { data in
            guard let data = data else { return }
            guard let image = UIImage(data: data) else { return }

            cell.setImage(image)
        })

		self.viewModel?.getBanchanImage(at: indexPath)

		return cell
	}

	override func collectionView(_ collectionView: UICollectionView, didSelectItemAt indexPath: IndexPath) {
		let viewController = BanchanDetailViewController()
		self.navigationController?.pushViewController(viewController, animated: true)
	}

	override func collectionView(_ collectionView: UICollectionView, viewForSupplementaryElementOfKind kind: String, at indexPath: IndexPath) -> UICollectionReusableView {
		guard let headerView = collectionView.dequeueReusableSupplementaryView(ofKind: UICollectionView.elementKindSectionHeader, withReuseIdentifier: ProductSectionHeader.identifier, for: indexPath) as? ProductSectionHeader else {
			return UICollectionReusableView()
		}

		headerView.setTitleText(headerItem[indexPath.section])

		return headerView
	}
}
