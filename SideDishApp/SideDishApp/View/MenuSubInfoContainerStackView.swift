//
//  MenuSubInfoStackView.swift
//  SideDishApp
//
//  Created by 김상혁 on 2022/04/26.
//

import UIKit
import OSLog

class MenuSubInfoContainerStackView: UIStackView {
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        setUpView()
    }
    
    @available(*, unavailable) required init(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    private func setUpView() {
        spacing = 16
        axis = .vertical
    }
}

// MARK: - Providing Function

extension MenuSubInfoContainerStackView {
    func setSubInfoDescription(by texts: [String]) {
        
        if texts.count < Constant.SubInfoText.allCases.count {
            os_log(.error, "Count of 'Texts' must smaller than count of 'SubInfoTitle'")
            return
        }
        
        for index in 0..<texts.count {
            let eachSubInfoStackView = UIStackView.makeSubInfo(titleText: .allCases[index], descriptionText: texts[index])
            addArrangedSubview(eachSubInfoStackView)
        }
    }
}

// MARK: - Private Extension

private extension UIStackView {
    static func makeSubInfo(titleText: Constant.SubInfoText, descriptionText: String) -> UIStackView {
        
        let subInfoContainerStackView = UIStackView.makeEachSubInfo()
        let titleLabel = UILabel.makeTitle(title: titleText.description)
        let descriptionLabel = UILabel.makeDescription(title: descriptionText)
        
        subInfoContainerStackView.addArrangedSubview(titleLabel)
        subInfoContainerStackView.addArrangedSubview(descriptionLabel)
        
        titleLabel.translatesAutoresizingMaskIntoConstraints = false
        titleLabel.widthAnchor.constraint(equalToConstant: 60).isActive = true
        
        return subInfoContainerStackView
    }
    
    private static func makeEachSubInfo() -> UIStackView {
        let stackView = UIStackView()
        stackView.axis = .horizontal
        stackView.spacing = 16
        return stackView
    }
}

private extension UILabel {
    static func makeTitle(title text: String) -> UILabel {
        let label = UILabel()
        label.text = text
        label.textColor = .systemGray
        return label
    }
    
    static func makeDescription(title text: String) -> UILabel {
        let label = UILabel()
        label.text = text
        label.textColor = .darkGray
        return label
    }
}
