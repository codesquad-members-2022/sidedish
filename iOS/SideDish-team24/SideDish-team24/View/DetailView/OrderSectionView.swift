import UIKit

class OrderSectionView: UIView {
    
    private let totalAmountTitleLabel = CustomLabel(title: "총 주문금액", font: .mediumBold, color: .dishGrey2)
    private let totalAmountLabel = CustomLabel(title: "12,640원", font: .largeBold, color: .dishBlack)
    private let orderButton: UIButton = UIButton.customButton("주문하기", .dishPrimaryDark)
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        self.layoutAmountLabel()
        self.layoutTitleLabel()
        self.layoutOrderButton()
        self.publish()
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        self.layoutAmountLabel()
        self.layoutTitleLabel()
        self.layoutOrderButton()
        self.publish()
    }
    
    func setAmount(amount: String) {
        self.totalAmountLabel.text = amount
    }
}

private extension OrderSectionView {
    func publish() {
        NotificationCenter.default.addObserver(forName: .counterValueChanged,
                                               object: nil,
                                               queue: .main,
                                               using: changeAmountValue(noti:))
    }
    
    func changeAmountValue(noti: Notification) {
        guard let amount = noti.userInfo?[NotificationKeyValue.amount] as? Int else { return }
        self.totalAmountLabel.text = amount.convertToWon()
    }
    
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
