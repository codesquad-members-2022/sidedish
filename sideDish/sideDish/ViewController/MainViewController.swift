//
//  ViewController.swift
//  sideDish
//
//  Created by 이건행 on 2022/04/18.
//

import UIKit
import Toaster

class MainViewController: UIViewController {
    
    enum Section: Int{
        case main = 0
        case soup
        case side
    }
    
    let headerData = ["모두가 좋아하는 든든한 메인 요리", "정성이 담긴 뜨끈뜨끈 국물 요리", "식탁을 풍성하게 하는 정갈한 밑반찬"]
    
    var foodManager: FoodManager = FoodManager()
    
    private var collectionView: UICollectionView = {
        let tempCollcetion = UICollectionView(frame: CGRect(x: 0, y: 0, width: UIScreen.main.bounds.size.width - 32, height: 500), collectionViewLayout: UICollectionViewFlowLayout())
        
        return tempCollcetion
    }()
    
    private let headerID = "headerView"
    private let cellID = "foodCell"
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        configureCollectionViewLayout()
        collectionView.register(CollectionHeaderView.self, forSupplementaryViewOfKind: UICollectionView.elementKindSectionHeader, withReuseIdentifier: headerID)
        collectionView.register(FoodCell.self, forCellWithReuseIdentifier: cellID)
        collectionView.delegate = self
        collectionView.dataSource = self
    }
    
    func configureCollectionViewLayout() {
        let flowLayout = UICollectionViewFlowLayout()
       
        flowLayout.itemSize = CGSize(width: self.collectionView.frame.width, height: 130)
        flowLayout.headerReferenceSize = CGSize(width: 0, height: 96)
        collectionView.collectionViewLayout = flowLayout
        
        self.view.addSubview(self.collectionView)
        collectionView.translatesAutoresizingMaskIntoConstraints = false
        collectionView.widthAnchor.constraint(greaterThanOrEqualToConstant: 343).isActive = true
        collectionView.leadingAnchor.constraint(equalTo: self.view.leadingAnchor, constant: 16).isActive = true
        collectionView.trailingAnchor.constraint(equalTo: self.view.trailingAnchor, constant: -16).isActive = true
        collectionView.topAnchor.constraint(equalTo: self.view.safeAreaLayoutGuide.topAnchor, constant: 24).isActive = true
        collectionView.bottomAnchor.constraint(equalTo: self.view.bottomAnchor).isActive = true
        
    }
}

extension MainViewController: UICollectionViewDataSource {
    
    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        switch section{
        
        case Section.main.rawValue: return foodManager.mainFood?.count ?? 0
        case Section.soup.rawValue: return foodManager.soupFood?.count ?? 0
        case Section.side.rawValue: return foodManager.sideFood?.count ?? 0
        default:
            return 0
        }
    }
    
    func numberOfSections(in collectionView: UICollectionView) -> Int {
        return headerData.count
    }
    
    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        guard let cell = collectionView.dequeueReusableCell(withReuseIdentifier: self.cellID, for: indexPath) as? FoodCell else { return UICollectionViewCell() }
        
        if indexPath.section == Section.main.rawValue{
            guard let main = foodManager.mainFood else { return UICollectionViewCell()}
            cell.setDomainFood(data: main[indexPath.item])
        } else if indexPath.section == Section.soup.rawValue {
            guard let soup = foodManager.soupFood else { return UICollectionViewCell()}
            cell.setDomainFood(data: soup[indexPath.item])
        } else {
            guard let side = foodManager.sideFood else { return UICollectionViewCell()}
            cell.setDomainFood(data: side[indexPath.item])
        }
        
        return cell
    }
    
}

extension MainViewController: UICollectionViewDelegate {
    
    func collectionView(_ collectionView: UICollectionView, viewForSupplementaryElementOfKind kind: String, at indexPath: IndexPath) -> UICollectionReusableView {
        guard let headerView = collectionView.dequeueReusableSupplementaryView(ofKind: kind, withReuseIdentifier: headerID, for: indexPath) as? CollectionHeaderView else { return UICollectionReusableView() }
        headerView.setTitle(text: headerData[indexPath.section])
        return headerView
    }

}
