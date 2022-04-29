import Foundation
import UIKit

final class HeaderViewCell: UICollectionViewCell{
    private lazy var headerViewLabel: UILabel = {
        let label = UILabel()
        label.text = "먹으면 잠이 솔솔 오는 맛있는 밥이지라"
        label.textColor = .black
        label.backgroundColor = .red
        label.font = UIFont.systemFont(ofSize: 30)
        label.translatesAutoresizingMaskIntoConstraints = false
        return label
    }()
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        addViews()
        setLayout()
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
    }

    private func addViews(){
        contentView.addSubview(headerViewLabel)
    }
    
    private func setLayout(){
        NSLayoutConstraint.activate([
            headerViewLabel.topAnchor.constraint(equalTo: contentView.topAnchor),
            headerViewLabel.leadingAnchor.constraint(equalTo: contentView.leadingAnchor),
            headerViewLabel.trailingAnchor.constraint(equalTo: contentView.trailingAnchor),
            headerViewLabel.heightAnchor.constraint(equalTo: contentView.heightAnchor, multiplier: 1)
            
        ])
    }
}
