//
//  HeaderView.swift
//  SideDishApp
//
//  Created by Kai Kim on 2022/04/25.
//

import UIKit
protocol HeaderViewDelegate: AnyObject {
    func didTapHeader(sender: UICollectionReusableView)
}

class HeaderView: UICollectionReusableView {

    static let identifier = "HeaderView"
    weak var delegate: HeaderViewDelegate?
    private let title =  UILabel()

    var counterView = UILabel()

    override init(frame: CGRect) {
        super.init(frame: frame)
        configure()
        setGestureRecoginzer()
    }

    required init?(coder: NSCoder) {
        fatalError("Not implemented")
    }

    override func prepareForReuse() {
        super.prepareForReuse()
        self.counterView.isHidden = !counterView.isHidden
    }

    private func configure() {
        addSubview(title)
        configureTitle()
        configureCounterView()

    }

    private func configureCounterView() {

        counterView.frame =  self.bounds
        self.addSubview(counterView)
        counterView.text = "선택된 해더"
        counterView.numberOfLines = 1
        counterView.isHidden = true
        counterView.translatesAutoresizingMaskIntoConstraints = false

        NSLayoutConstraint.activate([
            counterView.topAnchor.constraint(equalTo: title.bottomAnchor, constant: 4)
        ])
        }

    private func configureTitle() {
        title.frame = self.bounds
        self.addSubview(title)
        title.font = .largeRegular
        title.textColor = .grey1
        title.text = ""
        title.numberOfLines = 2
        title.translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate([
            title.topAnchor.constraint(equalTo: self.topAnchor, constant: 24)
        ])
    }

    func setTitle(text: String) {
        title.text = text
    }

    private func setGestureRecoginzer() {
        let tapGuester = UITapGestureRecognizer(target: self, action: #selector(tapDetected))
        self.addGestureRecognizer(tapGuester)
    }

    @objc func tapDetected () {
        self.delegate?.didTapHeader(sender: self)
    }

}
