import UIKit

class DeliverySectionView: UIView {
    
    private let reserveTitle = CustomLabel(title: "적립금", font: .smallRegular, color: .dishGrey1)
    private let reserve = CustomLabel(title: "126원", font: .smallRegular, color: .dishGrey2)
    private let deliveryTitle = CustomLabel(title: "배송정보", font: .smallRegular, color: .dishGrey1)
    private let deliveryInformation = CustomLabel(title: "새벽배송, 택배배송", font: .smallRegular, color: .dishGrey2)
    private let deliveryFeeTitle = CustomLabel(title: "배송비", font: .smallRegular, color: .dishGrey1)
    private let deliveryFee = CustomLabel(title: "2,500원 (40,000원 이상 구매 시 무료)", font: .smallRegular, color: .dishGrey2)
    
    private let titleSection: UIStackView = UIStackView.customStackView(.vertical, .fillEqually, spacing: CGFloat.defaultInset)
    private let informationSection: UIStackView = UIStackView.customStackView(.vertical, .fillEqually, spacing: CGFloat.defaultInset)
    
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
            self.titleSection.widthAnchor.constraint(equalTo: self.widthAnchor, multiplier: 0.2)
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
            self.informationSection.trailingAnchor.constraint(equalTo: self.trailingAnchor)
        ])
    }
    
}
