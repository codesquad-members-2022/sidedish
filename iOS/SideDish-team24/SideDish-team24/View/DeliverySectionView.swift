import UIKit

class DeliverySectionView: UIView {
    
    private let reserveTitle = UILabel.customLabel(.dishLightGrey, "적립금")
    private let reserve = UILabel.customLabel(.dishGrey, "126원")
    private let deliveryTitle = UILabel.customLabel(.dishLightGrey, "배송정보")
    private let deliveryInformation = UILabel.customLabel(.dishGrey, "서울 경기 새벽 배송, 전국 택배 배송")
    private let deliveryFeeTitle = UILabel.customLabel(.dishLightGrey, "배송비")
    private let deliveryFee = UILabel.customLabel( .dishGrey, "2,500원 (40,000원 이상 구매 시 무료")
    
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
