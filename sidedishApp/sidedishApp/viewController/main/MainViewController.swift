//
//  MainViewController.swift
//  sidedishApp
//
//  Created by Bibi on 2022/04/18.
//

import UIKit
import Toaster

class MainViewController: UIViewController {
    
    let sideDishManager = SideDishManager.shared
    
    @IBOutlet weak var dishCollectionView: UICollectionView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        self.dishCollectionView.delegate = self
        self.dishCollectionView.dataSource = self
        self.dishCollectionView.register(MainViewCardCell.self, forCellWithReuseIdentifier: MainViewCardCell.identifier)
        self.dishCollectionView.register(MainViewHeader.self, forSupplementaryViewOfKind: UICollectionView.elementKindSectionHeader, withReuseIdentifier: MainViewHeader.identifier)
        
        addNotification()
    }
}

extension MainViewController: UICollectionViewDataSource {
    
    func numberOfSections(in collectionView: UICollectionView) -> Int {
        return 3
    }
    
    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        switch section {
        case 0:
            return sideDishManager.mainDishes?.body.count ?? 0
        case 1:
            return sideDishManager.soupDishes?.body.count ?? 0
        case 2:
            return sideDishManager.sideDishes?.body.count ?? 0
        default:
            return 0
        }
    }
    
    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        guard let cell = collectionView.dequeueReusableCell(withReuseIdentifier: MainViewCardCell.identifier, for: indexPath) as? MainViewCardCell else {
            return UICollectionViewCell()
        }
        
        var dish: MainCard.Body
        
        switch indexPath.section { // 섹션 번호!
        case 0:
            guard let mainDishs = sideDishManager.mainDishes else {
                return cell
            }
            dish = mainDishs.body[indexPath.item]
        case 1:
            guard let mainDishs = sideDishManager.soupDishes else {
                return cell
            }
            dish = mainDishs.body[indexPath.item]
        case 2:
            guard let mainDishs = sideDishManager.sideDishes else {
                return cell
            }
            dish = mainDishs.body[indexPath.item]
        default:
            return cell
        }
        
        cell.setPropertiesValue(dish: dish)
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
    
    func collectionView(_ collectionView: UICollectionView, didSelectItemAt indexPath: IndexPath) { // 셀 아이템 선택 시
        guard let detailVC = self.storyboard?.instantiateViewController(withIdentifier: "DetailViewController") as? DetailViewController else { return }
        guard let dish = self.sideDishManager.getDishFromSection(indexPath: indexPath), let detail = self.sideDishManager.getDetailDishFromHash(hash: dish.detailHash) else { return }
        detailVC.selectedDish = dish
        detailVC.detailDish = detail
        self.navigationController?.pushViewController(detailVC, animated: true)
    }
}

extension MainViewController: UICollectionViewDelegateFlowLayout { // 컬렉션뷰 셀 사이즈 설정
    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, sizeForItemAt indexPath: IndexPath) -> CGSize {
        return CGSize(width: collectionView.frame.width, height: 140)
    }
}

private extension MainViewController {
    func addNotification() {
        NotificationCenter.default.addObserver(self, selector: #selector(setMainDish), name: NSNotification.Name(SideDishManager.mainIdentifier), object: sideDishManager)
        self.sideDishManager.getDishes(type: .main)
        self.sideDishManager.getDishes(type: .soup)
        self.sideDishManager.getDishes(type: .side)
        self.sideDishManager.getDetailDish()
    }
    
    @objc func setMainDish() {
        DispatchQueue.main.async {
            self.dishCollectionView.reloadData()
        }
    }
}
