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
    }
    
    func configureSectionUpper() {
        sectionUpper = UILabel()
        sectionUpper.layer.backgroundColor = UIColor(red: 0.878, green: 0.878, blue: 0.878, alpha: 1).cgColor
        self.view.addSubview(sectionUpper)
        
        sectionUpper.translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate([
            sectionUpper.topAnchor.constraint(equalTo: self.view.topAnchor),
            sectionUpper.leadingAnchor.constraint(equalTo: self.view.leadingAnchor),
            sectionUpper.trailingAnchor.constraint(equalTo: self.view.trailingAnchor),
            sectionUpper.heightAnchor.constraint(equalToConstant: 1)
        ])
    }
    
    func configureCountLabel() {
        countLabel = UILabel()
        countLabel.textColor = UIColor(red: 0.51, green: 0.51, blue: 0.51, alpha: 1)
        countLabel.font = UIFont(name: "SFProDisplay-Regular", size: 14)
        countLabel.baselineAdjustment = .alignCenters
        countLabel.text = "수량"
        self.view.addSubview(countLabel)
        
        countLabel.translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate([
            countLabel.topAnchor.constraint(equalTo: self.sectionUpper.bottomAnchor, constant: 26),
            countLabel.leadingAnchor.constraint(equalTo: self.view.leadingAnchor),
            countLabel.widthAnchor.constraint(equalToConstant: 60),
            countLabel.heightAnchor.constraint(equalToConstant: 24)
        ])
    }
    
    func configureCountText() {
        countText = UILabel()
        countText.textColor = UIColor(red: 0.31, green: 0.31, blue: 0.31, alpha: 1)
        countText.font = UIFont(name: "SFProDisplay-Regular", size: 18)
        countText.baselineAdjustment = .alignCenters
        countText.text = "1"
        self.view.addSubview(countText)
        
        countText.translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate([
            countText.topAnchor.constraint(equalTo: self.sectionUpper.bottomAnchor, constant: 26),
            countText.leadingAnchor.constraint(equalTo: self.countLabel.trailingAnchor, constant: 150),
            countText.widthAnchor.constraint(equalToConstant: 9),
            countText.heightAnchor.constraint(equalToConstant: 24)
        ])
    }
    
    func configureCountStepper() {
        countStepper = UIStepper()
        countStepper.layer.cornerRadius = 7.92
        self.view.addSubview(countStepper)
        
        countStepper.translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate([
            countStepper.topAnchor.constraint(equalTo: self.sectionUpper.topAnchor, constant: 26),
            countStepper.trailingAnchor.constraint(equalTo: self.view.trailingAnchor),
            countStepper.widthAnchor.constraint(equalToConstant: 100),
            countStepper.heightAnchor.constraint(equalToConstant: 28)
        ])
    }
    
    func configureSectionBottom() {
        sectionCenter = UILabel()
        sectionCenter.layer.backgroundColor = UIColor(red: 0.878, green: 0.878, blue: 0.878, alpha: 1).cgColor
        self.view.addSubview(sectionCenter)
        
        sectionCenter.translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate([
            sectionCenter.topAnchor.constraint(equalTo: self.countLabel.bottomAnchor, constant: 26),
            sectionCenter.leadingAnchor.constraint(equalTo: self.view.leadingAnchor),
            sectionCenter.trailingAnchor.constraint(equalTo: self.view.trailingAnchor),
            sectionCenter.heightAnchor.constraint(equalToConstant: 1)
        ])
    }
    
    func configureAccountView() {
        accountView = UIView()
        self.view.addSubview(accountView)
        
        accountView.translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate([
            accountView.leadingAnchor.constraint(equalTo: self.view.leadingAnchor, constant: 116),
            accountView.trailingAnchor.constraint(equalTo: self.view.trailingAnchor, constant: 16),
            accountView.topAnchor.constraint(equalTo: self.sectionCenter.bottomAnchor, constant: 24),
            accountView.widthAnchor.constraint(equalToConstant: 243),
            accountView.heightAnchor.constraint(equalToConstant: 48)
        ])
    }
    
    func configureAccountLabel() {
        accountLabel = UILabel()
        accountLabel.textColor = UIColor(red: 0.51, green: 0.51, blue: 0.51, alpha: 1)
        accountLabel.font = UIFont(name: "SFProDisplay-Semibold", size: 18)
        accountLabel.baselineAdjustment = .alignCenters
        accountLabel.text = "총 주문금액"
        self.accountView.addSubview(accountLabel)
        
        accountLabel.translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate([
            accountLabel.topAnchor.constraint(equalTo: self.accountView.topAnchor, constant: 12),
            accountLabel.bottomAnchor.constraint(equalTo: self.accountView.bottomAnchor, constant: -12),
            accountLabel.leadingAnchor.constraint(equalTo: self.accountView.leadingAnchor),
            accountLabel.widthAnchor.constraint(equalToConstant: 87),
            accountLabel.heightAnchor.constraint(equalToConstant: 24)
        ])
    }
    
    func configureAccountText() {
        accountText = UILabel()
        accountText.textColor = UIColor(red: 0.004, green: 0.004, blue: 0.004, alpha: 1)
        accountText.font = UIFont(name: "SFProDisplay-Semibold", size: 32)
        accountText.baselineAdjustment = .alignCenters
        accountText.text = "12,640원"
        self.accountView.addSubview(accountText)
        
        accountText.translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate([
            accountText.topAnchor.constraint(equalTo: self.accountView.topAnchor),
            accountText.bottomAnchor.constraint(equalTo: self.accountView.bottomAnchor),
            accountText.leadingAnchor.constraint(equalTo: self.accountLabel.trailingAnchor, constant: 24),
            accountText.trailingAnchor.constraint(equalTo: self.accountView.trailingAnchor),
            accountText.widthAnchor.constraint(equalToConstant: 132),
            accountText.heightAnchor.constraint(equalToConstant: 48)
        ])
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
        NSLayoutConstraint.activate([
            orderButton.topAnchor.constraint(equalTo: self.accountView.bottomAnchor, constant: 24),
            orderButton.bottomAnchor.constraint(equalTo: self.view.bottomAnchor, constant: -24),
            orderButton.leadingAnchor.constraint(equalTo: self.view.leadingAnchor),
            orderButton.trailingAnchor.constraint(equalTo: self.view.trailingAnchor),
        ])
    }
}
