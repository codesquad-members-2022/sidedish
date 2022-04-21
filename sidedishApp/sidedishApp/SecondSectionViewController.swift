//
//  SecondSectionViewController.swift
//  sidedishApp
//
//  Created by juntaek.oh on 2022/04/19.
//

import UIKit

class SecondSectionViewController: UIViewController{
    private var pointLabel: UILabel!
    private var pointText: UILabel!
    private var deliveryLabel: UILabel!
    private var deliveryText: UILabel!
    private var chargeLabel: UILabel!
    private var chargeText: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        setAllProperties()
    }
}

private extension SecondSectionViewController{
    func setAllProperties() {
        configurePointLabel()
        configurePointText()
        configureDeliveryLabel()
        configureDeliveryText()
        configureChargeLabel()
        configureChargeText()
    }
    
    func configurePointLabel() {
        pointLabel = UILabel()
        pointLabel.baselineAdjustment = .alignCenters
        pointLabel.text = "적립금"
        self.view.addSubview(pointLabel)
        
        pointLabel.translatesAutoresizingMaskIntoConstraints = false
        pointLabel.topAnchor.constraint(equalTo: self.view.topAnchor, constant: 24).isActive = true
        pointLabel.leadingAnchor.constraint(equalTo: self.view.leadingAnchor).isActive = true
        pointLabel.widthAnchor.constraint(equalToConstant: 60).isActive = true
        pointLabel.heightAnchor.constraint(equalToConstant: 24).isActive = true
    }
    
    func configurePointText() {
        pointText = UILabel()
        pointText.baselineAdjustment = .alignCenters
        pointText.text = "126원"
        self.view.addSubview(pointText)
        
        pointText.translatesAutoresizingMaskIntoConstraints = false
        pointText.topAnchor.constraint(equalTo: self.view.topAnchor, constant: 24).isActive = true
        pointText.leadingAnchor.constraint(equalTo: self.pointLabel.trailingAnchor, constant: 16).isActive = true
        pointText.trailingAnchor.constraint(equalTo: self.view.trailingAnchor).isActive = true
        pointText.heightAnchor.constraint(equalToConstant: 24).isActive = true
    }
    
    func configureDeliveryLabel() {
        deliveryLabel = UILabel()
        deliveryLabel.baselineAdjustment = .alignCenters
        deliveryLabel.text = "배송정보"
        self.view.addSubview(deliveryLabel)
        
        deliveryLabel.translatesAutoresizingMaskIntoConstraints = false
        deliveryLabel.topAnchor.constraint(equalTo: self.pointLabel.bottomAnchor, constant: 16).isActive = true
        deliveryLabel.leadingAnchor.constraint(equalTo: self.view.leadingAnchor).isActive = true
        deliveryLabel.widthAnchor.constraint(equalToConstant: 60).isActive = true
        deliveryLabel.heightAnchor.constraint(equalToConstant: 24).isActive = true
    }
    
    func configureDeliveryText() {
        deliveryText = UILabel()
        deliveryText.baselineAdjustment = .alignCenters
        deliveryText.text = "서울 경기 새벽 배송, 전국 택배 배송"
        self.view.addSubview(deliveryText)
        
        deliveryText.translatesAutoresizingMaskIntoConstraints = false
        deliveryText.topAnchor.constraint(equalTo: self.pointText.bottomAnchor, constant: 16).isActive = true
        deliveryText.leadingAnchor.constraint(equalTo: self.deliveryLabel.trailingAnchor, constant: 16).isActive = true
        deliveryText.trailingAnchor.constraint(equalTo: self.view.trailingAnchor).isActive = true
        deliveryText.heightAnchor.constraint(equalToConstant: 24).isActive = true
    }
    
    func configureChargeLabel() {
        chargeLabel = UILabel()
        chargeLabel.baselineAdjustment = .alignCenters
        chargeLabel.text = "배송비"
        self.view.addSubview(chargeLabel)
        
        chargeLabel.translatesAutoresizingMaskIntoConstraints = false
        chargeLabel.topAnchor.constraint(equalTo: self.deliveryLabel.bottomAnchor, constant: 16).isActive = true
        chargeLabel.leadingAnchor.constraint(equalTo: self.view.leadingAnchor).isActive = true
        chargeLabel.widthAnchor.constraint(equalToConstant: 60).isActive = true
        chargeLabel.heightAnchor.constraint(equalToConstant: 24).isActive = true
        chargeLabel.bottomAnchor.constraint(equalTo: self.view.bottomAnchor, constant: -24).isActive = true
    }
    
    func configureChargeText() {
        chargeText = UILabel()
        chargeText.baselineAdjustment = .alignCenters
        chargeText.text = "2,500원 (40,000원 이상 구매 시 무료)"
        self.view.addSubview(chargeText)
        
        chargeText.translatesAutoresizingMaskIntoConstraints = false
        chargeText.topAnchor.constraint(equalTo: self.deliveryText.bottomAnchor, constant: 16).isActive = true
        chargeText.leadingAnchor.constraint(equalTo: self.chargeLabel.trailingAnchor, constant: 16).isActive = true
        chargeText.trailingAnchor.constraint(equalTo: self.view.trailingAnchor).isActive = true
        chargeText.heightAnchor.constraint(equalToConstant: 24).isActive = true
        chargeText.bottomAnchor.constraint(equalTo: self.view.bottomAnchor, constant: -24).isActive = true
    }
}
