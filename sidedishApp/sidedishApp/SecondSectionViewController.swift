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
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.view.frame = CGRect(x: 0, y: 0, width: 343, height: 152)
        
        self.view.addSubview(secondSection)
    }
}

private extension SecondSectionViewController{
    func configurePointLabel(){
        pointLabel = UILabel()
        pointLabel.frame = CGRect(x: 0, y: 0, width: 60, height: 24)
        pointLabel.textColor = UIColor(red: 0.51, green: 0.51, blue: 0.51, alpha: 1)
        pointLabel.font = UIFont(name: "SFProDisplay-Regular", size: 14)
        setTextAttribute(label: pointLabel, text: "적립금")
        self.secondSection.addSubview(pointLabel)
        
        pointLabel.translatesAutoresizingMaskIntoConstraints = false
        pointLabel.topAnchor.constraint(equalTo: self.secondSection.bottomAnchor, constant: 24).isActive = true
        pointLabel.leadingAnchor.constraint(equalTo: self.secondSection.leadingAnchor).isActive = true
        pointLabel.widthAnchor.constraint(equalToConstant: 60).isActive = true
        pointLabel.heightAnchor.constraint(equalToConstant: 24).isActive = true
    }
    
    func configurePointText(){
        pointText = UILabel()
        pointText.frame = CGRect(x: 0, y: 0, width: 267, height: 24)
        pointText.textColor = UIColor(red: 0.31, green: 0.31, blue: 0.31, alpha: 1)
        pointText.font = UIFont(name: "SFProDisplay-Regular", size: 14)
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
        deliveryLabel.frame = CGRect(x: 0, y: 0, width: 60, height: 24)
        deliveryLabel.textColor = UIColor(red: 0.51, green: 0.51, blue: 0.51, alpha: 1)
        deliveryLabel.font = UIFont(name: "SFProDisplay-Regular", size: 14)
        setTextAttribute(label: deliveryLabel, text: "배송정보")
        self.secondSection.addSubview(deliveryLabel)
        
        deliveryLabel.translatesAutoresizingMaskIntoConstraints = false
        deliveryLabel.topAnchor.constraint(equalTo: self.pointLabel.bottomAnchor, constant: 16).isActive = true
        deliveryLabel.leadingAnchor.constraint(equalTo: self.secondSection.leadingAnchor).isActive = true
        deliveryLabel.widthAnchor.constraint(equalToConstant: 60).isActive = true
        deliveryLabel.heightAnchor.constraint(equalToConstant: 24).isActive = true
    }
    
    func configureDeliveryText(){
        deliveryText = UILabel()
        deliveryText.frame = CGRect(x: 0, y: 0, width: 267, height: 24)
        deliveryText.textColor = UIColor(red: 0.31, green: 0.31, blue: 0.31, alpha: 1)
        deliveryText.font = UIFont(name: "SFProDisplay-Regular", size: 14)
        setTextAttribute(label: deliveryText, text: "서울 경기 새벽 배송, 전국 택배 배송")
        self.secondSection.addSubview(deliveryText)
        
        deliveryText.translatesAutoresizingMaskIntoConstraints = false
        deliveryText.topAnchor.constraint(equalTo: self.pointText.bottomAnchor, constant: 16).isActive = true
        deliveryText.leadingAnchor.constraint(equalTo: self.deliveryLabel.trailingAnchor, constant: 16).isActive = true
        deliveryText.trailingAnchor.constraint(equalTo: self.secondSection.trailingAnchor).isActive = true
        deliveryText.heightAnchor.constraint(equalToConstant: 24).isActive = true
    }
    
    func setTextAttribute(label: UILabel, text: String){
        let paragraphStyle = NSMutableParagraphStyle()
        paragraphStyle.lineHeightMultiple = 1.44
        
        label.attributedText = NSMutableAttributedString(string: text, attributes: [NSAttributedString.Key.paragraphStyle: paragraphStyle])
    }
}
