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
    private var sectionUpper: UILabel!
    private var sectionCenter: UILabel!
    private var accountView: UIView!
    private var accountLabel: UILabel!
    private var accountText: UILabel!
    private var orderButton: UIButton!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        setAllProperties()
    }
}

private extension ThirdSectionViewController{
    func setAllProperties() {
        configureSectionUpper()
        configureCountLabel()
        configureCountText()
        configureCountStepper()
        configureSectionBottom()
        configureAccountView()
        configureAccountLabel()
        configureAccountText()
        configureOrderButton()
        // 총주문금액, 주문하기 구현 필요
    }
    
    func configureSectionUpper() {
        sectionUpper = UILabel()
        sectionUpper.layer.backgroundColor = UIColor(red: 0.878, green: 0.878, blue: 0.878, alpha: 1).cgColor
        self.view.addSubview(sectionUpper)
        
        sectionUpper.translatesAutoresizingMaskIntoConstraints = false
        sectionUpper.topAnchor.constraint(equalTo: self.view.topAnchor).isActive = true
        sectionUpper.leadingAnchor.constraint(equalTo: self.view.leadingAnchor).isActive = true
        sectionUpper.trailingAnchor.constraint(equalTo: self.view.trailingAnchor).isActive = true
        sectionUpper.heightAnchor.constraint(equalToConstant: 1).isActive = true
    }
    
    func configureCountLabel() {
        countLabel = UILabel()
        countLabel.textColor = UIColor(red: 0.51, green: 0.51, blue: 0.51, alpha: 1)
        countLabel.font = UIFont(name: "SFProDisplay-Regular", size: 14)
        countLabel.baselineAdjustment = .alignCenters
        countLabel.text = "수량"
        self.view.addSubview(countLabel)
        
        countLabel.translatesAutoresizingMaskIntoConstraints = false
        countLabel.topAnchor.constraint(equalTo: self.sectionUpper.bottomAnchor, constant: 26).isActive = true
        countLabel.leadingAnchor.constraint(equalTo: self.view.leadingAnchor).isActive = true
        countLabel.widthAnchor.constraint(equalToConstant: 60).isActive = true
        countLabel.heightAnchor.constraint(equalToConstant: 24).isActive = true
    }
    
    func configureCountText() {
        countText = UILabel()
        countText.textColor = UIColor(red: 0.31, green: 0.31, blue: 0.31, alpha: 1)
        countText.font = UIFont(name: "SFProDisplay-Regular", size: 18)
        countText.baselineAdjustment = .alignCenters
        countText.text = "1"
        self.view.addSubview(countText)
        
        countText.translatesAutoresizingMaskIntoConstraints = false
        countText.topAnchor.constraint(equalTo: self.sectionUpper.bottomAnchor, constant: 26).isActive = true
        countText.leadingAnchor.constraint(equalTo: self.countLabel.trailingAnchor, constant: 150).isActive = true
        countText.widthAnchor.constraint(equalToConstant: 9).isActive = true
        countText.heightAnchor.constraint(equalToConstant: 24).isActive = true
    }
    
    func configureCountStepper() {
        countStepper = UIStepper()
        countStepper.layer.cornerRadius = 7.92
        self.view.addSubview(countStepper)
        
        countStepper.translatesAutoresizingMaskIntoConstraints = false
        countStepper.topAnchor.constraint(equalTo: self.sectionUpper.topAnchor, constant: 26).isActive = true
        countStepper.trailingAnchor.constraint(equalTo: self.view.trailingAnchor).isActive = true
        countStepper.widthAnchor.constraint(equalToConstant: 100).isActive = true
        countStepper.heightAnchor.constraint(equalToConstant: 28).isActive = true
    }
    
    func configureSectionBottom() {
        sectionCenter = UILabel()
        sectionCenter.layer.backgroundColor = UIColor(red: 0.878, green: 0.878, blue: 0.878, alpha: 1).cgColor
        self.view.addSubview(sectionCenter)
        
        sectionCenter.translatesAutoresizingMaskIntoConstraints = false
        sectionCenter.topAnchor.constraint(equalTo: self.countLabel.bottomAnchor, constant: 26).isActive = true
        sectionCenter.leadingAnchor.constraint(equalTo: self.view.leadingAnchor).isActive = true
        sectionCenter.trailingAnchor.constraint(equalTo: self.view.trailingAnchor).isActive = true
        sectionCenter.heightAnchor.constraint(equalToConstant: 1).isActive = true
    }
    
    func configureAccountView() {
        accountView = UIView()
        self.view.addSubview(accountView)
        
        accountView.translatesAutoresizingMaskIntoConstraints = false
        accountView.leadingAnchor.constraint(equalTo: self.view.leadingAnchor, constant: 116).isActive = true
        accountView.trailingAnchor.constraint(equalTo: self.view.trailingAnchor, constant: 16).isActive = true
        accountView.topAnchor.constraint(equalTo: self.sectionCenter.bottomAnchor, constant: 24).isActive = true
        accountView.widthAnchor.constraint(equalToConstant: 243).isActive = true
        accountView.heightAnchor.constraint(equalToConstant: 48).isActive = true
    }
    
    func configureAccountLabel() {
        accountLabel = UILabel()
        accountLabel.textColor = UIColor(red: 0.51, green: 0.51, blue: 0.51, alpha: 1)
        accountLabel.font = UIFont(name: "SFProDisplay-Semibold", size: 18)
        accountLabel.baselineAdjustment = .alignCenters
        accountLabel.text = "총 주문금액"
        self.accountView.addSubview(accountLabel)
        
        accountLabel.translatesAutoresizingMaskIntoConstraints = false
        accountLabel.topAnchor.constraint(equalTo: self.accountView.topAnchor, constant: 12).isActive = true
        accountLabel.bottomAnchor.constraint(equalTo: self.accountView.bottomAnchor, constant: -12).isActive = true
        accountLabel.leadingAnchor.constraint(equalTo: self.accountView.leadingAnchor).isActive = true
        accountLabel.widthAnchor.constraint(equalToConstant: 87).isActive = true
        accountLabel.heightAnchor.constraint(equalToConstant: 24).isActive = true
    }
    
    func configureAccountText() {
        accountText = UILabel()
        accountText.textColor = UIColor(red: 0.004, green: 0.004, blue: 0.004, alpha: 1)
        accountText.font = UIFont(name: "SFProDisplay-Semibold", size: 32)
        accountText.baselineAdjustment = .alignCenters
        accountText.text = "12,640원"
        self.accountView.addSubview(accountText)
        
        accountText.translatesAutoresizingMaskIntoConstraints = false
        accountText.topAnchor.constraint(equalTo: self.accountView.topAnchor).isActive = true
        accountText.bottomAnchor.constraint(equalTo: self.accountView.bottomAnchor).isActive = true
        accountText.leadingAnchor.constraint(equalTo: self.accountLabel.trailingAnchor, constant: 24).isActive = true
        accountText.trailingAnchor.constraint(equalTo: self.accountView.trailingAnchor).isActive = true
        accountText.widthAnchor.constraint(equalToConstant: 132).isActive = true
        accountText.heightAnchor.constraint(equalToConstant: 48).isActive = true
    }
    
    func configureOrderButton(){
        orderButton = UIButton()
        orderButton.layer.backgroundColor = UIColor(red: 0, green: 0.478, blue: 1, alpha: 1).cgColor
        orderButton.layer.cornerRadius = 12
        orderButton.setTitle("주문하기", for: .normal)
        orderButton.titleLabel?.font = UIFont(name: "SFProDisplay-Semibold", size: 18)
        orderButton.titleLabel?.textColor = UIColor(red: 1, green: 1, blue: 1, alpha: 1)
        orderButton.titleLabel?.textAlignment = .center
        orderButton.titleLabel?.baselineAdjustment = .alignCenters
        self.view.addSubview(orderButton)
        
        orderButton.translatesAutoresizingMaskIntoConstraints = false
        orderButton.topAnchor.constraint(equalTo: self.accountView.bottomAnchor, constant: 24).isActive = true
        orderButton.bottomAnchor.constraint(equalTo: self.view.bottomAnchor, constant: -24).isActive = true
        orderButton.leadingAnchor.constraint(equalTo: self.view.leadingAnchor).isActive = true
        orderButton.trailingAnchor.constraint(equalTo: self.view.trailingAnchor).isActive = true
    }
}
