import UIKit

class BriefBanchanViewCell: UICollectionViewCell {
    
    static let cellId = "briefBanchanViewCell"
    
    private var dishImage: UIImageView = {
        let imageView = UIImageView()
        imageView.translatesAutoresizingMaskIntoConstraints = false
        imageView.layer.cornerRadius = 10
        imageView.clipsToBounds = true
        return imageView
    }()
    
    private var banchanBreif: BanchanBriefView = BanchanBriefView(type: .brief)
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        self.layoutDishImage()
        self.layoutBanchanBrief()
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        self.layoutDishImage()
        self.layoutBanchanBrief()
    }
    
    override func prepareForReuse() {
        self.banchanBreif.removeBadges()
    }
    
    func configure(image: UIImage) {
        self.dishImage.image = image
    }
    
    func configure(title: String, description: String) {
        self.banchanBreif.configure(title: title, description: description)
    }

    func configure(price: String, listPrice: String?) {
        self.banchanBreif.configure(price: price, listPrice: listPrice)
    }

    func configure(specialBadge: String) {
        self.banchanBreif.configure(specialBadge: specialBadge)
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
    
    func layoutBanchanBrief() {
        self.addSubview(self.banchanBreif)
        
        NSLayoutConstraint.activate([
            self.banchanBreif.leadingAnchor.constraint(equalTo: self.dishImage.trailingAnchor, constant: CGFloat.defaultInset),
            self.banchanBreif.topAnchor.constraint(equalTo: self.topAnchor, constant: CGFloat.defaultInset),
            self.banchanBreif.bottomAnchor.constraint(equalTo: self.bottomAnchor, constant: -CGFloat.defaultInset)
        ])
    }
    
}
