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
        self.publish()
    }
    
    func publish() {
        NotificationCenter.default.addObserver(forName: .stepperTouched,
                                               object: nil,
                                               queue: .main,
                                               using: stepperTouched(noti:))
    }
    
    func setTarget(with viewModel: BanchanViewModel) {
        self.banchanViewModel = viewModel
    }
    
}

private extension DetailBanchanViewController {
    func stepperTouched(noti: Notification) {
        guard let newValue = noti.userInfo?[NotificationKeyValue.stepperValue] as? Double else { return }
        self.banchanViewModel?.count = Int(newValue)
    }
    
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
    
    func configure() {
        guard let banchanViewModel = banchanViewModel else { return }

        self.detailBanchanView.configure(title: banchanViewModel.title,
                                         description: banchanViewModel.description,
                                         price: banchanViewModel.price,
                                         listPrice: banchanViewModel.listPrice)
        self.detailBanchanView.configure(specialBadge: banchanViewModel.discountPolicy)
        
        DispatchQueue.global().async {
            let image = banchanViewModel.image
            DispatchQueue.main.sync {
                self.detailBanchanView.configure(image: image)
            }
        }
    }
    
}
