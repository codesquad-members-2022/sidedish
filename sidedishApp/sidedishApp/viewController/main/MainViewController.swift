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
        return Dish.allCases.count
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
        // var dishImageData: Data
        
        switch indexPath.section { // 섹션 번호!
        case 0:
            print("섹션1")
            guard let mainDishes = sideDishManager.mainDishes else { return cell }
            dish = mainDishes.body[indexPath.item]
            
            guard let dishImageData = sideDishManager.getMainDishImages(hash: dish.detailHash) else { return cell }
            cell.setImage(imageData: dishImageData)
        case 1:
            print("섹션2")
            guard let soupDishes = sideDishManager.soupDishes else { return cell }
            dish = soupDishes.body[indexPath.item]
            
            guard let dishImageData = sideDishManager.getMainDishImages(hash: dish.detailHash) else { return cell }
            cell.setImage(imageData: dishImageData)
        case 2:
            print("섹션3")
            guard let sideDishes = sideDishManager.sideDishes else {
                return cell
            }
            dish = sideDishes.body[indexPath.item]
            
            guard let dishImageData = sideDishManager.getMainDishImages(hash: dish.detailHash) else { return cell }
            cell.setImage(imageData: dishImageData)
        default:
            return cell
        }
        cell.setPropertiesValue(dish: dish)
        
//        guard let imageData = sideDishManager.getMainDishImages(hash: dish.detailHash) else {
//            return cell
//        }
        
//        if imageData.isEmpty {
//            print("이미지 없음")
//            cell.setPropertiesValue(dish: dish)
//        } else {
//            print("이미지 있음")
//            // cell.setPropertiesValue(dish: dish)
//            cell.setImage(imageData: imageData)
//        }
        
        return cell
    }
    
    func collectionView(_ collectionView: UICollectionView, viewForSupplementaryElementOfKind kind: String, at indexPath: IndexPath) -> UICollectionReusableView { // 헤더 설정
        if kind == UICollectionView.elementKindSectionHeader {
            if let header = collectionView.dequeueReusableSupplementaryView(ofKind: kind, withReuseIdentifier: MainViewHeader.identifier, for: indexPath) as? MainViewHeader {
                if let dishCount = sideDishManager.getDishCountFromSection(indexPath: indexPath) {
                    header.setUIValue(indexPath: indexPath, dishCount: dishCount)
                }
                return header
            }
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
        return CGSize(width: collectionView.frame.width, height: 200)
    }
}

private extension MainViewController {
    func addNotification() {
        NotificationCenter.default.addObserver(self, selector: #selector(reloadMainCollectionView), name: NSNotification.Name(SideDishManager.mainIdentifier), object: sideDishManager)
        // NotificationCenter.default.addObserver(self, selector: #selector(setDishImage), name: NSNotification.Name(rawValue: "download"), object: sideDishManager) // 이미지 1개가 다운로드될 때마다 호출
        self.sideDishManager.getDishes(type: .main)
        self.sideDishManager.getDishes(type: .soup)
        self.sideDishManager.getDishes(type: .side)
        self.sideDishManager.getDetailDish()
    }
    
    @objc func reloadMainCollectionView() {
        DispatchQueue.main.async {
            self.dishCollectionView.reloadData()
            print("reloaded - section data")
        }
    }
    
//    @objc
    private func setDishImage() {
//        DispatchQueue.main.async { // 리로드에서 무한루프 발생 : 셀 이미지 업데이트 -> 리로드 -> 셀 이미지 -> 리로드 ....
//            self.dishCollectionView.reloadData()
//            print("reloaded - image data")
//        }
    }
}
