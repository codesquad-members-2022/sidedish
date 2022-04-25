//
//  ThirdSectionViewController.swift
//  sidedishApp
//
//  Created by juntaek.oh on 2022/04/19.
//

import UIKit

class OrderViewController: UIViewController {
    
    private lazy var countLabel: UILabel = {
        var label = UILabel()
        label.textColor = UIColor.customColor(.grey2)
        label.font = UIFont(name: "SFProDisplay-Regular", size: 14)
        label.baselineAdjustment = .alignCenters
        label.text = "수량"
        return label
    }()
    
    private lazy var countText: UILabel = {
        var label = UILabel()
        label.textColor = UIColor.customColor(.grey1)
        label.font = UIFont(name: "SFProDisplay-Regular", size: 18)
        label.baselineAdjustment = .alignCenters
        label.text = "1"
        return label
    }()
    
    private lazy var countStepper: UIStepper = {
        var stepper = UIStepper()
        stepper.layer.cornerRadius = 7.92
        return stepper
    }()
    
    private lazy var sectionUpper: UILabel = {
        var label = UILabel()
        label.layer.backgroundColor = UIColor(red: 0.878, green: 0.878, blue: 0.878, alpha: 1).cgColor
        return label
    }()
    
    private lazy var sectionCenter: UILabel = {
        var label = UILabel()
        label.layer.backgroundColor = UIColor(red: 0.878, green: 0.878, blue: 0.878, alpha: 1).cgColor
        return label
    }()
    
    private lazy var accountView: UIView = {
        var view = UIView()
        return view
    }()
    
    private lazy var accountLabel: UILabel = {
        var label = UILabel()
        label.textColor = UIColor.customColor(.grey2)
        label.font = UIFont(name: "SFProDisplay-Semibold", size: 18)
        label.baselineAdjustment = .alignCenters
        label.text = "총 주문금액"
        return label
    }()
    
    private lazy var accountText: UILabel = {
        var label = UILabel()
        label.textColor = UIColor.customColor(.black)
        label.font = UIFont(name: "SFProDisplay-Semibold", size: 32)
        label.baselineAdjustment = .alignCenters
        label.text = "12,640원"
        return label
    }()
    
    private lazy var orderButton: UIButton = {
        var button = UIButton()
        button.layer.backgroundColor = UIColor(red: 0, green: 0.478, blue: 1, alpha: 1).cgColor
        button.layer.cornerRadius = 12
        button.setTitle("주문하기", for: .normal)
        button.titleLabel?.font = UIFont(name: "SFProDisplay-Semibold", size: 18)
        button.titleLabel?.textColor = UIColor(red: 1, green: 1, blue: 1, alpha: 1)
        button.titleLabel?.textAlignment = .center
        button.titleLabel?.baselineAdjustment = .alignCenters
        return button
    }()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        setAllProperties()
    }
}

private extension OrderViewController {
    func setAllProperties() {
        configureSectionUpper()
        configureCountLabel()
        configureCountText()
        configureCountStepper()
        configureSectionCenter()
        configureAccountView()
        configureAccountLabel()
        configureAccountText()
        configureOrderButton()
    }
    
    func configureSectionUpper() {
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
        self.view.addSubview(countStepper)
        
        countStepper.translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate([
            countStepper.topAnchor.constraint(equalTo: self.sectionUpper.topAnchor, constant: 26),
            countStepper.trailingAnchor.constraint(equalTo: self.view.trailingAnchor),
            countStepper.widthAnchor.constraint(equalToConstant: 100),
            countStepper.heightAnchor.constraint(equalToConstant: 28)
        ])
    }
    
    func configureSectionCenter() {
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
    
    func configureOrderButton() {
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
