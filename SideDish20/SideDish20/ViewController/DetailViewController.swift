//
//  DetailViewController.swift
//  SideDish20
//
//  Created by 백상휘 on 2022/04/26.
//

import UIKit

class DetailViewController: UIViewController {

    @IBOutlet weak var imageCollectionView: UICollectionView!
    @IBOutlet weak var imageCollectionViewFlowLayout: UICollectionViewFlowLayout!
    
    @IBOutlet weak var imageScrollViewPageControl: UIPageControl!
    
    @IBOutlet weak var specialMessageContainerView: UIView!
    
    @IBOutlet weak var quantityLabel: UILabel!
    
    @IBOutlet weak var orderButton: UIButton!
    
    @IBOutlet weak var detailImageStackView: UIStackView!
    @IBOutlet weak var detailImageStackViewConstraintHeight: NSLayoutConstraint!
    
    private let imageCellIdentifier = String(describing: HomeDetailCollectionViewCell.self)
    private var safeAreaInset: UILayoutGuide!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.safeAreaInset = view.safeAreaLayoutGuide
        setDetailImageView()
        
        specialMessageContainerView.layer.cornerRadius = 10
        orderButton.layer.cornerRadius = 12
        
        let nibName = UINib(nibName: imageCellIdentifier, bundle: nil)
        imageCollectionView.register(nibName, forCellWithReuseIdentifier: imageCellIdentifier)
        
        imageCollectionViewFlowLayout.minimumInteritemSpacing = 0
        imageCollectionViewFlowLayout.itemSize = CGSize(
            width: view.frame.width,
            height: imageCollectionView.frame.height
        )
    }
    
    func setDetailImageView() {
        
        detailImageStackViewConstraintHeight.constant = 0
        
        for sequence in 1...5 {
            let image = UIImage(named: "img0\(sequence)")
            let imageView = UIImageView(image: image)
            imageView.contentMode = .scaleAspectFit
            
            detailImageStackViewConstraintHeight.constant += imageView.frame.height
            detailImageStackView.addArrangedSubview(imageView)
        }
    }
    
    @IBAction func quantityStepperValueChanged(_ sender: UIStepper) {
        let value = Int(sender.value)
        quantityLabel.text = "\(value)"
    }
    
    override func viewWillTransition(to size: CGSize, with coordinator: UIViewControllerTransitionCoordinator) {
        super.viewWillTransition(to: size, with: coordinator)
        imageCollectionViewFlowLayout.itemSize.width = size.width
        if UIDevice.current.orientation.isLandscape {
            imageCollectionViewFlowLayout.itemSize.width -= safeAreaInset.layoutFrame.minY
        }
        
        imageCollectionView.scrollToItem(at: IndexPath(item: 0, section: 0), at: .left, animated: true)
    }
}

extension DetailViewController: UICollectionViewDelegate, UICollectionViewDataSource {
    func collectionView(_ collectionView: UICollectionView,
                        numberOfItemsInSection section: Int) -> Int {
        
        imageScrollViewPageControl.numberOfPages = 5
        
        return 5
    }
    
    func collectionView(_ collectionView: UICollectionView,
                        cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        
        let cell = collectionView.dequeueReusableCell(withReuseIdentifier: imageCellIdentifier, for: indexPath)
        
        guard let cell = cell as? HomeDetailCollectionViewCell else {
            return UICollectionViewCell()
        }
        
        cell.setImage(image: UIImage(named: "img0\(indexPath.item+1)"))
        
        return cell
    }
}

extension DetailViewController: UIScrollViewDelegate {
    func scrollViewDidScroll(_ scrollView: UIScrollView) {
        let index = Int(scrollView.contentOffset.x / scrollView.frame.width)
        imageScrollViewPageControl.currentPage = index
    }
}
