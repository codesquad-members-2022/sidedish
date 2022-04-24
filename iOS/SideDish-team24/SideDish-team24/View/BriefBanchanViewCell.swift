import UIKit

class BriefBanchanViewCell: UICollectionViewCell {
    
    static let cellId = "briefBanchanViewCell"
    
    private var dishImage: UIImageView = {
        let imageView = UIImageView()
        imageView.translatesAutoresizingMaskIntoConstraints = false
        return imageView
    }()
    
    private var dishTitle: UILabel = UILabel.customLabel("요리제목", .dishBlack, 14)
    private var dishDescription: UILabel = UILabel.customLabel("감질맛 나는 요리 설명", .dishLightGrey, 14)
    private var discountPrice: UILabel = UILabel.customLabel("12,640원", .dishBlack, 14, 600)
    private var normalPrice: UILabel = UILabel.customLabel("15,800", .dishLightGrey, 14)
    private var specialPrice: UILabel = UILabel.customBadge("특가정보", .dishBlue)
    
    private var prices: UIStackView = {
        let stackView = UIStackView()
        stackView.translatesAutoresizingMaskIntoConstraints = false
        stackView.axis = .horizontal
        stackView.distribution = .fillEqually
        return stackView
    }()
    
    private var breifStackView: UIStackView = {
        let stackView = UIStackView()
        stackView.axis = .vertical
        stackView.distribution = .fillEqually
        stackView.translatesAutoresizingMaskIntoConstraints = false
        return stackView
    }()
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        self.layoutDishImage()
        self.layoutBreifStackView()
        self.layoutPriceStackView()
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        self.layoutDishImage()
        self.layoutBreifStackView()
        self.layoutPriceStackView()
    }
}

private extension BriefBanchanViewCell {
    func layoutDishImage() {
        self.addSubview(self.dishImage)
        
        NSLayoutConstraint.activate([
            self.dishImage.leadingAnchor.constraint(equalTo: self.leadingAnchor),
            self.dishImage.topAnchor.constraint(equalTo: self.topAnchor),
            self.dishImage.bottomAnchor.constraint(equalTo: self.bottomAnchor),
            self.dishImage.widthAnchor.constraint(equalTo: self.heightAnchor, multiplier: 1),
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
            self.breifStackView.topAnchor.constraint(equalTo: self.topAnchor, constant: CGFloat.defaultInset),
        ])
    }
    
    func layoutPriceStackView() {
        self.addSubview(self.specialPrice)
        
        self.prices.addArrangedSubview(self.discountPrice)
        self.prices.addArrangedSubview(self.normalPrice)
        
        NSLayoutConstraint.activate([
            self.specialPrice.topAnchor.constraint(equalTo: self.breifStackView.bottomAnchor, constant: CGFloat.defaultInset),
            self.specialPrice.leadingAnchor.constraint(equalTo: self.dishImage.trailingAnchor, constant: CGFloat.defaultInset),
            self.specialPrice.widthAnchor.constraint(equalTo: self.breifStackView.widthAnchor, multiplier: 0.3),
            self.specialPrice.heightAnchor.constraint(equalTo: self.breifStackView.heightAnchor, multiplier: 0.3),
            self.specialPrice.bottomAnchor.constraint(equalTo: self.bottomAnchor, constant: -8),
        ])
        
        self.normalPrice.attributedText = self.normalPrice.text?.strikeThrough()
    }
    
}
