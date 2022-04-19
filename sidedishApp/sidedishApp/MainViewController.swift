//
//  MainViewController.swift
//  sidedishApp
//
//  Created by Bibi on 2022/04/18.
//

import UIKit
import Toaster

class MainViewController: UIViewController {
    
    @IBOutlet weak var collectionView: UICollectionView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
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
        return 1
    }
    
    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        guard let cell = collectionView.dequeueReusableCell(withReuseIdentifier: MainViewCardCell.identifier, for: indexPath) as? MainViewCardCell else {
            return UICollectionViewCell()
        }
        cell.backgroundColor = .systemGray3
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
