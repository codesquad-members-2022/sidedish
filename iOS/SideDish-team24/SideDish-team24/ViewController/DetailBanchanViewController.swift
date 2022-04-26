import UIKit

class DetailBanchanViewController: UIViewController {
    
    static let identifier = "detailBanchanViewController"
    
    private let scrollView: UIScrollView = {
        let scrollView = UIScrollView()
        scrollView.translatesAutoresizingMaskIntoConstraints = false
        return scrollView
    }()
    
    private let innerView: UIStackView = {
        let stackView = UIStackView()
        stackView.translatesAutoresizingMaskIntoConstraints = false
        stackView.axis = .vertical
        stackView.distribution = .equalSpacing
        return stackView
    }()
    
    private let banchanImageSection: UIImageView = {
        let imageView = UIImageView()
        imageView.translatesAutoresizingMaskIntoConstraints = false
        imageView.contentMode = .scaleAspectFit
        return imageView
    }()
    private let banchanBriefSection = BanchanBriefView(type: .detail)
    private let deliverySection = DeliverySectionView()
    private let counterSection = OrderCountSectionView()
    private let orderSection = OrderSectionView()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.layoutScollView()
        self.layoutInnerView()
    }
    
    func configure(title: String, description: String, price: String, listPrice: String?) {
        self.banchanBriefSection.configure(title: title, description: description)
        self.banchanBriefSection.configure(price: price, listPrice: listPrice)
    }
    
    func configure(image: UIImage?) {
        self.banchanImageSection.image = image
    }
    
    func configure(specialBadge: String?) {
        self.banchanBriefSection.configure(specialBadge: specialBadge)
    }
    
}

private extension DetailBanchanViewController {
    func layoutScollView() {
        let safeArea = self.view.safeAreaLayoutGuide
        self.view.addSubview(scrollView)
        
        NSLayoutConstraint.activate([
            self.scrollView.topAnchor.constraint(equalTo: safeArea.topAnchor),
            self.scrollView.bottomAnchor.constraint(equalTo: safeArea.bottomAnchor),
            self.scrollView.leadingAnchor.constraint(equalTo: safeArea.leadingAnchor),
            self.scrollView.trailingAnchor.constraint(equalTo: safeArea.trailingAnchor)
        ])
        
    }
    
    func layoutInnerView() {
        self.scrollView.addSubview(innerView)
        
        self.innerView.addArrangedSubview(banchanImageSection)
        self.innerView.addArrangedSubview(banchanBriefSection)
        self.innerView.addArrangedSubview(deliverySection)
        self.innerView.addArrangedSubview(counterSection)
        self.innerView.addArrangedSubview(orderSection)
        
        NSLayoutConstraint.activate([
            self.innerView.topAnchor.constraint(equalTo: scrollView.contentLayoutGuide.topAnchor),
            self.innerView.bottomAnchor.constraint(equalTo: scrollView.contentLayoutGuide.bottomAnchor),
            self.innerView.leadingAnchor.constraint(equalTo: scrollView.contentLayoutGuide.leadingAnchor, constant: CGFloat.defaultInset),
            self.innerView.trailingAnchor.constraint(equalTo: scrollView.contentLayoutGuide.trailingAnchor, constant: -CGFloat.defaultInset),
            self.innerView.widthAnchor.constraint(equalTo: scrollView.frameLayoutGuide.widthAnchor, constant: -CGFloat.defaultInset*2),
            self.innerView.heightAnchor.constraint(greaterThanOrEqualToConstant: self.view.frame.height)
        ])
    }
    
}
