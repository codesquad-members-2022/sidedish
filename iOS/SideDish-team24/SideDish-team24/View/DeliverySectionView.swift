import UIKit

class DeliverySectionView: UIView {
    
    private let reserveTitle = UILabel.customLabel("적립금", UIColor.dishLightGrey)
    private let reserve = UILabel.customLabel("126원", UIColor.dishGrey)
    private let deliveryTitle = UILabel.customLabel("배송정보", UIColor.dishLightGrey)
    private let deliveryInformation = UILabel.customLabel("서울 경기 새벽 배송, 전국 택배 배송", UIColor.dishGrey)
    private let deliveryFeeTitle = UILabel.customLabel("배송비", UIColor.dishLightGrey)
    private let deliveryFee = UILabel.customLabel("2,500원 (40,000원 이상 구매 시 무료)", UIColor.dishGrey)
    
    private let titleSection : UIStackView = {
        let stackView = UIStackView()
        stackView.translatesAutoresizingMaskIntoConstraints = false
        stackView.axis = .vertical
        stackView.distribution = .fillEqually
        stackView.spacing = CGFloat.defaultInset
        
        return stackView
    }()
    private let informationSection : UIStackView = {
        let stackView = UIStackView()
        stackView.translatesAutoresizingMaskIntoConstraints = false
        stackView.axis = .vertical
        stackView.distribution = .fillEqually
        stackView.spacing = CGFloat.defaultInset
        
        return stackView
    }()
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        self.layoutTitleSection()
        self.layoutInformationSection()
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        self.layoutTitleSection()
        self.layoutInformationSection()
    }
    
}

private extension DeliverySectionView {
    func layoutTitleSection() {
        self.addSubview(titleSection)
        
        self.titleSection.addArrangedSubview(self.reserveTitle)
        self.titleSection.addArrangedSubview(self.deliveryTitle)
        self.titleSection.addArrangedSubview(self.deliveryFeeTitle)
        
        NSLayoutConstraint.activate([
            self.titleSection.leadingAnchor.constraint(equalTo: self.leadingAnchor),
            self.titleSection.topAnchor.constraint(equalTo: self.topAnchor),
            self.titleSection.bottomAnchor.constraint(equalTo: self.bottomAnchor),
            self.titleSection.widthAnchor.constraint(equalTo: self.widthAnchor, multiplier: 0.2),
        ])
    }
    
    func layoutInformationSection() {
        self.addSubview(informationSection)
        
        self.informationSection.addArrangedSubview(self.reserve)
        self.informationSection.addArrangedSubview(self.deliveryInformation)
        self.informationSection.addArrangedSubview(self.deliveryFee)
        
        NSLayoutConstraint.activate([
            self.informationSection.leadingAnchor.constraint(equalTo: self.titleSection.trailingAnchor, constant: CGFloat.defaultInset),
            self.informationSection.topAnchor.constraint(equalTo: self.topAnchor),
            self.informationSection.bottomAnchor.constraint(equalTo: self.bottomAnchor),
            self.informationSection.trailingAnchor.constraint(equalTo: self.trailingAnchor),
        ])
    }
    
}
