import UIKit

class BriefBanchanReusableView: UICollectionReusableView {
    
    static let identifier = "reusableHeader"
    
    private var title: UILabel = {
        let label = UILabel()
        label.translatesAutoresizingMaskIntoConstraints = false
        label.font = UIFont.systemFont(ofSize: 32, weight: UIFont.Weight(400))
        label.textColor = UIColor.dishLightGrey
        label.lineBreakMode = .byTruncatingTail
        label.numberOfLines = 2
        label.text = "모두가 좋아하는 \n든든한 요리 타이틀"
        return label
    }()
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        layout()
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        layout()
    }
    
    private func layout() {
        self.addSubview(self.title)
        NSLayoutConstraint.activate([
            self.title.topAnchor.constraint(equalTo: self.topAnchor),
            self.title.leadingAnchor.constraint(equalTo: self.leadingAnchor),
            self.title.trailingAnchor.constraint(equalTo: self.trailingAnchor),
            self.title.bottomAnchor.constraint(equalTo: self.bottomAnchor),
            self.title.heightAnchor.constraint(greaterThanOrEqualToConstant: CGFloat.defaultInset*12)
        ])
    }
}
