//
//  DetailTextViewController.swift
//  sidedishApp
//
//  Created by juntaek.oh on 2022/04/19.
//

import UIKit

class FirstSectionViewController: UIViewController{
    private var firstSection = UIView(frame: CGRect(x: 0, y: 0, width: 343, height: 176))
    private var titleLabel: UILabel!
    private var subLabel: UILabel!
    private var salePrice: UILabel!
    private var rawPrice: UILabel!
    private var eventLabel: UILabel!
    private var sectionBottom: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.view.frame = CGRect(x: 0, y: 0, width: 343, height: 176)
        setAllProperties()
        self.view.addSubview(firstSection)
    }
}

private extension FirstSectionViewController{
    func setAllProperties(){
        configureTitle()
        configureSubLabel()
        configureSalePrice()
        configureRawPrice()
        configureEventLabel()
        configureSectionBottom()
    }
    
    func configureTitle(){
        titleLabel = UILabel()
        titleLabel.textColor = UIColor(red: 0.004, green: 0.004, blue: 0.004, alpha: 1)
        titleLabel.font = UIFont(name: "SFProDisplay-Regular", size: 32)
        setTextAttribute(label: titleLabel, text: "오리 주물럭_반조리")
        self.firstSection.addSubview(titleLabel)
        
        titleLabel.translatesAutoresizingMaskIntoConstraints = false
        titleLabel.topAnchor.constraint(equalTo: self.firstSection.topAnchor).isActive = true
        titleLabel.leadingAnchor.constraint(equalTo: self.firstSection.leadingAnchor).isActive = true
        titleLabel.trailingAnchor.constraint(equalTo: self.firstSection.trailingAnchor).isActive = true
        titleLabel.heightAnchor.constraint(equalToConstant: 48).isActive = true
    }
    
    func configureSubLabel(){
        subLabel = UILabel()
        subLabel.frame = CGRect(x: 0, y: 0, width: 177, height: 24)
        subLabel.textColor = UIColor(red: 0.51, green: 0.51, blue: 0.51, alpha: 1)
        subLabel.font = UIFont(name: "SFProDisplay-Regular", size: 18)
        setTextAttribute(label: subLabel, text: "감칠맛 나는 매콤한 양념")
        self.firstSection.addSubview(subLabel)
        
        subLabel.translatesAutoresizingMaskIntoConstraints = false
        subLabel.topAnchor.constraint(equalTo: self.titleLabel.bottomAnchor, constant: 8).isActive = true
        subLabel.leadingAnchor.constraint(equalTo: self.firstSection.leadingAnchor).isActive = true
        subLabel.widthAnchor.constraint(equalToConstant: 177).isActive = true
        subLabel.heightAnchor.constraint(equalToConstant: 24).isActive = true
    }
    
    func configureSalePrice(){
        salePrice = UILabel()
        salePrice.frame = CGRect(x: 0, y: 0, width: 74, height: 24)
        salePrice.textColor = UIColor(red: 0.31, green: 0.31, blue: 0.31, alpha: 1)
        salePrice.font = UIFont(name: "SFProDisplay-Semibold", size: 18)
        setTextAttribute(label: salePrice, text: "12,640원")
        self.firstSection.addSubview(salePrice)
        
        salePrice.translatesAutoresizingMaskIntoConstraints = false
        salePrice.topAnchor.constraint(equalTo: self.subLabel.bottomAnchor, constant: 8).isActive = true
        salePrice.leadingAnchor.constraint(equalTo: self.firstSection.leadingAnchor).isActive = true
        salePrice.widthAnchor.constraint(equalToConstant: 74).isActive = true
        salePrice.heightAnchor.constraint(equalToConstant: 24).isActive = true
    }
    
    func configureRawPrice(){
        rawPrice = UILabel()
        rawPrice.frame = CGRect(x: 0, y: 0, width: 64, height: 24)
        rawPrice.textColor = UIColor(red: 0.51, green: 0.51, blue: 0.51, alpha: 1)
        rawPrice.font = UIFont(name: "SFProDisplay-Regular", size: 16)
        setRawPriceAttribute(label: rawPrice, text: "12,640원")
        self.firstSection.addSubview(rawPrice)
        
        rawPrice.translatesAutoresizingMaskIntoConstraints = false
        rawPrice.topAnchor.constraint(equalTo: self.subLabel.bottomAnchor, constant: 8).isActive = true
        rawPrice.leadingAnchor.constraint(equalTo: self.salePrice.trailingAnchor, constant: 8).isActive = true
        rawPrice.widthAnchor.constraint(equalToConstant: 64).isActive = true
        rawPrice.heightAnchor.constraint(equalToConstant: 24).isActive = true
    }
    
    func configureEventLabel(){
        eventLabel = UILabel()
        eventLabel.frame = CGRect(x: 0, y: 0, width: 77, height: 24)
        eventLabel.layer.backgroundColor = UIColor(red: 0, green: 0.4, blue: 0.839, alpha: 1).cgColor
        eventLabel.layer.cornerRadius = 100
        eventLabel.textColor = UIColor(red: 1, green: 1, blue: 1, alpha: 1)
        eventLabel.font = UIFont(name: "SFProDisplay-Semibold", size: 12)
        eventLabel.textAlignment = .center
        setEventLabelAttribute(label: eventLabel, text: "런칭특가")
        self.firstSection.addSubview(eventLabel)
        
        eventLabel.translatesAutoresizingMaskIntoConstraints = false
        eventLabel.topAnchor.constraint(equalTo: self.salePrice.bottomAnchor, constant: 16).isActive = true
        eventLabel.leadingAnchor.constraint(equalTo: self.firstSection.leadingAnchor).isActive = true
        eventLabel.widthAnchor.constraint(equalToConstant: 77).isActive = true
        eventLabel.heightAnchor.constraint(equalToConstant: 24).isActive = true
    }
    
    func configureSectionBottom(){
        sectionBottom = UILabel()
        sectionBottom.frame = CGRect(x: 0, y: 0, width: 343, height: 1)
        sectionBottom.layer.backgroundColor = UIColor(red: 0.878, green: 0.878, blue: 0.878, alpha: 1).cgColor
        self.firstSection.addSubview(sectionBottom)
        
        sectionBottom.translatesAutoresizingMaskIntoConstraints = false
        sectionBottom.topAnchor.constraint(equalTo: self.eventLabel.bottomAnchor, constant: 24).isActive = true
        sectionBottom.leadingAnchor.constraint(equalTo: self.firstSection.leadingAnchor).isActive = true
        sectionBottom.trailingAnchor.constraint(equalTo: self.firstSection.trailingAnchor).isActive = true
        sectionBottom.bottomAnchor.constraint(equalTo: self.firstSection.bottomAnchor).isActive = true
    }
    
    func setTextAttribute(label: UILabel, text: String){
        let paragraphStyle = NSMutableParagraphStyle()
        paragraphStyle.lineHeightMultiple = 1.26
        
        label.attributedText = NSMutableAttributedString(string: text, attributes: [NSAttributedString.Key.paragraphStyle: paragraphStyle])
    }
    
    func setRawPriceAttribute(label: UILabel, text: String){
        let paragraphStyle = NSMutableParagraphStyle()
        paragraphStyle.lineHeightMultiple = 1.26
        
        label.attributedText = NSMutableAttributedString(string: text, attributes: [NSAttributedString.Key.strikethroughStyle: NSUnderlineStyle.single.rawValue, NSAttributedString.Key.paragraphStyle: paragraphStyle])
    }
    
    func setEventLabelAttribute(label: UILabel, text: String){
        let paragraphStyle = NSMutableParagraphStyle()
        paragraphStyle.lineHeightMultiple = 1.12
        
        label.attributedText = NSMutableAttributedString(string: text, attributes: [NSAttributedString.Key.kern: 0.25, NSAttributedString.Key.paragraphStyle: paragraphStyle])
    }
}
