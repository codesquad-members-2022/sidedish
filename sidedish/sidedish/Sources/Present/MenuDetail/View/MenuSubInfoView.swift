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
        stackView.axis = .vertical
        stackView.spacing = 16
        return stackView
    }()
    
    private let pointLabel: KeyValueView = {
        let keyValueView = KeyValueView()
        keyValueView.key = "적립금"
        return keyValueView
    }()
    
    private let deliveryInfoLabel: KeyValueView = {
        let keyValueView = KeyValueView()
        keyValueView.key = "배송정보"
        return keyValueView
    }()
    
    private let deliveryPriceLabel: KeyValueView = {
        let keyValueView = KeyValueView()
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
        
        stackView.snp.makeConstraints { make in
            make.top.leading.trailing.equalToSuperview()
        }
        
        self.snp.makeConstraints { make in
            make.bottom.equalTo(stackView)
        }
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
            label.font = .systemFont(ofSize: 14)
            label.textAlignment = .left
            label.textColor = .grey2
            return label
        }()
        
        private let valueLabel: UILabel = {
            let label = UILabel()
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
            
            keyLabel.snp.makeConstraints { make in
                make.top.bottom.leading.equalToSuperview()
            }
            
            valueLabel.snp.makeConstraints { make in
                make.top.bottom.trailing.equalToSuperview()
                make.leading.equalToSuperview().offset(76)
            }
            
            self.snp.makeConstraints { make in
                make.bottom.equalTo(keyLabel)
            }
        }
    }
}
