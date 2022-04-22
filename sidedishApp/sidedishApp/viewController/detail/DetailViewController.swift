//
//  DetailViewController.swift
//  sidedishApp
//
//  Created by juntaek.oh on 2022/04/19.
//

import UIKit

class DetailViewController: UIViewController {
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

private extension DetailViewController {
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
        NSLayoutConstraint.activate([
            fullSizeVerticalScrollView.leadingAnchor.constraint(equalTo: self.view.safeAreaLayoutGuide.leadingAnchor),
            fullSizeVerticalScrollView.trailingAnchor.constraint(equalTo: self.view.safeAreaLayoutGuide.trailingAnchor),
            fullSizeVerticalScrollView.topAnchor.constraint(equalTo: self.view.safeAreaLayoutGuide.topAnchor),
            fullSizeVerticalScrollView.bottomAnchor.constraint(equalTo: self.view.safeAreaLayoutGuide.bottomAnchor),
            fullSizeVerticalScrollView.contentLayoutGuide.leadingAnchor.constraint(equalTo: view.leadingAnchor),
            fullSizeVerticalScrollView.contentLayoutGuide.trailingAnchor.constraint(equalTo: view.trailingAnchor),
            fullSizeVerticalScrollView.contentLayoutGuide.topAnchor.constraint(equalTo: view.safeAreaLayoutGuide.topAnchor),
            fullSizeVerticalScrollView.contentLayoutGuide.heightAnchor.constraint(equalTo: stackView.heightAnchor)
        ])
    }
    
    func configureStackView() {
        stackView.translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate([
            stackView.leadingAnchor.constraint(equalTo: self.fullSizeVerticalScrollView.contentLayoutGuide.leadingAnchor),
            stackView.trailingAnchor.constraint(equalTo: self.fullSizeVerticalScrollView.contentLayoutGuide.trailingAnchor),
            stackView.topAnchor.constraint(equalTo: self.fullSizeVerticalScrollView.contentLayoutGuide.topAnchor),
            stackView.bottomAnchor.constraint(equalTo: self.fullSizeVerticalScrollView.contentLayoutGuide.bottomAnchor),
            stackView.widthAnchor.constraint(equalTo: self.fullSizeVerticalScrollView.widthAnchor),
            stackView.heightAnchor.constraint(equalToConstant: 977)
        ])
    }
    
    func configureImageScrollView() {
        imageHorizontalScrollView.translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate([
            imageHorizontalScrollView.leadingAnchor.constraint(equalTo: self.stackView.leadingAnchor),
            imageHorizontalScrollView.topAnchor.constraint(equalTo: self.stackView.topAnchor),
            imageHorizontalScrollView.trailingAnchor.constraint(equalTo: self.stackView.trailingAnchor),
            imageHorizontalScrollView.heightAnchor.constraint(equalToConstant: 376),
            imageHorizontalScrollView.widthAnchor.constraint(equalTo: self.stackView.widthAnchor)
        ])
    }
    
    func configureFirstSectionView() {
        firstSectionView.translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate([
            firstSectionView.topAnchor.constraint(equalTo: self.imageHorizontalScrollView.bottomAnchor, constant: 24),
            firstSectionView.leadingAnchor.constraint(equalTo: self.stackView.leadingAnchor, constant: 16),
            firstSectionView.trailingAnchor.constraint(equalTo: self.stackView.trailingAnchor, constant: -16),
            firstSectionView.heightAnchor.constraint(equalToConstant: 200)
        ])
    }
    
    func configureSecondSectionView() {
        secondSectionView.translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate([
            secondSectionView.topAnchor.constraint(equalTo: self.firstSectionView.bottomAnchor),
            secondSectionView.leadingAnchor.constraint(equalTo: self.stackView.leadingAnchor, constant: 16),
            secondSectionView.trailingAnchor.constraint(equalTo: self.stackView.trailingAnchor, constant: -16),
            secondSectionView.heightAnchor.constraint(equalToConstant: 152)
        ])
    }
    
    func configureThirdSectionView() {
        thirdSectionView.translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate([
            thirdSectionView.topAnchor.constraint(equalTo: self.secondSectionView.bottomAnchor),
            thirdSectionView.leadingAnchor.constraint(equalTo: self.stackView.leadingAnchor, constant: 16),
            thirdSectionView.trailingAnchor.constraint(equalTo: self.stackView.trailingAnchor, constant: -16),
            thirdSectionView.heightAnchor.constraint(equalToConstant: 250)
        ])
    }
}
