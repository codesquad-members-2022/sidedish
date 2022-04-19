//
//  DetailViewController.swift
//  sidedishApp
//
//  Created by juntaek.oh on 2022/04/19.
//

import UIKit

class DetailViewController: UIViewController{
    @IBOutlet weak var fullSizeScrollView: UIScrollView!
    
    @IBOutlet weak var productInfoView: UIView!
    @IBOutlet weak var imageScrollView: UIScrollView!
    @IBOutlet weak var firstSectionView: UIView!
    @IBOutlet weak var secondSectionView: UIView!
    @IBOutlet weak var thirdSectionView: UIView!
    
    override func viewDidLoad(){
        super.viewDidLoad()
        setViews()
    }
}

private extension DetailViewController{
    func setViews(){
        addSubViews()
        configureLayout()
    }
    
    func addSubViews(){
        self.view.addSubview(fullSizeScrollView)
        self.productInfoView.addSubview(imageScrollView)
        self.productInfoView.addSubview(firstSectionView)
        self.productInfoView.addSubview(secondSectionView)
        self.productInfoView.addSubview(thirdSectionView)
        self.fullSizeScrollView.addSubview(productInfoView)
    }
    
    func configureLayout(){
        fullSizeScrollView.translatesAutoresizingMaskIntoConstraints = false
        fullSizeScrollView.leadingAnchor.constraint(equalTo: self.view.leadingAnchor).isActive = true
        fullSizeScrollView.trailingAnchor.constraint(equalTo: self.view.trailingAnchor).isActive = true
        fullSizeScrollView.topAnchor.constraint(equalTo: self.view.topAnchor).isActive = true
        fullSizeScrollView.bottomAnchor.constraint(equalTo: self.view.bottomAnchor).isActive = true
        
        productInfoView.translatesAutoresizingMaskIntoConstraints = false
        productInfoView.leadingAnchor.constraint(equalTo: self.fullSizeScrollView.leadingAnchor).isActive = true
        productInfoView.trailingAnchor.constraint(equalTo: self.fullSizeScrollView.trailingAnchor).isActive = true
        productInfoView.topAnchor.constraint(equalTo: self.fullSizeScrollView.topAnchor).isActive = true
        productInfoView.heightAnchor.constraint(equalToConstant: 977).isActive = true
        
        imageScrollView.translatesAutoresizingMaskIntoConstraints = false
        imageScrollView.leadingAnchor.constraint(equalTo: self.productInfoView.leadingAnchor).isActive = true
        imageScrollView.topAnchor.constraint(equalTo: self.productInfoView.topAnchor).isActive = true
        imageScrollView.widthAnchor.constraint(equalTo: self.productInfoView.widthAnchor).isActive = true
        imageScrollView.heightAnchor.constraint(equalToConstant: 376).isActive = true
        
        firstSectionView.translatesAutoresizingMaskIntoConstraints = false
        firstSectionView.topAnchor.constraint(equalTo: self.imageScrollView.bottomAnchor, constant: 24).isActive = true
        firstSectionView.leadingAnchor.constraint(equalTo: self.productInfoView.leadingAnchor, constant: 16).isActive = true
        firstSectionView.trailingAnchor.constraint(equalTo: self.productInfoView.trailingAnchor, constant: -16).isActive = true
        firstSectionView.heightAnchor.constraint(equalToConstant: 176).isActive = true
        
        secondSectionView.translatesAutoresizingMaskIntoConstraints = false
        secondSectionView.topAnchor.constraint(equalTo: self.firstSectionView.bottomAnchor).isActive = true
        secondSectionView.leadingAnchor.constraint(equalTo: self.productInfoView.leadingAnchor, constant: 16).isActive = true
        secondSectionView.trailingAnchor.constraint(equalTo: self.productInfoView.trailingAnchor, constant: -16).isActive = true
        secondSectionView.heightAnchor.constraint(equalToConstant: 152).isActive = true
        
        secondSectionView.translatesAutoresizingMaskIntoConstraints = false
        secondSectionView.topAnchor.constraint(equalTo: self.secondSectionView.bottomAnchor).isActive = true
        secondSectionView.bottomAnchor.constraint(equalTo: self.productInfoView.bottomAnchor).isActive = true
        secondSectionView.leadingAnchor.constraint(equalTo: self.productInfoView.leadingAnchor, constant: 16).isActive = true
        secondSectionView.trailingAnchor.constraint(equalTo: self.productInfoView.trailingAnchor, constant: -16).isActive = true
    }
}
