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
    @IBOutlet weak var detailView: UIView!
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
    }
}

private extension DetailViewController{
    func addSubViews(){
        self.fullSizeScrollView.addSubview(imageScrollView)
        self.fullSizeScrollView.addSubview(detailView)
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
        
        detailView.translatesAutoresizingMaskIntoConstraints = false
        detailView.topAnchor.constraint(equalTo: self.imageScrollView.bottomAnchor, constant: 24).isActive = true
        detailView.leadingAnchor.constraint(equalTo: self.fullSizeScrollView.leadingAnchor, constant: 16).isActive = true
        detailView.trailingAnchor.constraint(equalTo: self.fullSizeScrollView.trailingAnchor, constant: -16).isActive = true
        detailView.heightAnchor.constraint(equalToConstant: 553).isActive = true
    }
}
