import UIKit

class DishCell: UICollectionViewCell {

    static let identifier = "DishCell"

    @IBOutlet weak var thumbNailImageView: UIImageView!
    @IBOutlet weak var titleLabel: UILabel!
    @IBOutlet weak var descriptionLabel: UILabel!
    @IBOutlet weak var finalPriceLabel: UILabel!
    @IBOutlet weak var normalPriceLabel: UILabel!
    @IBOutlet weak var badgeView: UIStackView!
    @IBOutlet weak var eventBadgeLabel: UILabel!
    @IBOutlet weak var launchingBadgeLabel: UILabel!

    override func awakeFromNib() {
        super.awakeFromNib()
    }

    func configure(with product: Product) {
        thumbNailImageView.image = product.image
        titleLabel.text = product.title
        descriptionLabel.text = product.description
        finalPriceLabel.text = product.salePrice
        normalPriceLabel.text = ""
        if let normalPrice = product.normalPrice {
            let attributedStyle = NSUnderlineStyle.single
            let attributedString = NSMutableAttributedString(string: normalPrice)
            attributedString.addAttribute(NSAttributedString.Key.strikethroughStyle,
                                          value: attributedStyle.rawValue,
                                          range: NSRange(0..<attributedString.length))

            normalPriceLabel.attributedText = attributedString
        }
        if let discountType = product.discountType {
            badgeView.isHidden = false
            discountType.forEach {
                switch $0 {
                case .event:
                    self.eventBadgeLabel.isHidden = false
                case .launching:
                    self.launchingBadgeLabel.isHidden = false
                }
            }
        }
    }
    
    override func prepareForReuse() {
        self.badgeView.isHidden = true
        self.eventBadgeLabel.isHidden = true
        self.launchingBadgeLabel.isHidden = true
    }
}
