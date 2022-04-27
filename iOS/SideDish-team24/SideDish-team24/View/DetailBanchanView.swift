import UIKit

class DetailBanchanView: UIScrollView {
    
    private let innerView: UIStackView = {
        let stackView = UIStackView()
        stackView.translatesAutoresizingMaskIntoConstraints = false
        stackView.axis = .vertical
        stackView.distribution = .equalSpacing
        return stackView
    }()
    
    private let banchanImageSection: UIImageView = {
        let imageView = UIImageView()
        imageView.translatesAutoresizingMaskIntoConstraints = false
        imageView.layer.cornerRadius = 10
        imageView.clipsToBounds = true
        return imageView
    }()
    private let banchanBriefSection = BanchanBriefView(type: .detail)
    private let deliverySection = DeliverySectionView()
    private let counterSection = OrderCountSectionView()
    private let orderSection = OrderSectionView()
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        self.layoutInnerView()
        self.layoutImageSection()
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        self.layoutInnerView()
        self.layoutImageSection()
    }
    
    func configure(title: String, description: String, price: String, listPrice: String?) {
        self.banchanBriefSection.configure(title: title, description: description)
        self.banchanBriefSection.configure(price: price, listPrice: listPrice)
        
        self.orderSection.setAmount(amount: price)
    }
    
    func configure(image: UIImage?) {
        self.banchanImageSection.image = image
    }
    
    func configure(specialBadge: String?) {
        self.banchanBriefSection.configure(specialBadge: specialBadge)
    }
    
}

private extension DetailBanchanView {
    
    func layoutInnerView() {
        self.addSubview(innerView)
        
        self.innerView.addBorder(with: banchanImageSection)
        self.innerView.addBorder(with: banchanBriefSection)
        self.innerView.addBorder(with: deliverySection)
        self.innerView.addBorder(with: counterSection)
        self.innerView.addBorder(with: orderSection)
        
        NSLayoutConstraint.activate([
            self.innerView.topAnchor.constraint(equalTo: self.contentLayoutGuide.topAnchor),
            self.innerView.bottomAnchor.constraint(equalTo: self.contentLayoutGuide.bottomAnchor),
            self.innerView.leadingAnchor.constraint(equalTo: self.contentLayoutGuide.leadingAnchor, constant: CGFloat.defaultInset),
            self.innerView.trailingAnchor.constraint(equalTo: self.contentLayoutGuide.trailingAnchor, constant: -CGFloat.defaultInset),
            self.innerView.widthAnchor.constraint(equalTo: self.frameLayoutGuide.widthAnchor, constant: -CGFloat.defaultInset*2),
            self.innerView.heightAnchor.constraint(greaterThanOrEqualToConstant: self.safeAreaLayoutGuide.layoutFrame.height)
        ])
    }
    
    func layoutImageSection() {
        NSLayoutConstraint.activate([
            self.banchanImageSection.widthAnchor.constraint(equalTo: self.banchanImageSection.heightAnchor, multiplier: 1)
        ])
    }
    
}
