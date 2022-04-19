//
//  ViewController.swift
//  sideDish
//
//  Created by 이건행 on 2022/04/18.
//

import UIKit
import Toaster

class MainViewController: UIViewController {
    
    let dummyData = [["오리주물럭, 잡채, 소갈비찜, 간장 코다리조림"],
                     ["한돈 돼지 김치찌개","된장찌개","미역 오이냉국"],
                     ["새콤달콤 오징어무침","호두 멸치볶음","한돈 매콤 안심장조림"]]
    let dummyHeaderData = ["모두가 좋아하는 든든한 메인 요리","정성이 담긴 뜨끈뜨끈 국물 요리","식탁을 풍성하게 하는 정갈한 밑반찬"]
    
    private var collectionView: UICollectionView!
    
    let headerID = "headerView"
    let cellID = "Cell"
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        configureLayout()
        collectionView?.register(CollectionHeaderView.self, forSupplementaryViewOfKind: UICollectionView.elementKindSectionHeader, withReuseIdentifier: headerID)
        
        collectionView?.register(TestCell.self, forCellWithReuseIdentifier: self.cellID)
        collectionView?.delegate = self
        collectionView?.dataSource = self

    }
    
    func configureLayout(){
        let flowLayout = UICollectionViewFlowLayout()
        flowLayout.headerReferenceSize = CGSize(width: 0, height: 96)
        self.collectionView = UICollectionView(frame: CGRect(x: 0, y: 0, width: 500, height: 500), collectionViewLayout: flowLayout)
        self.view.addSubview(self.collectionView)
        collectionView?.translatesAutoresizingMaskIntoConstraints = false
        collectionView?.leadingAnchor.constraint(equalTo: self.view.leadingAnchor, constant: 16).isActive = true
        collectionView.trailingAnchor.constraint(equalTo: self.view.trailingAnchor, constant: -16).isActive = true
        collectionView.topAnchor.constraint(equalTo: self.view.topAnchor, constant: 24).isActive = true
        collectionView?.bottomAnchor.constraint(equalTo: self.view.bottomAnchor).isActive = true
    }

}

extension MainViewController: UICollectionViewDelegate, UICollectionViewDataSource{
    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        return 3
    }
    
    func numberOfSections(in collectionView: UICollectionView) -> Int {
        return 3
    }
    
    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        
        let cell = collectionView.dequeueReusableCell(withReuseIdentifier: cellID, for: indexPath) ?? UICollectionViewCell()
        return cell
    }
    
    
    func collectionView(_ collectionView: UICollectionView, viewForSupplementaryElementOfKind kind: String, at indexPath: IndexPath) -> UICollectionReusableView {
        
        if (kind == UICollectionView.elementKindSectionHeader){
            let headerView = collectionView.dequeueReusableSupplementaryView(ofKind: kind, withReuseIdentifier: headerID, for: indexPath) as! CollectionHeaderView
            headerView.setTitle(text: dummyHeaderData[indexPath.section])
            return headerView
        }
        return UICollectionReusableView()
    }
    

}


