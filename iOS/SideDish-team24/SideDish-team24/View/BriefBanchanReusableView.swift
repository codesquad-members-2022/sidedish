import UIKit

class BriefBanchanReusableView: UICollectionReusableView {
    
    static let identifier = "reusableHeader"
    
    private var title: UILabel = {
        let label = UILabel.customLabel(.dishGrey, "모두가 좋아하는 \n든든한 요리 타이틀", 32)
        label.lineBreakMode = .byTruncatingTail
        label.numberOfLines = 2
        return label
    }()
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        layoutTitle()
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        layoutTitle()
    }
    
    private func layoutTitle() {
        self.addSubview(self.title)
        NSLayoutConstraint.activate([
            self.title.topAnchor.constraint(equalTo: self.topAnchor),
            self.title.leadingAnchor.constraint(equalTo: self.leadingAnchor),
            self.title.trailingAnchor.constraint(equalTo: self.trailingAnchor),
            self.title.bottomAnchor.constraint(equalTo: self.bottomAnchor),
            self.title.heightAnchor.constraint(greaterThanOrEqualToConstant: CGFloat.defaultInset*12)
        ])
    }
    
    func setTitle(to string: String) {
        self.title.text = string
    }
}
