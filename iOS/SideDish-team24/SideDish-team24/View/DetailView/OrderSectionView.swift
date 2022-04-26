import UIKit

class OrderSectionView: UIView {
    
    private let totalAmountTitleLabel: UILabel = UILabel.customLabel(.dishLightGrey, "총 주문금액", 18, 600)
    private let totalAmountLabel: UILabel = UILabel.customLabel(.dishBlack, "12,640원", 32, 600)
    private let orderButton: UIButton = UIButton.customButton("주문하기", .dishBlue)
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        self.layoutAmountLabel()
        self.layoutTitleLabel()
        self.layoutOrderButton()
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        self.layoutAmountLabel()
        self.layoutTitleLabel()
        self.layoutOrderButton()
    }
    
    func setAmount(amount: String) {
        self.totalAmountLabel.text = "\(amount)원"
    }
}

private extension OrderSectionView {
    func layoutTitleLabel() {
        self.addSubview(totalAmountTitleLabel)

        NSLayoutConstraint.activate([
            self.totalAmountTitleLabel.trailingAnchor.constraint(equalTo: self.totalAmountLabel.leadingAnchor, constant: -CGFloat.defaultInset*3),
            self.totalAmountTitleLabel.centerYAnchor.constraint(equalTo: self.totalAmountLabel.centerYAnchor)
        ])
    }
    
    func layoutAmountLabel() {
        self.addSubview(totalAmountLabel)
        
        NSLayoutConstraint.activate([
            self.totalAmountLabel.trailingAnchor.constraint(equalTo: self.trailingAnchor),
            self.totalAmountLabel.topAnchor.constraint(equalTo: self.topAnchor)
        ])
    }
    
    func layoutOrderButton() {
        self.addSubview(orderButton)
        
        NSLayoutConstraint.activate([
            self.orderButton.leadingAnchor.constraint(equalTo: self.leadingAnchor),
            self.orderButton.trailingAnchor.constraint(equalTo: self.trailingAnchor),
            self.orderButton.bottomAnchor.constraint(equalTo: self.bottomAnchor),
            self.orderButton.topAnchor.constraint(equalTo: self.totalAmountLabel.bottomAnchor, constant: CGFloat.defaultInset*3)
        ])
    }
}
