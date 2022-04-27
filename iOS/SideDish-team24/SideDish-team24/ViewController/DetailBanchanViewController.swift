import UIKit

class DetailBanchanViewController: UIViewController {
    
    static let identifier = "detailBanchanViewController"
    
    private var banchanViewModel: BanchanViewModel?
    
    private let detailBanchanView: DetailBanchanView = {
        let scrollView = DetailBanchanView()
        scrollView.translatesAutoresizingMaskIntoConstraints = false
        return scrollView
    }()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.layoutScollView()
        self.configure()
    }
    
    func setTarget(with viewModel: BanchanViewModel) {
        self.banchanViewModel = viewModel
    }
    
    func configure() {
        guard let banchanViewModel = banchanViewModel else { return }
        let title = banchanViewModel.title
        let description = banchanViewModel.description
        let price = banchanViewModel.price
        let listPrice = banchanViewModel.listPrice
        let specialBadge = banchanViewModel.discountPolicy
        
        self.detailBanchanView.configure(title: title, description: description, price: price, listPrice: listPrice)
        self.detailBanchanView.configure(specialBadge: specialBadge)
        
        DispatchQueue.global().async {
            let image = banchanViewModel.image
            DispatchQueue.main.sync {
                self.detailBanchanView.configure(image: image)
            }
        }
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
