import UIKit

class DishCell: UICollectionViewCell {

    static let identifier = "DishCell"

    @IBOutlet weak var thumbNailImageView: UIImageView!
    @IBOutlet weak var titleLabel: UILabel!
    @IBOutlet weak var descriptionLabel: UILabel!
    @IBOutlet weak var finalPriceLabel: UILabel!
    @IBOutlet weak var normalPriceLabel: UILabel!
    @IBOutlet weak var badgeView: UIView!
    @IBOutlet weak var eventBadgeLabel: UILabel!
    @IBOutlet weak var launchingBadgeLabel: UILabel!

    override func awakeFromNib() {
        super.awakeFromNib()
    }

    func configure(image: UIImage, title: String, description: String, finalPrice: Int, normalPrice: Int?, discountType: [DiscountType]?) {
        thumbNailImageView.image = image
        titleLabel.text = title
        descriptionLabel.text = description
        finalPriceLabel.text = "\(finalPrice)원"
        normalPriceLabel.text = ""

        if let normalPrice = normalPrice {
            let attributedStyle = NSUnderlineStyle.single
            let attributedString = NSMutableAttributedString(string: "\(normalPrice)원")
            attributedString.addAttribute(NSAttributedString.Key.strikethroughStyle,
                                          value: attributedStyle.rawValue,
                                          range: NSRange(0..<attributedString.length))

            normalPriceLabel.attributedText = attributedString
        }

        if let discountType = discountType {
            badgeView.isHidden = false
            discountType.forEach {
                switch $0 {
                case .event:
                    self.eventBadgeLabel.isHidden = false
                case .launching:
                    self.launchingBadgeLabel.isHidden = false
                }
            }

            if self.eventBadgeLabel.isHidden == true && self.launchingBadgeLabel.isHidden == false {
                self.launchingBadgeLabel.leadingAnchor.constraint(equalTo: self.badgeView.leadingAnchor).isActive = true
            }
        }
    }
}
