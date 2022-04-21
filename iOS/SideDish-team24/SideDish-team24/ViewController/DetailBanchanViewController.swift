import UIKit

class DetailBanchanViewController: UIViewController {
    
    static let identifier = "detailBanchanViewController"
    
    private let scrollView = UIScrollView()
    
    private let innerView : UIStackView = {
        let stackView = UIStackView()
        stackView.translatesAutoresizingMaskIntoConstraints = false
        stackView.axis = .vertical
        stackView.distribution = .equalSpacing
        return stackView
    }()
    
    private let banchanBrief = DetailBanchanBriefView()
    private let deliverySection = DeliverySectionView()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.layout()
    }
    
}

private extension DetailBanchanViewController {
    func layout() {
        let safeArea = self.view.safeAreaLayoutGuide
        self.view.addSubview(scrollView)
        self.scrollView.translatesAutoresizingMaskIntoConstraints = false
        
        NSLayoutConstraint.activate([
            self.scrollView.topAnchor.constraint(equalTo: safeArea.topAnchor),
            self.scrollView.bottomAnchor.constraint(equalTo: safeArea.bottomAnchor),
            self.scrollView.leadingAnchor.constraint(equalTo: safeArea.leadingAnchor),
            self.scrollView.trailingAnchor.constraint(equalTo: safeArea.trailingAnchor)
        ])
        
        self.scrollView.addSubview(innerView)
        self.innerView.translatesAutoresizingMaskIntoConstraints = false
        
        self.innerView.addArrangedSubview(banchanBrief)
        self.innerView.addArrangedSubview(deliverySection)
        NSLayoutConstraint.activate([
            self.innerView.topAnchor.constraint(equalTo: scrollView.contentLayoutGuide.topAnchor),
            self.innerView.bottomAnchor.constraint(equalTo: scrollView.contentLayoutGuide.bottomAnchor),
            self.innerView.leadingAnchor.constraint(equalTo: scrollView.contentLayoutGuide.leadingAnchor),
            self.innerView.trailingAnchor.constraint(equalTo: scrollView.contentLayoutGuide.trailingAnchor),
            self.innerView.widthAnchor.constraint(equalTo: scrollView.frameLayoutGuide.widthAnchor),
            self.innerView.heightAnchor.constraint(greaterThanOrEqualToConstant: self.view.frame.height),
        ])
    }
    
}
