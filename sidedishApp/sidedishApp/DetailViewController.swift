//
//  DetailViewController.swift
//  sidedishApp
//
//  Created by juntaek.oh on 2022/04/19.
//

import UIKit

class DetailViewController: UIViewController{
    @IBOutlet weak var fullSizeVerticalScrollView: UIScrollView!
    
    @IBOutlet weak var stackView: UIStackView!
    @IBOutlet weak var imageHorizontalScrollView: UIScrollView!
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
        fullSizeVerticalScrollView.translatesAutoresizingMaskIntoConstraints = false
        fullSizeVerticalScrollView.leadingAnchor.constraint(equalTo: self.view.safeAreaLayoutGuide.leadingAnchor).isActive = true
        fullSizeVerticalScrollView.trailingAnchor.constraint(equalTo: self.view.safeAreaLayoutGuide.trailingAnchor).isActive = true
        fullSizeVerticalScrollView.topAnchor.constraint(equalTo: self.view.safeAreaLayoutGuide.topAnchor).isActive = true
        fullSizeVerticalScrollView.bottomAnchor.constraint(equalTo: self.view.safeAreaLayoutGuide.bottomAnchor).isActive = true
        
        fullSizeVerticalScrollView.contentLayoutGuide.leadingAnchor.constraint(equalTo: view.leadingAnchor).isActive = true
        fullSizeVerticalScrollView.contentLayoutGuide.trailingAnchor.constraint(equalTo: view.trailingAnchor).isActive = true
        fullSizeVerticalScrollView.contentLayoutGuide.topAnchor.constraint(equalTo: view.safeAreaLayoutGuide.topAnchor).isActive = true
        fullSizeVerticalScrollView.contentLayoutGuide.heightAnchor.constraint(equalTo: stackView.heightAnchor).isActive = true
    }
    
    func configureStackView() {
        stackView.translatesAutoresizingMaskIntoConstraints = false
        stackView.leadingAnchor.constraint(equalTo: self.fullSizeVerticalScrollView.contentLayoutGuide.leadingAnchor).isActive = true
        stackView.trailingAnchor.constraint(equalTo: self.fullSizeVerticalScrollView.contentLayoutGuide.trailingAnchor).isActive = true
        stackView.topAnchor.constraint(equalTo: self.fullSizeVerticalScrollView.contentLayoutGuide.topAnchor).isActive = true
        stackView.bottomAnchor.constraint(equalTo: self.fullSizeVerticalScrollView.contentLayoutGuide.bottomAnchor).isActive = true
        stackView.widthAnchor.constraint(equalTo: self.fullSizeVerticalScrollView.widthAnchor).isActive = true
        stackView.heightAnchor.constraint(equalToConstant: 977).isActive = true
    }
    
    func configureImageScrollView() {
        imageHorizontalScrollView.translatesAutoresizingMaskIntoConstraints = false
        imageHorizontalScrollView.leadingAnchor.constraint(equalTo: self.stackView.leadingAnchor).isActive = true
        imageHorizontalScrollView.topAnchor.constraint(equalTo: self.stackView.topAnchor).isActive = true
        imageHorizontalScrollView.trailingAnchor.constraint(equalTo: self.stackView.trailingAnchor).isActive = true
        imageHorizontalScrollView.heightAnchor.constraint(equalToConstant: 376).isActive = true
        imageHorizontalScrollView.widthAnchor.constraint(equalTo: self.stackView.widthAnchor).isActive = true
    }
    
    func configureFirstSectionView() {
        firstSectionView.translatesAutoresizingMaskIntoConstraints = false
        firstSectionView.topAnchor.constraint(equalTo: self.imageHorizontalScrollView.bottomAnchor, constant: 24).isActive = true
        firstSectionView.leadingAnchor.constraint(equalTo: self.stackView.leadingAnchor, constant: 16).isActive = true
        firstSectionView.trailingAnchor.constraint(equalTo: self.stackView.trailingAnchor, constant: -16).isActive = true
        firstSectionView.heightAnchor.constraint(equalToConstant: 200).isActive = true
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
        thirdSectionView.heightAnchor.constraint(equalToConstant: 250).isActive = true
    }
}
