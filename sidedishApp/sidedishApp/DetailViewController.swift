//
//  DetailViewController.swift
//  sidedishApp
//
//  Created by juntaek.oh on 2022/04/19.
//

import UIKit

class DetailViewController: UIViewController{
    @IBOutlet weak var fullSizeScrollView: UIScrollView!
    @IBOutlet weak var imageScrollView: UIScrollView!
    @IBOutlet weak var firstSectionView: UIView!
    @IBOutlet weak var secondSectionView: UIView!
    
    
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
        self.fullSizeScrollView.addSubview(imageScrollView)
        self.fullSizeScrollView.addSubview(firstSectionView)
        self.fullSizeScrollView.addSubview(secondSectionView)
        self.view.addSubview(fullSizeScrollView)
    }
    
    func configureLayout(){
        fullSizeScrollView.translatesAutoresizingMaskIntoConstraints = false
        fullSizeScrollView.leadingAnchor.constraint(equalTo: self.view.leadingAnchor).isActive = true
        fullSizeScrollView.topAnchor.constraint(equalTo: self.view.topAnchor).isActive = true
        fullSizeScrollView.widthAnchor.constraint(equalTo: self.view.widthAnchor).isActive = true
        fullSizeScrollView.heightAnchor.constraint(equalTo: self.view.heightAnchor).isActive = true
        
        imageScrollView.translatesAutoresizingMaskIntoConstraints = false
        imageScrollView.leadingAnchor.constraint(equalTo: self.fullSizeScrollView.leadingAnchor).isActive = true
        imageScrollView.topAnchor.constraint(equalTo: self.fullSizeScrollView.topAnchor).isActive = true
        imageScrollView.widthAnchor.constraint(equalTo: self.fullSizeScrollView.widthAnchor).isActive = true
        imageScrollView.heightAnchor.constraint(equalToConstant: 376).isActive = true
        
        firstSectionView.translatesAutoresizingMaskIntoConstraints = false
        firstSectionView.topAnchor.constraint(equalTo: self.imageScrollView.bottomAnchor, constant: 24).isActive = true
        firstSectionView.leadingAnchor.constraint(equalTo: self.fullSizeScrollView.leadingAnchor, constant: 16).isActive = true
        firstSectionView.trailingAnchor.constraint(equalTo: self.fullSizeScrollView.trailingAnchor, constant: -16).isActive = true
        firstSectionView.heightAnchor.constraint(equalToConstant: 176).isActive = true
        
        secondSectionView.translatesAutoresizingMaskIntoConstraints = false
        secondSectionView.topAnchor.constraint(equalTo: self.firstSectionView.bottomAnchor).isActive = true
        secondSectionView.leadingAnchor.constraint(equalTo: self.fullSizeScrollView.leadingAnchor, constant: 16).isActive = true
        secondSectionView.trailingAnchor.constraint(equalTo: self.fullSizeScrollView.trailingAnchor, constant: -16).isActive = true
        secondSectionView.heightAnchor.constraint(equalToConstant: 152).isActive = true
    }
}
