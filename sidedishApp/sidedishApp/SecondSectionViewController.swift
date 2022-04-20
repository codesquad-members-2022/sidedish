//
//  SecondSectionViewController.swift
//  sidedishApp
//
//  Created by juntaek.oh on 2022/04/19.
//

import UIKit

class SecondSectionViewController: UIViewController{
    private var secondSection = UIView(frame: CGRect(x: 0, y: 0, width: 343, height: 152))
    private var pointLabel: UILabel!
    private var pointText: UILabel!
    private var deliveryLabel: UILabel!
    private var deliveryText: UILabel!
    private var chargeLabel: UILabel!
    private var chargeText: UILabel!
    private var sectionBottom: UILabel!
    
    override func viewDidLoad(){
        super.viewDidLoad()
        self.view.frame = CGRect(x: 0, y: 0, width: 343, height: 152)
        self.view.addSubview(secondSection)
        setAllProperties()
    }
}

private extension SecondSectionViewController{
    func setAllProperties(){
        configurePointLabel()
        configurePointText()
        configureDeliveryLabel()
        configureDeliveryText()
        configureChargeLabel()
        configureChargeText()
        configureSectionBottom()
    }
    
    func configurePointLabel(){
        pointLabel = UILabel()
        setLabelAttribute(label: pointLabel, text: "적립금")
        self.secondSection.addSubview(pointLabel)
        
        pointLabel.translatesAutoresizingMaskIntoConstraints = false
        pointLabel.topAnchor.constraint(equalTo: self.secondSection.bottomAnchor, constant: 24).isActive = true
        pointLabel.leadingAnchor.constraint(equalTo: self.secondSection.leadingAnchor).isActive = true
        pointLabel.widthAnchor.constraint(equalToConstant: 60).isActive = true
        pointLabel.heightAnchor.constraint(equalToConstant: 24).isActive = true
    }
    
    func configurePointText(){
        pointText = UILabel()
        setTextAttribute(label: pointText, text: "126원")
        self.secondSection.addSubview(pointText)
        
        pointText.translatesAutoresizingMaskIntoConstraints = false
        pointText.topAnchor.constraint(equalTo: self.secondSection.bottomAnchor, constant: 24).isActive = true
        pointText.leadingAnchor.constraint(equalTo: self.pointLabel.trailingAnchor, constant: 16).isActive = true
        pointText.trailingAnchor.constraint(equalTo: self.secondSection.trailingAnchor).isActive = true
        pointText.heightAnchor.constraint(equalToConstant: 24).isActive = true
    }
    
    func configureDeliveryLabel(){
        deliveryLabel = UILabel()
        setLabelAttribute(label: deliveryLabel, text: "배송정보")
        self.secondSection.addSubview(deliveryLabel)
        
        deliveryLabel.translatesAutoresizingMaskIntoConstraints = false
        deliveryLabel.topAnchor.constraint(equalTo: self.pointLabel.bottomAnchor, constant: 16).isActive = true
        deliveryLabel.leadingAnchor.constraint(equalTo: self.secondSection.leadingAnchor).isActive = true
        deliveryLabel.widthAnchor.constraint(equalToConstant: 60).isActive = true
        deliveryLabel.heightAnchor.constraint(equalToConstant: 24).isActive = true
    }
    
    func configureDeliveryText(){
        deliveryText = UILabel()
        setTextAttribute(label: deliveryText, text: "서울 경기 새벽 배송, 전국 택배 배송")
        self.secondSection.addSubview(deliveryText)
        
        deliveryText.translatesAutoresizingMaskIntoConstraints = false
        deliveryText.topAnchor.constraint(equalTo: self.pointText.bottomAnchor, constant: 16).isActive = true
        deliveryText.leadingAnchor.constraint(equalTo: self.deliveryLabel.trailingAnchor, constant: 16).isActive = true
        deliveryText.trailingAnchor.constraint(equalTo: self.secondSection.trailingAnchor).isActive = true
        deliveryText.heightAnchor.constraint(equalToConstant: 24).isActive = true
    }
    
    func configureChargeLabel(){
        chargeLabel = UILabel()
        setLabelAttribute(label: chargeLabel, text: "배송비")
        self.secondSection.addSubview(chargeLabel)
        
        chargeLabel.translatesAutoresizingMaskIntoConstraints = false
        chargeLabel.topAnchor.constraint(equalTo: self.deliveryLabel.bottomAnchor, constant: 16).isActive = true
        chargeLabel.leadingAnchor.constraint(equalTo: self.secondSection.leadingAnchor).isActive = true
        chargeLabel.widthAnchor.constraint(equalToConstant: 60).isActive = true
        chargeLabel.heightAnchor.constraint(equalToConstant: 24).isActive = true
    }
    
    func configureChargeText(){
        chargeText = UILabel()
        setTextAttribute(label: chargeText, text: "2,500원 (40,000원 이상 구매 시 무료)")
        self.secondSection.addSubview(chargeText)
        
        chargeText.translatesAutoresizingMaskIntoConstraints = false
        chargeText.topAnchor.constraint(equalTo: self.deliveryText.bottomAnchor, constant: 16).isActive = true
        chargeText.leadingAnchor.constraint(equalTo: self.chargeLabel.trailingAnchor, constant: 16).isActive = true
        chargeText.trailingAnchor.constraint(equalTo: self.secondSection.trailingAnchor).isActive = true
        chargeText.heightAnchor.constraint(equalToConstant: 24).isActive = true
    }
    
    func configureSectionBottom(){
        sectionBottom = UILabel()
        sectionBottom.frame = CGRect(x: 0, y: 0, width: 343, height: 1)
        sectionBottom.layer.backgroundColor = UIColor(red: 0.878, green: 0.878, blue: 0.878, alpha: 1).cgColor
        self.secondSection.addSubview(sectionBottom)
        
        sectionBottom.translatesAutoresizingMaskIntoConstraints = false
        sectionBottom.topAnchor.constraint(equalTo: self.chargeLabel.bottomAnchor, constant: 24).isActive = true
        sectionBottom.leadingAnchor.constraint(equalTo: self.secondSection.leadingAnchor).isActive = true
        sectionBottom.trailingAnchor.constraint(equalTo: self.secondSection.trailingAnchor).isActive = true
        sectionBottom.bottomAnchor.constraint(equalTo: self.secondSection.bottomAnchor).isActive = true
    }
    
    func setLabelAttribute(label: UILabel, text: String){
        label.frame = CGRect(x: 0, y: 0, width: 60, height: 24)
        label.textColor = UIColor(red: 0.51, green: 0.51, blue: 0.51, alpha: 1)
        label.font = UIFont(name: "SFProDisplay-Regular", size: 14)

        let paragraphStyle = NSMutableParagraphStyle()
        paragraphStyle.lineHeightMultiple = 1.44
        label.attributedText = NSMutableAttributedString(string: text, attributes: [NSAttributedString.Key.paragraphStyle: paragraphStyle])
    }
    
    func setTextAttribute(label: UILabel, text: String){
        label.frame = CGRect(x: 0, y: 0, width: 267, height: 24)
        label.textColor = UIColor(red: 0.31, green: 0.31, blue: 0.31, alpha: 1)
        label.font = UIFont(name: "SFProDisplay-Regular", size: 14)
        
        let paragraphStyle = NSMutableParagraphStyle()
        paragraphStyle.lineHeightMultiple = 1.44
        label.attributedText = NSMutableAttributedString(string: text, attributes: [NSAttributedString.Key.paragraphStyle: paragraphStyle])
    }
}
