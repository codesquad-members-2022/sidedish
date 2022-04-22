//
//  MainViewController.swift
//  sidedishApp
//
//  Created by Bibi on 2022/04/18.
//

import UIKit
import Toaster

class MainViewController: UIViewController {
    
    private let factory = CardFactory()
    private var mainCards = [MainCard]()
    
    @IBOutlet weak var collectionView: UICollectionView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        let sampleMainCard = factory.createMainCard(detailHash: "HBDEF",
                                                           imageURL: "http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg",
                                                           title: "오리 주물럭_반조리",
                                                           description: "감칠맛 나는 매콤한 양념",
                                                           normalPrice: "15,800원",
                                                           salePrice: "12,640원",
                                                           bagdeList: [Badge.launchingPrice])
        mainCards.append(sampleMainCard)
        
        self.collectionView.delegate = self
        self.collectionView.dataSource = self
        self.collectionView.register(MainViewCardCell.self, forCellWithReuseIdentifier: MainViewCardCell.identifier)
        self.collectionView.register(MainViewHeader.self, forSupplementaryViewOfKind: UICollectionView.elementKindSectionHeader, withReuseIdentifier: MainViewHeader.identifier)
    }
}

extension MainViewController: UICollectionViewDelegate {
    
}

extension MainViewController: UICollectionViewDataSource {
    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        return mainCards.count
    }
    
    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        guard let cell = collectionView.dequeueReusableCell(withReuseIdentifier: MainViewCardCell.identifier, for: indexPath) as? MainViewCardCell else {
            return UICollectionViewCell()
        }
        
        let card = mainCards[indexPath.item]
        cell.setPropertiesValue(card.imageURL, card.title, card.description, card.normalPrice, card.salePrice, card.badgeList)
        return cell
    }
    
    func collectionView(_ collectionView: UICollectionView, viewForSupplementaryElementOfKind kind: String, at indexPath: IndexPath) -> UICollectionReusableView { // 헤더 설정
        if kind == UICollectionView.elementKindSectionHeader {
            let header = collectionView.dequeueReusableSupplementaryView(ofKind: kind, withReuseIdentifier: MainViewHeader.identifier, for: indexPath)
            return header
        }
        return UICollectionReusableView()
    }
    
    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, referenceSizeForHeaderInSection section: Int) -> CGSize { // 섹션의 헤더 높이 설정
        let width = collectionView.frame.width
        let height: CGFloat = 170
        return CGSize(width: width, height: height)
    }
}

extension MainViewController: UICollectionViewDelegateFlowLayout { // 컬렉션뷰 셀 사이즈 설정
    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, sizeForItemAt indexPath: IndexPath) -> CGSize {
        return CGSize(width: collectionView.frame.width, height: 140)
    }
}
