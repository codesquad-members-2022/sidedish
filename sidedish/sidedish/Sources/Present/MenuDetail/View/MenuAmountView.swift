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
        label.font = .systemFont(ofSize: 14)
        label.textAlignment = .left
        label.textColor = .grey2
        label.text = "수량"
        return label
    }()
    
    private let amountLabel: UILabel = {
        let label = UILabel()
        label.font = .systemFont(ofSize: 18, weight: .bold)
        label.textAlignment = .center
        label.text = "1"
        return label
    }()
    
    private let stepper: UIView = {
        let view = UIView()
        view.backgroundColor = .grey4
        view.layer.cornerRadius = 8
        return view
    }()
    
    private let plusButton: UIButton = {
        let button = UIButton()
        button.setTitle("+", for: .normal)
        button.setTitleColor(.black, for: .normal)
        button.titleLabel?.font = .systemFont(ofSize: 17, weight: .medium)
        return button
    }()
    
    private let minusButton: UIButton = {
        let button = UIButton()
        button.setTitle("-", for: .normal)
        button.setTitleColor(.black, for: .normal)
        button.titleLabel?.font = .systemFont(ofSize: 17, weight: .medium)
        return button
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
        addSubview(stepper)
        stepper.addSubview(plusButton)
        stepper.addSubview(minusButton)
        addSubview(amountLabel)
        
        titleLabel.snp.makeConstraints { make in
            make.top.equalToSuperview().offset(2)
            make.leading.equalToSuperview()
        }
        
        stepper.snp.makeConstraints { make in
            make.centerY.equalTo(titleLabel)
            make.trailing.equalToSuperview()
            make.width.equalTo(100)
            make.height.equalTo(28)
        }
        
        plusButton.snp.makeConstraints { make in
            make.top.bottom.trailing.equalTo(stepper)
            make.leading.equalTo(stepper.snp.centerX)
        }
        
        minusButton.snp.makeConstraints { make in
            make.top.bottom.leading.equalTo(stepper)
            make.trailing.equalTo(stepper.snp.centerX)
        }
        
        amountLabel.snp.makeConstraints { make in
            make.centerY.equalTo(titleLabel)
            make.trailing.equalTo(stepper.snp.leading)
            make.width.equalTo(57)
            make.height.equalTo(stepper)
        }
        
        self.snp.makeConstraints { make in
            make.bottom.equalTo(titleLabel)
        }
    }
}
