//
//  MenuOrderView.swift
//  sidedish
//
//  Created by seongha shin on 2022/04/20.
//

import Combine
import UIKit

class MenuOrderView: UIView {
    private let totalPriceLabel: UILabel = {
        let label = UILabel()
        label.translatesAutoresizingMaskIntoConstraints = false
        label.font = .systemFont(ofSize: 32, weight: .bold)
        label.textAlignment = .right
        label.textColor = .black
        label.text = "12,666원"
        return label
    }()
    
    private let titleLabel: UILabel = {
        let label = UILabel()
        label.translatesAutoresizingMaskIntoConstraints = false
        label.font = .systemFont(ofSize: 18, weight: .bold)
        label.textAlignment = .left
        label.textColor = .grey2
        label.text = "총 주문금액"
        return label
    }()
    
    private let orderButton: UIButton = {
        let button = UIButton()
        button.translatesAutoresizingMaskIntoConstraints = false
        button.setTitle("주문하기", for: .normal)
        button.setTitleColor(.white, for: .normal)
        button.titleLabel?.font = .systemFont(ofSize: 18, weight: .semibold)
        button.backgroundColor = .primary2
        button.layer.cornerRadius = 12
        return button
    }()
    
    var orderPublisher: AnyPublisher<Void, Never> {
        orderButton.publisher(for: .touchUpInside)
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
        addSubview(totalPriceLabel)
        addSubview(titleLabel)
        addSubview(orderButton)
        
        NSLayoutConstraint.activate([
            totalPriceLabel.topAnchor.constraint(equalTo: topAnchor),
            totalPriceLabel.trailingAnchor.constraint(equalTo: trailingAnchor),
            
            titleLabel.trailingAnchor.constraint(equalTo: totalPriceLabel.leadingAnchor, constant: -24),
            titleLabel.centerYAnchor.constraint(equalTo: totalPriceLabel.centerYAnchor),
            
            orderButton.topAnchor.constraint(equalTo: totalPriceLabel.bottomAnchor, constant: 24),
            orderButton.leadingAnchor.constraint(equalTo: leadingAnchor),
            orderButton.trailingAnchor.constraint(equalTo: trailingAnchor),
            orderButton.heightAnchor.constraint(equalToConstant: 50),
            
            bottomAnchor.constraint(equalTo: orderButton.bottomAnchor, constant: 24)
        ])
    }
    
    func setData(_ data: MenuDetail) {
        
    }
}
