import UIKit

class BriefBanchanViewCell: UICollectionViewCell {
    
    static let cellId = "briefBanchanViewCell"
    
    private var dishImage: UIImageView = {
        let imageView = UIImageView()
        imageView.translatesAutoresizingMaskIntoConstraints = false
        return imageView
    }()
    
    private var dishTitle: UILabel = UILabel.customLabel("요리 제목", .dishBlack, 14)
    private var dishDescription: UILabel = UILabel.customLabel("감질맛 나는 요리 설명", .dishLightGrey, 14)
    private var price: UILabel = UILabel.customLabel("판매가", .dishBlack, 14, 600)
    private var listPrice: UILabel = UILabel.customLabel("정가", .dishLightGrey, 14)
    
    private var breifStackView: UIStackView = UIStackView.customStackView(.vertical, .fillEqually)
    private var specialPrices: UIStackView = UIStackView.customStackView(.horizontal, .fillEqually)
    private var prices: UIStackView = UIStackView.customStackView(.horizontal, .fill)
    
    override func prepareForReuse() {
        specialPrices.subviews.forEach {
            $0.removeFromSuperview()
        }
    }
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        self.layoutDishImage()
        self.layoutBreifStackView()
        self.layoutPriceStackView()
        self.layoutSpecialPrice()
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        self.layoutDishImage()
        self.layoutBreifStackView()
        self.layoutPriceStackView()
        self.layoutSpecialPrice()
    }
    
    func configure(image: UIImage) {
        self.dishImage.image = image
    }
    
    func configure(title: String, description: String) {
        self.dishTitle.text = title
        self.dishDescription.text = description
        
    }
    
    func configure(price: String, listPrice: String?) {
        self.price.text = price
        self.listPrice.text = listPrice
    }
    
    func configure(specialBadge: String) {
        self.specialPrices.addArrangedSubview(UILabel.customBadge("\(specialBadge)", .dishBlue))
    }
    
}

private extension BriefBanchanViewCell {
    func layoutDishImage() {
        self.addSubview(self.dishImage)
        
        NSLayoutConstraint.activate([
            self.dishImage.leadingAnchor.constraint(equalTo: self.leadingAnchor),
            self.dishImage.topAnchor.constraint(equalTo: self.topAnchor),
            self.dishImage.bottomAnchor.constraint(equalTo: self.bottomAnchor),
            
            self.dishImage.widthAnchor.constraint(equalTo: self.heightAnchor, multiplier: 1)
        ])
    }
    
    func layoutBreifStackView() {
        self.addSubview(self.breifStackView)
        
        self.breifStackView.addArrangedSubview(self.dishTitle)
        self.breifStackView.addArrangedSubview(self.dishDescription)
        self.breifStackView.addArrangedSubview(self.prices)
        
        NSLayoutConstraint.activate([
            self.breifStackView.leadingAnchor.constraint(equalTo: self.dishImage.trailingAnchor, constant: CGFloat.defaultInset),
            self.breifStackView.trailingAnchor.constraint(equalTo: self.trailingAnchor, constant: -CGFloat.defaultInset),
            self.breifStackView.topAnchor.constraint(equalTo: self.topAnchor, constant: CGFloat.defaultInset)
        ])
    }
    
    func layoutPriceStackView() {
        self.prices.addArrangedSubview(self.price)
        self.prices.addArrangedSubview(self.listPrice)
        
        self.listPrice.attributedText = self.listPrice.text?.strikeThrough()
    }
    
    func layoutSpecialPrice() {
        self.addSubview(self.specialPrices)
        
        NSLayoutConstraint.activate([
            self.specialPrices.topAnchor.constraint(equalTo: self.breifStackView.bottomAnchor, constant: CGFloat.defaultInset),
            self.specialPrices.leadingAnchor.constraint(equalTo: self.dishImage.trailingAnchor, constant: CGFloat.defaultInset)
        ])
    }
    
}
