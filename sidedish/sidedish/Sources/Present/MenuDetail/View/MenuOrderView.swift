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
        label.font = .systemFont(ofSize: 32, weight: .bold)
        label.textAlignment = .right
        label.textColor = .black
        return label
    }()
    
    private let titleLabel: UILabel = {
        let label = UILabel()
        label.font = .systemFont(ofSize: 18, weight: .bold)
        label.textAlignment = .left
        label.textColor = .grey2
        label.text = "총 주문금액"
        return label
    }()
    
    private let orderButton: UIButton = {
        let button = UIButton()
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
        
        totalPriceLabel.snp.makeConstraints { make in
            make.top.trailing.equalToSuperview()
        }
        
        titleLabel.snp.makeConstraints { make in
            make.trailing.equalTo(totalPriceLabel.snp.leading).offset(-24)
            make.centerY.equalTo(totalPriceLabel)
        }
        
        orderButton.snp.makeConstraints { make in
            make.top.equalTo(totalPriceLabel.snp.bottom).offset(24)
            make.left.right.equalToSuperview()
            make.height.equalTo(50)
        }
        
        self.snp.makeConstraints { make in
            make.bottom.equalTo(orderButton.snp.bottom).offset(24)
        }
    }
    
    func setTotalPrice(_ totalPrice: Int) {
        totalPriceLabel.text = totalPrice.printCurrency()
    }
}
