//
//  DetailViewController.swift
//  sidedishApp
//
//  Created by juntaek.oh on 2022/04/19.
//

import UIKit

class DetailViewController: UIViewController {
    
    static let identifier = "DetailViewController"
    
    @IBOutlet weak var fullSizeVerticalScrollView: UIScrollView!
    
    @IBOutlet weak var stackView: UIStackView!
    @IBOutlet weak var imageHorizontalCollectionView: UICollectionView!
    @IBOutlet weak var firstSectionView: UIView!
    @IBOutlet weak var secondSectionView: UIView!
    @IBOutlet weak var thirdSectionView: UIView!
    
    var selectedDish: MainCard.Body?
    var detailDish: DetailCard.Body.DetailCardData?
    
    override func viewDidLoad() {
        super.viewDidLoad()
        setViews()
        addNotification()
        self.imageHorizontalCollectionView.delegate = self
        self.imageHorizontalCollectionView.dataSource = self
        self.imageHorizontalCollectionView.register(UICollectionViewCell.self, forCellWithReuseIdentifier: "Cell")
    }
    
    override func viewDidAppear(_ animated: Bool) {
        guard let dish = detailDish else { return }
        SideDishManager.shared.getDetailDishImages(dish: dish)
    }
    
    override func viewWillDisappear(_ animated: Bool) {
        super.viewWillDisappear(animated)
        
        if self.isMovingFromParent {
            SideDishManager.shared.clearDetailImageThumbnail()
        }
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if segue.identifier == "firstSection" {
            guard let containerVC = segue.destination as? MainDescriptionViewController else { return }
            containerVC.setLabelTexts(main: selectedDish, detail: detailDish)
        } else if segue.identifier == "secondSection" {
            guard let containerVC = segue.destination as? SubDescriptionViewController else { return }
            containerVC.setLabelTexts(detail: detailDish)
        }
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
        imageHorizontalCollectionView.isPagingEnabled = true
        
        imageHorizontalCollectionView.translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate([
            imageHorizontalCollectionView.leadingAnchor.constraint(equalTo: self.stackView.leadingAnchor),
            imageHorizontalCollectionView.topAnchor.constraint(equalTo: self.stackView.topAnchor),
            imageHorizontalCollectionView.trailingAnchor.constraint(equalTo: self.stackView.trailingAnchor),
            imageHorizontalCollectionView.heightAnchor.constraint(equalToConstant: 376),
            imageHorizontalCollectionView.widthAnchor.constraint(equalTo: self.stackView.widthAnchor)
        ])
    }
    
    func configureFirstSectionView() {
        firstSectionView.translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate([
            firstSectionView.topAnchor.constraint(equalTo: self.imageHorizontalCollectionView.bottomAnchor, constant: 24),
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
    
    func addNotification() {
        NotificationCenter.default.addObserver(self, selector: #selector(reloadCollectionView), name: NSNotification.Name(rawValue: "detail"), object: SideDishManager.shared)
    }
    
    @objc
    func reloadCollectionView() {
        DispatchQueue.main.async {
            self.imageHorizontalCollectionView.reloadData()
        }
    }
}

extension DetailViewController: UICollectionViewDataSource {
    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        return SideDishManager.shared.detailImageThumbnail.count
    }
    
    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        let cell = collectionView.dequeueReusableCell(withReuseIdentifier: "Cell", for: indexPath)
        
        for data in SideDishManager.shared.detailImageThumbnail {
            let image = UIImage(data: data)
            let imageView = UIImageView(frame: CGRect(x: 0, y: 0, width: self.stackView.frame.width, height: 376))
            imageView.image = image
            cell.contentView.addSubview(imageView)
        }
        
        return cell
    }
}

extension DetailViewController: UICollectionViewDelegateFlowLayout {
    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, sizeForItemAt indexPath: IndexPath) -> CGSize {
        return CGSize(width: collectionView.frame.width, height: 376)
    }
}
