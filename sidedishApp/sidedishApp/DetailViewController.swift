//
//  DetailViewController.swift
//  sidedishApp
//
//  Created by juntaek.oh on 2022/04/19.
//

import UIKit

class DetailViewController: UIViewController{
    @IBOutlet weak var fullSizeScrollView: UIScrollView!
    
    @IBOutlet weak var stackView: UIStackView!
    @IBOutlet weak var imageScrollView: UIScrollView!
    @IBOutlet weak var firstSectionView: UIView!
    @IBOutlet weak var secondSectionView: UIView!
    @IBOutlet weak var thirdSectionView: UIView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        setViews()
    }
}

private extension DetailViewController{
    func setViews() {
        configureFullSizeScrollView()
        configureStackView()
        configureImageScrollView()
        configureFirstSectionView()
        configureSecondSectionView()
        configureThirdSectionView()
    }
    
    func configureFullSizeScrollView() {
        fullSizeScrollView.backgroundColor = .yellow
        
        fullSizeScrollView.translatesAutoresizingMaskIntoConstraints = false
        fullSizeScrollView.leadingAnchor.constraint(equalTo: self.view.safeAreaLayoutGuide.leadingAnchor).isActive = true
        fullSizeScrollView.trailingAnchor.constraint(equalTo: self.view.safeAreaLayoutGuide.trailingAnchor).isActive = true
        fullSizeScrollView.topAnchor.constraint(equalTo: self.view.safeAreaLayoutGuide.topAnchor).isActive = true
        fullSizeScrollView.bottomAnchor.constraint(equalTo: self.view.safeAreaLayoutGuide.bottomAnchor).isActive = true
        
        fullSizeScrollView.contentLayoutGuide.leadingAnchor.constraint(equalTo: view.leadingAnchor).isActive = true
        fullSizeScrollView.contentLayoutGuide.trailingAnchor.constraint(equalTo: view.trailingAnchor).isActive = true
        fullSizeScrollView.contentLayoutGuide.topAnchor.constraint(equalTo: view.safeAreaLayoutGuide.topAnchor).isActive = true
        fullSizeScrollView.contentLayoutGuide.heightAnchor.constraint(equalTo: stackView.heightAnchor).isActive = true
    }
    
    func configureStackView() {
        stackView.backgroundColor = .brown
        
        stackView.translatesAutoresizingMaskIntoConstraints = false
        stackView.leadingAnchor.constraint(equalTo: self.fullSizeScrollView.contentLayoutGuide.leadingAnchor).isActive = true
        stackView.trailingAnchor.constraint(equalTo: self.fullSizeScrollView.contentLayoutGuide.trailingAnchor).isActive = true
        stackView.topAnchor.constraint(equalTo: self.fullSizeScrollView.contentLayoutGuide.topAnchor).isActive = true
        stackView.bottomAnchor.constraint(equalTo: self.fullSizeScrollView.contentLayoutGuide.bottomAnchor).isActive = true
        stackView.widthAnchor.constraint(equalTo: self.fullSizeScrollView.widthAnchor).isActive = true
        stackView.heightAnchor.constraint(equalToConstant: 977).isActive = true
    }
    
    func configureImageScrollView() {
        imageScrollView.backgroundColor = .blue
        
        imageScrollView.translatesAutoresizingMaskIntoConstraints = false
        imageScrollView.leadingAnchor.constraint(equalTo: self.stackView.leadingAnchor).isActive = true
        imageScrollView.topAnchor.constraint(equalTo: self.stackView.topAnchor).isActive = true
        imageScrollView.trailingAnchor.constraint(equalTo: self.stackView.trailingAnchor).isActive = true
        imageScrollView.heightAnchor.constraint(equalToConstant: 376).isActive = true
        imageScrollView.widthAnchor.constraint(equalTo: self.stackView.widthAnchor).isActive = true
    }
    
    func configureFirstSectionView() {
        firstSectionView.translatesAutoresizingMaskIntoConstraints = false
        firstSectionView.topAnchor.constraint(equalTo: self.imageScrollView.bottomAnchor, constant: 24).isActive = true
        firstSectionView.leadingAnchor.constraint(equalTo: self.stackView.leadingAnchor, constant: 16).isActive = true
        firstSectionView.trailingAnchor.constraint(equalTo: self.stackView.trailingAnchor, constant: -16).isActive = true
        firstSectionView.heightAnchor.constraint(equalToConstant: 176).isActive = true
    }
    
    func configureSecondSectionView() {
        secondSectionView.translatesAutoresizingMaskIntoConstraints = false
        secondSectionView.topAnchor.constraint(equalTo: self.firstSectionView.bottomAnchor).isActive = true
        secondSectionView.leadingAnchor.constraint(equalTo: self.stackView.leadingAnchor, constant: 16).isActive = true
        secondSectionView.trailingAnchor.constraint(equalTo: self.stackView.trailingAnchor, constant: -16).isActive = true
        secondSectionView.heightAnchor.constraint(equalToConstant: 152).isActive = true
    }
    
    func configureThirdSectionView() {
        thirdSectionView.translatesAutoresizingMaskIntoConstraints = false
        thirdSectionView.topAnchor.constraint(equalTo: self.secondSectionView.bottomAnchor).isActive = true
        thirdSectionView.leadingAnchor.constraint(equalTo: self.stackView.leadingAnchor, constant: 16).isActive = true
        thirdSectionView.trailingAnchor.constraint(equalTo: self.stackView.trailingAnchor, constant: -16).isActive = true
        thirdSectionView.heightAnchor.constraint(equalToConstant: 176).isActive = true
    }
}
