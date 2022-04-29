import UIKit

class HeaderCollectionReusableView: UICollectionReusableView {
    static let identifier = "HeaderCollectionReusableView"
    private var ordering: Ordering?

    private lazy var headerLabel: UILabel = {
        let label = UILabel()
        label.textColor = .black
        label.font = UIFont.systemFont(ofSize: 30)
        label.numberOfLines = 2
        label.translatesAutoresizingMaskIntoConstraints = false
        return label
        
    }()
        
    override init(frame: CGRect){
        super.init(frame: frame)
        addSubview(headerLabel)
        setLayout()
    }
    
    required init?(coder: NSCoder){
        fatalError()
    }
    
    func setLayout(){
        headerLabel.topAnchor.constraint(equalTo: self.topAnchor).isActive = true
        headerLabel.leadingAnchor.constraint(equalTo: self.leadingAnchor, constant: 20).isActive = true
        headerLabel.trailingAnchor.constraint(equalTo: self.trailingAnchor).isActive = true
        headerLabel.bottomAnchor.constraint(equalTo: self.bottomAnchor).isActive = true
    }
    
    func inputHeader(category: String) {
        headerLabel.text = category
    }
}
    
