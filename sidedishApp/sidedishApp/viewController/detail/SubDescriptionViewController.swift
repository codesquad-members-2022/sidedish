//
//  SecondSectionViewController.swift
//  sidedishApp
//
//  Created by juntaek.oh on 2022/04/19.
//

import UIKit

class SubDescriptionViewController: UIViewController {
    
    private lazy var pointLabel: UILabel = {
        var label = UILabel()
        label.baselineAdjustment = .alignCenters
        label.text = "적립금"
        label.textColor = UIColor.customColor(.grey2)
        label.font = UIFont.customFont(.sfRegularSubDescription)
        return label
    }()
    
    private lazy var pointText: UILabel = {
        var label = UILabel()
        label.baselineAdjustment = .alignCenters
        label.textColor = UIColor.customColor(.grey1)
        label.font = UIFont.customFont(.sfRegularSubDescription)
        return label
    }()
    
    private lazy var deliveryLabel: UILabel = {
        var label = UILabel()
        label.baselineAdjustment = .alignCenters
        label.text = "배송정보"
        label.textColor = UIColor.customColor(.grey2)
        label.font = UIFont.customFont(.sfRegularSubDescription)
        return label
    }()
    
    private lazy var deliveryText: UILabel = {
        var label = UILabel()
        label.baselineAdjustment = .alignCenters
        label.textColor = UIColor.customColor(.grey1)
        label.font = UIFont.customFont(.sfRegularSubDescription)
        return label
    }()
    
    private lazy var chargeLabel: UILabel = {
        var label = UILabel()
        label.baselineAdjustment = .alignCenters
        label.text = "배송비"
        label.textColor = UIColor.customColor(.grey2)
        label.font = UIFont.customFont(.sfRegularSubDescription)
        return label
    }()
    
    private lazy var chargeText: UILabel = {
        var label = UILabel()
        label.baselineAdjustment = .alignCenters
        label.textColor = UIColor.customColor(.grey1)
        label.font = UIFont.customFont(.sfRegularSubDescription)
        return label
    }()
    
    override func viewDidLoad() {
        super.viewDidLoad()
    }
    
    func setLabelTexts(detail: DetailCard.Body.DetailCardData?) {
        guard let detail = detail else { return }

        pointText.text = detail.point
        deliveryText.text = detail.deliveryInfo
        chargeText.text = detail.deliveryFee
        
        setAllProperties()
    }
}

private extension SubDescriptionViewController {
    func setAllProperties() {
        configurePointLabel()
        configurePointText()
        configureDeliveryLabel()
        configureDeliveryText()
        configureChargeLabel()
        configureChargeText()
    }
    
    func configurePointLabel() {
        self.view.addSubview(pointLabel)
        
        pointLabel.translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate([
            pointLabel.topAnchor.constraint(equalTo: self.view.topAnchor, constant: 24),
            pointLabel.leadingAnchor.constraint(equalTo: self.view.leadingAnchor),
            pointLabel.widthAnchor.constraint(equalToConstant: 60),
            pointLabel.heightAnchor.constraint(equalToConstant: 24)
        ])
    }
    
    func configurePointText() {
        self.view.addSubview(pointText)
        
        pointText.translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate([
            pointText.topAnchor.constraint(equalTo: self.view.topAnchor, constant: 24),
            pointText.leadingAnchor.constraint(equalTo: self.pointLabel.trailingAnchor, constant: 16),
            pointText.trailingAnchor.constraint(equalTo: self.view.trailingAnchor),
            pointText.heightAnchor.constraint(equalToConstant: 24)
        ])
    }
    
    func configureDeliveryLabel() {
        self.view.addSubview(deliveryLabel)
        
        deliveryLabel.translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate([
            deliveryLabel.topAnchor.constraint(equalTo: self.pointLabel.bottomAnchor, constant: 16),
            deliveryLabel.leadingAnchor.constraint(equalTo: self.view.leadingAnchor),
            deliveryLabel.widthAnchor.constraint(equalToConstant: 60),
            deliveryLabel.heightAnchor.constraint(equalToConstant: 24)
        ])
    }
    
    func configureDeliveryText() {
        self.view.addSubview(deliveryText)
        
        deliveryText.translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate([
            deliveryText.topAnchor.constraint(equalTo: self.pointText.bottomAnchor, constant: 16),
            deliveryText.leadingAnchor.constraint(equalTo: self.deliveryLabel.trailingAnchor, constant: 16),
            deliveryText.trailingAnchor.constraint(equalTo: self.view.trailingAnchor),
            deliveryText.heightAnchor.constraint(equalToConstant: 24)
        ])
    }
    
    func configureChargeLabel() {
        self.view.addSubview(chargeLabel)
        
        chargeLabel.translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate([
            chargeLabel.topAnchor.constraint(equalTo: self.deliveryLabel.bottomAnchor, constant: 16),
            chargeLabel.leadingAnchor.constraint(equalTo: self.view.leadingAnchor),
            chargeLabel.widthAnchor.constraint(equalToConstant: 60),
            chargeLabel.heightAnchor.constraint(equalToConstant: 24),
            chargeLabel.bottomAnchor.constraint(equalTo: self.view.bottomAnchor, constant: -24)
        ])
    }
    
    func configureChargeText() {
        self.view.addSubview(chargeText)
        
        chargeText.translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate([
            chargeText.topAnchor.constraint(equalTo: self.deliveryText.bottomAnchor, constant: 16),
            chargeText.leadingAnchor.constraint(equalTo: self.chargeLabel.trailingAnchor, constant: 16),
            chargeText.trailingAnchor.constraint(equalTo: self.view.trailingAnchor),
            chargeText.heightAnchor.constraint(equalToConstant: 24),
            chargeText.bottomAnchor.constraint(equalTo: self.view.bottomAnchor, constant: -24)
        ])
    }
}
