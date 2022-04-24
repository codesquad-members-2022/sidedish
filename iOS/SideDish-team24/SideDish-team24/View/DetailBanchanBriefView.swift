import UIKit

class DetailBanchanBriefView: UIView {
    
    // 스크롤 뷰(좌우)
    private var dishImage: UIImageView = {
        let imageView = UIImageView()
        imageView.translatesAutoresizingMaskIntoConstraints = false
        return imageView
    }()
    
    private var dishTitle: UILabel = {
        let label = UILabel.customLabel("요리 제목", .dishBlack, 32, 400, true)
        return label
    }()
    
    private var dishDescription: UILabel = {
        let label = UILabel.customLabel("감질맛 나는 요리 설명", .dishLightGrey, 18)
        return label
    }()
    
    private var discountPrice: UILabel = {
        let label = UILabel.customLabel("12,640원", .dishBlack, 18, 600)
        return label
    }()
    
    private var normalPrice: UILabel = {
        let label = UILabel.customLabel("15,800원", .dishLightGrey, 16)
        return label
    }()
    
    private var specialPrice: UILabel = {
        let label = UILabel.customLabel("특가 정보", .dishWhite, 12, 600)
        label.textAlignment = .center
        label.backgroundColor = UIColor.dishBlue
        label.layer.cornerRadius = 13
        label.clipsToBounds = true
        return label
    }()
    
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
    
    private var blank: UILabel = {
        let label = UILabel()
        label.translatesAutoresizingMaskIntoConstraints = false
        return label
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

private extension DetailBanchanBriefView {
    func layoutDishImage() {
        self.addSubview(self.dishImage)
        self.addSubview(self.breifStackView)
        self.addSubview(self.specialPrice)
        NSLayoutConstraint.activate([
            self.dishImage.leadingAnchor.constraint(equalTo: self.leadingAnchor),
            self.dishImage.topAnchor.constraint(equalTo: self.topAnchor),
            self.dishImage.trailingAnchor.constraint(equalTo: self.trailingAnchor),
            self.dishImage.heightAnchor.constraint(equalTo: self.widthAnchor, multiplier: 1),
        ])
    }
    
    func layoutBreifStackView() {
        self.breifStackView.addArrangedSubview(self.dishTitle)
        self.breifStackView.addArrangedSubview(self.dishDescription)
        self.breifStackView.addArrangedSubview(self.prices)
        
        NSLayoutConstraint.activate([
            self.breifStackView.leadingAnchor.constraint(equalTo: self.leadingAnchor),
            self.breifStackView.trailingAnchor.constraint(equalTo: self.trailingAnchor),
            self.breifStackView.topAnchor.constraint(equalTo: self.dishImage.bottomAnchor),
        ])
    }
    
    func layoutPriceStackView() {
        self.prices.addArrangedSubview(self.discountPrice)
        self.prices.addArrangedSubview(self.normalPrice)
        self.prices.addArrangedSubview(self.blank)
        
        NSLayoutConstraint.activate([
            self.specialPrice.topAnchor.constraint(equalTo: self.breifStackView.bottomAnchor),
            self.specialPrice.leadingAnchor.constraint(equalTo: self.leadingAnchor),
            self.specialPrice.widthAnchor.constraint(equalTo: self.breifStackView.widthAnchor, multiplier: 0.3),
            self.specialPrice.heightAnchor.constraint(equalTo: self.breifStackView.heightAnchor, multiplier: 0.3),
            self.specialPrice.bottomAnchor.constraint(equalTo: self.bottomAnchor),
        ])
        
        self.normalPrice.attributedText = self.normalPrice.text?.strikeThrough()
    }
}
