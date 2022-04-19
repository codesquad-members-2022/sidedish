//
//  MenuAmountView.swift
//  sidedish
//
//  Created by seongha shin on 2022/04/19.
//

import Combine
import UIKit

class MenuAmountView: UIView {
    private let titleLabel: UILabel = {
        let label = UILabel()
        label.translatesAutoresizingMaskIntoConstraints = false
        label.font = .systemFont(ofSize: 14)
        label.textAlignment = .left
        label.textColor = .grey2
        label.text = "수량"
        return label
    }()
    
    private let amountLabel: UILabel = {
        let label = UILabel()
        label.translatesAutoresizingMaskIntoConstraints = false
        label.font = .systemFont(ofSize: 18, weight: .bold)
        label.textAlignment = .center
        label.text = "1"
        return label
    }()
    
    private let stepper: UIView = {
        let view = UIView()
        view.translatesAutoresizingMaskIntoConstraints = false
        view.backgroundColor = .grey4
        view.layer.cornerRadius = 8
        return view
    }()
    
    private let plusButton: UIButton = {
        let button = UIButton()
        button.translatesAutoresizingMaskIntoConstraints = false
        button.setTitle("+", for: .normal)
        button.setTitleColor(.black, for: .normal)
        button.titleLabel?.font = .systemFont(ofSize: 17, weight: .medium)
        return button
    }()
    
    private let minusButton: UIButton = {
        let button = UIButton()
        button.translatesAutoresizingMaskIntoConstraints = false
        button.setTitle("-", for: .normal)
        button.setTitleColor(.black, for: .normal)
        button.titleLabel?.font = .systemFont(ofSize: 17, weight: .medium)
        return button
    }()
    
    private let bottomBar: UIView = {
        let view = UIView()
        view.translatesAutoresizingMaskIntoConstraints = false
        view.backgroundColor = .grey3
        return view
    }()
    
    var plusPublisher: AnyPublisher<Void, Never> {
        plusButton.publisher(for: .touchUpInside)
    }
    
    var minusPublisher: AnyPublisher<Void, Never> {
        minusButton.publisher(for: .touchUpInside)
    }
    
    var amount: Int = 1 {
        didSet {
            amountLabel.text = "\(amount)"
        }
    }
    
    init() {
        super.init(frame: .zero)
        layout()
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        layout()
    }
    
    private func layout() {
        addSubview(titleLabel)
        addSubview(bottomBar)
        addSubview(stepper)
        stepper.addSubview(plusButton)
        stepper.addSubview(minusButton)
        addSubview(amountLabel)
        
        NSLayoutConstraint.activate([
            titleLabel.topAnchor.constraint(equalTo: topAnchor),
            titleLabel.leadingAnchor.constraint(equalTo: leadingAnchor),
            
            stepper.centerYAnchor.constraint(equalTo: titleLabel.centerYAnchor),
            stepper.trailingAnchor.constraint(equalTo: trailingAnchor),
            stepper.widthAnchor.constraint(equalToConstant: 100),
            stepper.heightAnchor.constraint(equalToConstant: 28),
            
            plusButton.topAnchor.constraint(equalTo: stepper.topAnchor),
            plusButton.bottomAnchor.constraint(equalTo: stepper.bottomAnchor),
            plusButton.trailingAnchor.constraint(equalTo: stepper.trailingAnchor),
            plusButton.leadingAnchor.constraint(equalTo: stepper.centerXAnchor),
            
            minusButton.topAnchor.constraint(equalTo: stepper.topAnchor),
            minusButton.bottomAnchor.constraint(equalTo: stepper.bottomAnchor),
            minusButton.trailingAnchor.constraint(equalTo: stepper.centerXAnchor),
            minusButton.leadingAnchor.constraint(equalTo: stepper.leadingAnchor),
            
            amountLabel.centerYAnchor.constraint(equalTo: titleLabel.centerYAnchor),
            amountLabel.trailingAnchor.constraint(equalTo: stepper.leadingAnchor),
            amountLabel.widthAnchor.constraint(equalToConstant: 57),
            amountLabel.heightAnchor.constraint(equalTo: stepper.heightAnchor),
            
            bottomBar.topAnchor.constraint(equalTo: titleLabel.bottomAnchor, constant: 26),
            bottomBar.leadingAnchor.constraint(equalTo: leadingAnchor),
            bottomBar.trailingAnchor.constraint(equalTo: trailingAnchor),
            bottomBar.heightAnchor.constraint(equalToConstant: 1),
            
            bottomAnchor.constraint(equalTo: bottomBar.bottomAnchor)
        ])
    }
}
