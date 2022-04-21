//
//  DetailTextViewController.swift
//  sidedishApp
//
//  Created by juntaek.oh on 2022/04/19.
//

import UIKit

class FirstSectionViewController: UIViewController {
    private var titleLabel: UILabel!
    private var subLabel: UILabel!
    private var salePrice: UILabel!
    private var rawPrice: UILabel!
    private var eventLabel: UILabel!
    private var sectionBottom: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        setAllProperties()
    }
}

private extension FirstSectionViewController {
    func setAllProperties() {
        configureTitle()
        configureSubLabel()
        configureSalePrice()
        configureRawPrice()
        configureEventLabel()
        configureSectionBottom()
    }
    
    func configureTitle() {
        titleLabel = UILabel()
        titleLabel.frame = CGRect(x: 0, y: 0, width: 343, height: 48)
        titleLabel.textColor = UIColor(red: 0.004, green: 0.004, blue: 0.004, alpha: 1)
        titleLabel.font = UIFont(name: "SFProDisplay-Regular", size: 32)
        titleLabel.baselineAdjustment = .alignCenters
        titleLabel.text = "오리 주물럭_반조리"
        self.view.addSubview(titleLabel)
        
        titleLabel.translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate([
            titleLabel.topAnchor.constraint(equalTo: self.view.topAnchor),
            titleLabel.leadingAnchor.constraint(equalTo: self.view.leadingAnchor),
            titleLabel.trailingAnchor.constraint(equalTo: self.view.trailingAnchor),
            titleLabel.heightAnchor.constraint(equalToConstant: 48)
        ])
    }
    
    func configureSubLabel() {
        subLabel = UILabel()
        subLabel.frame = CGRect(x: 0, y: 0, width: 177, height: 24)
        subLabel.textColor = UIColor(red: 0.51, green: 0.51, blue: 0.51, alpha: 1)
        subLabel.font = UIFont(name: "SFProDisplay-Regular", size: 18)
        subLabel.baselineAdjustment = .alignCenters
        subLabel.text = "감칠맛 나는 매콤한 양념"
        self.view.addSubview(subLabel)
        
        subLabel.translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate([
            subLabel.topAnchor.constraint(equalTo: self.titleLabel.bottomAnchor, constant: 8),
            subLabel.leadingAnchor.constraint(equalTo: self.view.leadingAnchor),
            subLabel.widthAnchor.constraint(equalToConstant: 177),
            subLabel.heightAnchor.constraint(equalToConstant: 24)
        ])
    }
    
    func configureSalePrice() {
        salePrice = UILabel()
        salePrice.frame = CGRect(x: 0, y: 0, width: 74, height: 24)
        salePrice.textColor = UIColor(red: 0.31, green: 0.31, blue: 0.31, alpha: 1)
        salePrice.font = UIFont(name: "SFProDisplay-Semibold", size: 18)
        salePrice.baselineAdjustment = .alignCenters
        salePrice.text = "12,640원"
        self.view.addSubview(salePrice)
        
        salePrice.translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate([
            salePrice.topAnchor.constraint(equalTo: self.subLabel.bottomAnchor, constant: 8),
            salePrice.leadingAnchor.constraint(equalTo: self.view.leadingAnchor),
            salePrice.widthAnchor.constraint(equalToConstant: 74),
            salePrice.heightAnchor.constraint(equalToConstant: 24)
        ])
    }
    
    func configureRawPrice() {
        rawPrice = UILabel()
        rawPrice.frame = CGRect(x: 0, y: 0, width: 64, height: 24)
        rawPrice.textColor = UIColor(red: 0.51, green: 0.51, blue: 0.51, alpha: 1)
        rawPrice.font = UIFont(name: "SFProDisplay-Regular", size: 16)
        setRawPriceAttribute(label: rawPrice, text: "15,800원")
        self.view.addSubview(rawPrice)
        
        rawPrice.translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate([
            rawPrice.topAnchor.constraint(equalTo: self.subLabel.bottomAnchor, constant: 8),
            rawPrice.leadingAnchor.constraint(equalTo: self.salePrice.trailingAnchor, constant: 8),
            rawPrice.widthAnchor.constraint(equalToConstant: 64),
            rawPrice.heightAnchor.constraint(equalToConstant: 24)
        ])
    }
    
    func configureEventLabel() {
        eventLabel = UILabel()
        eventLabel.frame = CGRect(x: 0, y: 0, width: 77, height: 24)
        eventLabel.clipsToBounds = true
        eventLabel.backgroundColor = UIColor(red: 0, green: 0.4, blue: 0.839, alpha: 1)
        eventLabel.layer.cornerRadius = 10
        eventLabel.textColor = UIColor(red: 1, green: 1, blue: 1, alpha: 1)
        eventLabel.font = UIFont(name: "SFProDisplay-Semibold", size: 12)
        eventLabel.textAlignment = .center
        eventLabel.baselineAdjustment = .alignCenters
        eventLabel.text = "런칭특가"
        self.view.addSubview(eventLabel)
        
        eventLabel.translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate([
            eventLabel.topAnchor.constraint(equalTo: self.salePrice.bottomAnchor, constant: 16),
            eventLabel.leadingAnchor.constraint(equalTo: self.view.leadingAnchor),
            eventLabel.widthAnchor.constraint(equalToConstant: 77),
            eventLabel.heightAnchor.constraint(equalToConstant: 24)
        ])
    }
    
    func configureSectionBottom() {
        sectionBottom = UILabel()
        sectionBottom.frame = CGRect(x: 0, y: 0, width: 343, height: 1)
        sectionBottom.layer.backgroundColor = UIColor(red: 0.878, green: 0.878, blue: 0.878, alpha: 1).cgColor
        self.view.addSubview(sectionBottom)
        
        sectionBottom.translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate([
            sectionBottom.topAnchor.constraint(equalTo: self.eventLabel.bottomAnchor, constant: 24),
            sectionBottom.leadingAnchor.constraint(equalTo: self.view.leadingAnchor),
            sectionBottom.trailingAnchor.constraint(equalTo: self.view.trailingAnchor),
            sectionBottom.heightAnchor.constraint(equalToConstant: 1),
            sectionBottom.bottomAnchor.constraint(equalTo: self.view.bottomAnchor)
        ])
    }
    
    func setRawPriceAttribute(label: UILabel, text: String) {
        let attributeString = NSMutableAttributedString(string: text)
        attributeString.addAttribute(.strikethroughStyle,
                                        value: NSUnderlineStyle.single.rawValue,
                                        range: NSMakeRange(0, attributeString.length))
        label.attributedText = attributeString
        label.baselineAdjustment = .alignCenters
    }
}
