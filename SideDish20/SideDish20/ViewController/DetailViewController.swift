//
//  DetailViewController.swift
//  SideDish20
//
//  Created by 백상휘 on 2022/04/26.
//

import UIKit

class DetailViewController: UIViewController {

    @IBOutlet weak var imageScrollView: UIScrollView!
    @IBOutlet weak var imageScrollViewPageControl: UIPageControl!
    
    @IBOutlet weak var specialMessageContainerView: UIView!
    
    @IBOutlet weak var quantityLabel: UILabel!
    
    @IBOutlet weak var orderButton: UIButton!
    
    @IBOutlet weak var detailImageStackView: UIStackView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        setPageImageView()
        setDetailImageView()
        
        specialMessageContainerView.layer.cornerRadius = 10
        orderButton.layer.cornerRadius = 12
        
        imageScrollView.delegate = self
    }
    
    func setPageImageView() {
        var rect = CGRect(x: 0, y: 0, width: view.frame.width, height: imageScrollView.frame.height)
        
        for sequence in 1...5 {
            guard let image = UIImage(named: "img0\(sequence)") else {
                continue
            }
            
            let imageView = UIImageView(frame: rect)
            imageView.image = image
            imageView.contentMode = .scaleAspectFit
            imageView.frame = rect
            imageScrollView.addSubview(imageView)
            rect = rect.offsetBy(dx: rect.width, dy: 0)
            imageScrollView.contentSize = CGSize(width: imageView.frame.maxX, height: imageScrollView.frame.height)
            imageScrollViewPageControl.numberOfPages = sequence
        }
        
        imageScrollView.setNeedsDisplay()
    }
    
    func setDetailImageView() {
        for sequence in 1...5 {
            let imageView = UIImageView(image: UIImage(named: "img0\(sequence)"))
            detailImageStackView.addArrangedSubview(imageView)
        }
    }
    
    @IBAction func quantityStepperValueChanged(_ sender: UIStepper) {
        let value = Int(sender.value)
        quantityLabel.text = "\(value)"
    }
    
    override func viewWillTransition(to size: CGSize, with coordinator: UIViewControllerTransitionCoordinator) {
        super.viewWillTransition(to: size, with: coordinator)
        
        let subViews = imageScrollView.subviews.filter({$0 is UIImageView})
        
        for (inx, imageView) in subViews.enumerated() {
            imageView.frame.size.width = size.width
            imageView.frame.origin.x = CGFloat(inx) * size.width
            imageScrollView.contentSize.width = imageView.frame.maxX
        }
        
        imageScrollView.setNeedsDisplay()
    }
}

extension DetailViewController: UIScrollViewDelegate {
    func scrollViewDidScroll(_ scrollView: UIScrollView) {
        let index = Int(scrollView.contentOffset.x / view.frame.width)
        imageScrollViewPageControl.currentPage = index
    }
}
