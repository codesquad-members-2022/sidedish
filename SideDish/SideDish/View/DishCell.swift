import UIKit

class DishCell: UICollectionViewCell {

    static let identifier = "DishCell"

    @IBOutlet weak var thumbNailImageView: UIImageView!
    @IBOutlet weak var titleLabel: UILabel!
    @IBOutlet weak var descriptionLabel: UILabel!
    @IBOutlet weak var finalPriceLabel: UILabel!
    @IBOutlet weak var normalPriceLabel: UILabel!
    @IBOutlet weak var badgeView: UIView!

    override func awakeFromNib() {
        super.awakeFromNib()
    }

    func configure(image: UIImage, title: String, description: String, finalPrice: Int, normalPrice: Int?, discountType: DiscountType?) {
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

        if let discountType = discountType,
           let badgeLabel = badgeView.subviews.first as? UILabel {
            badgeView.isHidden = false
            badgeLabel.backgroundColor = discountType.labelColor
            badgeLabel.text = discountType.description
        }
    }
}

enum DiscountType {
    case event
    case launching

    var description: String {
        switch self {
        case .event:
                return "이벤트특가"
        case .launching:
                return "런칭특가"
        }
    }

    var labelColor: UIColor {
        switch self {
        case .event:
                return UIColor.init(red: 0, green: 102/255, blue: 214/255, alpha: 1.0)
        case .launching:
                return UIColor.init(red: 128/255, green: 188/255, blue: 1, alpha: 1.0)
        }
    }
}
