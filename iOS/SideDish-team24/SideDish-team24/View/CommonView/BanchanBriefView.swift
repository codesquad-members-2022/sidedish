import UIKit

class BanchanBriefView: UIStackView {
    
    enum ViewType {
        case brief
        case detail
    }
    
    private var dishTitle: CustomLabel = CustomLabel()
    private var dishDescription: CustomLabel = CustomLabel()
    private var price: CustomLabel = CustomLabel()
    private var listPrice: CustomLabel = CustomLabel()
    
    private var priceContainer: UIView = {
        let view = UIView()
        view.translatesAutoresizingMaskIntoConstraints = false
        return view
    }()

    private var badgeContainer: UIView = {
        let view = UIView()
        view.translatesAutoresizingMaskIntoConstraints = false
        return view
    }()

    private var prices: UIStackView = UIStackView.customStackView(.horizontal, .fill)
    private var specialPrices: UIStackView = UIStackView.customStackView(.horizontal, .fill)
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        self.layoutPriceStackView()
        self.layoutBreifStackView()
        self.layoutContainer()
    }

    required init(coder: NSCoder) {
        super.init(coder: coder)
        self.layoutPriceStackView()
        self.layoutBreifStackView()
        self.layoutContainer()
    }
    
    convenience init(type: ViewType) {
        self.init()
        self.layout(type: type)
    }
    
    func configure(title: String, description: String) {
        self.dishTitle.text = title
        self.dishDescription.text = description
    }
    
    func configure(price: String, listPrice: String?) {
        self.price.text = price
        guard let listPrice = listPrice else { return }
        self.listPrice.attributedText = listPrice.strikeThrough()
    }
    
    func configure(specialBadge: String?) {
        guard let specialBadge = specialBadge else { return }
        self.specialPrices.addArrangedSubview(PaddingLabel(title: specialBadge, color: .dishPrimaryDark))
    }
    
    func removeBadges() {
        self.specialPrices.subviews.forEach {
            $0.removeFromSuperview()
        }
    }
    
}

private extension BanchanBriefView {
    
    func layout(type: ViewType) {
        self.translatesAutoresizingMaskIntoConstraints = false
        self.axis = .vertical
        self.distribution = .equalSpacing
        self.spacing = CGFloat.defaultInset
        
        switch type {
        case .brief:
            self.dishTitle.setFont(font: .smallBold, color: .dishBlack)
            self.dishDescription.setFont(font: .smallRegular, color: .dishGrey2)
            self.price.setFont(font: .smallBold, color: .dishBlack)
            self.listPrice.setFont(font: .smallRegular, color: .dishGrey2)
        case .detail:
            self.dishTitle.setFont(font: .largeRegular, color: .dishBlack)
            self.dishDescription.setFont(font: .mediumRegular, color: .dishGrey2)
            self.price.setFont(font: .mediumBold, color: .dishGrey1)
            self.listPrice.setFont(font: .middleRegular, color: .dishGrey2)
        }
    }
    
    func layoutContainer() {
        self.badgeContainer.addSubview(self.specialPrices)
        self.priceContainer.addSubview(self.prices)
        
        NSLayoutConstraint.activate([
            self.specialPrices.topAnchor.constraint(equalTo: self.badgeContainer.topAnchor),
            self.specialPrices.leadingAnchor.constraint(equalTo: self.badgeContainer.leadingAnchor),
            self.specialPrices.bottomAnchor.constraint(equalTo: self.badgeContainer.bottomAnchor),
            
            self.prices.topAnchor.constraint(equalTo: self.priceContainer.topAnchor),
            self.prices.leadingAnchor.constraint(equalTo: self.priceContainer.leadingAnchor),
            self.prices.bottomAnchor.constraint(equalTo: self.priceContainer.bottomAnchor)
        ])
    }
    
    func layoutBreifStackView() {
        self.addArrangedSubview(self.dishTitle)
        self.addArrangedSubview(self.dishDescription)
        self.addArrangedSubview(self.priceContainer)
        self.addArrangedSubview(self.badgeContainer)
        self.addArrangedSubview(self.specialPrices)
    }
    
    func layoutPriceStackView() {
        self.prices.addArrangedSubview(self.price)
        self.prices.addArrangedSubview(self.listPrice)
    }
    
}
