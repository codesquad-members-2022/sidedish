//
//  ThirdSectionViewController.swift
//  sidedishApp
//
//  Created by juntaek.oh on 2022/04/19.
//

import UIKit

class ThirdSectionViewController: UIViewController{
    private var countLabel: UILabel!
    private var countText: UILabel!
    private var countStepper: UIStepper!
    private var sectionBottom: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.view.frame = CGRect(x: 0, y: 0, width: 343, height: 176)
        setAllProperties()
    }
}

private extension ThirdSectionViewController{
    func setAllProperties() {
        configureCountLabel()
        configureCountText()
        configureCountStepper()
        configureSectionBottom()
        // 총주문금액, 주문하기 구현 필요
    }
    
    func configureCountLabel() {
        countLabel = UILabel()
        countLabel.frame = CGRect(x: 0, y: 0, width: 60, height: 24)
        countLabel.textColor = UIColor(red: 0.51, green: 0.51, blue: 0.51, alpha: 1)
        countLabel.font = UIFont(name: "SFProDisplay-Regular", size: 14)
        setTextAttribute(label: countLabel, text: "수량")
        self.view.addSubview(countLabel)
        
        countLabel.translatesAutoresizingMaskIntoConstraints = false
        countLabel.topAnchor.constraint(equalTo: self.view.topAnchor, constant: 26).isActive = true
        countLabel.leadingAnchor.constraint(equalTo: self.view.leadingAnchor).isActive = true
        countLabel.widthAnchor.constraint(equalToConstant: 60).isActive = true
        countLabel.heightAnchor.constraint(equalToConstant: 24).isActive = true
    }
    
    func configureCountText() {
        countText = UILabel()
        countText.frame = CGRect(x: 0, y: 0, width: 9, height: 24)
        countText.textColor = UIColor(red: 0.31, green: 0.31, blue: 0.31, alpha: 1)
        countText.font = UIFont(name: "SFProDisplay-Regular", size: 18)
        setTextAttribute(label: countText, text: "1")
        self.view.addSubview(countText)
        
        countText.translatesAutoresizingMaskIntoConstraints = false
        countText.topAnchor.constraint(equalTo: self.view.topAnchor, constant: 26).isActive = true
        countText.leadingAnchor.constraint(equalTo: self.countLabel.trailingAnchor, constant: 150).isActive = true
        countText.widthAnchor.constraint(equalToConstant: 9).isActive = true
        countText.heightAnchor.constraint(equalToConstant: 24).isActive = true
    }
    
    func configureCountStepper() {
        countStepper = UIStepper()
        countStepper.frame = CGRect(x: 0, y: 0, width: 100, height: 28)
        countStepper.layer.backgroundColor = UIColor(red: 0.961, green: 0.961, blue: 0.969, alpha: 1).cgColor
        countStepper.layer.cornerRadius = 7.92
        self.view.addSubview(countStepper)
        
        countStepper.translatesAutoresizingMaskIntoConstraints = false
        countStepper.topAnchor.constraint(equalTo: self.view.topAnchor, constant: 26).isActive = true
        countStepper.leadingAnchor.constraint(equalTo: self.countText.trailingAnchor, constant: 24).isActive = true
        countStepper.trailingAnchor.constraint(equalTo: self.view.trailingAnchor).isActive = true
        countStepper.heightAnchor.constraint(equalToConstant: 28).isActive = true
    }
    
    func configureSectionBottom() {
        sectionBottom = UILabel()
        sectionBottom.frame = CGRect(x: 0, y: 0, width: 343, height: 1)
        sectionBottom.layer.backgroundColor = UIColor(red: 0.878, green: 0.878, blue: 0.878, alpha: 1).cgColor
        self.view.addSubview(sectionBottom)
        
        sectionBottom.translatesAutoresizingMaskIntoConstraints = false
        sectionBottom.topAnchor.constraint(equalTo: self.countLabel.bottomAnchor, constant: 26).isActive = true
        sectionBottom.leadingAnchor.constraint(equalTo: self.view.leadingAnchor).isActive = true
        sectionBottom.trailingAnchor.constraint(equalTo: self.view.trailingAnchor).isActive = true
        sectionBottom.heightAnchor.constraint(equalToConstant: 1).isActive = true
    }
    
    func setTextAttribute(label: UILabel, text: String) {
        let paragraphStyle = NSMutableParagraphStyle()
        paragraphStyle.lineHeightMultiple = 1.44
        
        label.attributedText = NSMutableAttributedString(string: text, attributes: [NSAttributedString.Key.paragraphStyle: paragraphStyle])
    }
}
