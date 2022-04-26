import UIKit

class DetailBanchanViewController: UIViewController {
    
    static let identifier = "detailBanchanViewController"
    
    private let detailBanchanView: DetailBanchanView = {
        let scrollView = DetailBanchanView()
        scrollView.translatesAutoresizingMaskIntoConstraints = false
        return scrollView
    }()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.layoutScollView()
    }
    
    func configure(title: String, description: String, price: String, listPrice: String?) {
        self.detailBanchanView.configure(title: title, description: description, price: price, listPrice: listPrice)
    }
    
    func configure(image: UIImage?) {
        self.detailBanchanView.configure(image: image)
    }
    
    func configure(specialBadge: String?) {
        self.detailBanchanView.configure(specialBadge: specialBadge)
    }
    
}

private extension DetailBanchanViewController {
    func layoutScollView() {
        let safeArea = self.view.safeAreaLayoutGuide
        self.view.addSubview(detailBanchanView)
        
        NSLayoutConstraint.activate([
            self.detailBanchanView.topAnchor.constraint(equalTo: safeArea.topAnchor),
            self.detailBanchanView.bottomAnchor.constraint(equalTo: safeArea.bottomAnchor),
            self.detailBanchanView.leadingAnchor.constraint(equalTo: safeArea.leadingAnchor),
            self.detailBanchanView.trailingAnchor.constraint(equalTo: safeArea.trailingAnchor)
        ])
        
    }
    
}
