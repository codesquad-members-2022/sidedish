//
//  MenuSubInfoView.swift
//  sidedish
//
//  Created by seongha shin on 2022/04/19.
//

import UIKit

class MenuSubInfoView: UIView {
    
    private let stackView: UIStackView = {
        let stackView = UIStackView()
        stackView.translatesAutoresizingMaskIntoConstraints = false
        stackView.axis = .vertical
        stackView.spacing = 16
        return stackView
    }()
    
    private let pointLabel: KeyValueView = {
        let keyValueView = KeyValueView()
        keyValueView.translatesAutoresizingMaskIntoConstraints = false
        keyValueView.key = "적립금"
        return keyValueView
    }()
    
    private let deliveryInfoLabel: KeyValueView = {
        let keyValueView = KeyValueView()
        keyValueView.translatesAutoresizingMaskIntoConstraints = false
        keyValueView.key = "배송정보"
        return keyValueView
    }()
    
    private let deliveryPriceLabel: KeyValueView = {
        let keyValueView = KeyValueView()
        keyValueView.translatesAutoresizingMaskIntoConstraints = false
        keyValueView.key = "배송비"
        return keyValueView
    }()
    
    init() {
        super.init(frame: .zero)
        layout()
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        layout()
    }
    
    private func layout() {
        addSubview(stackView)
        stackView.addArrangedSubview(pointLabel)
        stackView.addArrangedSubview(deliveryInfoLabel)
        stackView.addArrangedSubview(deliveryPriceLabel)
        
        stackView.setCustomSpacing(24, after: deliveryPriceLabel)
        
        NSLayoutConstraint.activate([
            stackView.topAnchor.constraint(equalTo: topAnchor),
            stackView.leadingAnchor.constraint(equalTo: leadingAnchor),
            stackView.trailingAnchor.constraint(equalTo: trailingAnchor),
            
            bottomAnchor.constraint(equalTo: stackView.bottomAnchor)
        ])
    }
    
    func setData(_ data: MenuDetail) {
        pointLabel.value = data.point
        deliveryInfoLabel.value = data.deliveryInfo
        deliveryPriceLabel.value = data.deliveryFee
    }
}

extension MenuSubInfoView {
    class KeyValueView: UIView {
        private let keyLabel: UILabel = {
            let label = UILabel()
            label.translatesAutoresizingMaskIntoConstraints = false
            label.font = .systemFont(ofSize: 14)
            label.textAlignment = .left
            label.textColor = .grey2
            return label
        }()
        
        private let valueLabel: UILabel = {
            let label = UILabel()
            label.translatesAutoresizingMaskIntoConstraints = false
            label.font = .systemFont(ofSize: 14)
            label.textAlignment = .left
            label.textColor = .grey1
            return label
        }()
        
        var key: String = "" {
            didSet {
                keyLabel.text = key
            }
        }
        
        var value: String = "" {
            didSet {
                valueLabel.text = value
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
            addSubview(keyLabel)
            addSubview(valueLabel)
            
            NSLayoutConstraint.activate([
                keyLabel.topAnchor.constraint(equalTo: topAnchor),
                keyLabel.bottomAnchor.constraint(equalTo: bottomAnchor),
                keyLabel.leadingAnchor.constraint(equalTo: leadingAnchor),
                
                valueLabel.topAnchor.constraint(equalTo: topAnchor),
                valueLabel.bottomAnchor.constraint(equalTo: bottomAnchor),
                valueLabel.leadingAnchor.constraint(equalTo: leadingAnchor, constant: 76),
                valueLabel.trailingAnchor.constraint(equalTo: trailingAnchor),
                
                bottomAnchor.constraint(equalTo: keyLabel.bottomAnchor)
            ])
        }
    }
}
