import UIKit

class DetailViewController: UIViewController {

    private let detailView: DetailView
    private var viewModel: DishDetailViewModel?

    init(viewModel: DishDetailViewModel) {
        detailView = DetailView()
        self.viewModel = viewModel
        super.init(nibName: nil, bundle: nil)

        setViewModel()
    }

    required init?(coder: NSCoder) {
        detailView = DetailView()
        self.viewModel = nil
        super.init(coder: coder)
    }

    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(animated)

        viewModel?.fetchDetailData()
        view = detailView
    }

    override func viewDidLoad() {
        super.viewDidLoad()
        navigationController?.navigationBar.topItem?.backButtonTitle = "뒤로"
        navigationController?.navigationBar.titleTextAttributes =
        [NSAttributedString.Key.font: UIFont(name: Font.sfSemiBold, size: 17) ?? UIFont.systemFont(ofSize: 17)]

        detailView.setLayout()
    }

    private func setViewModel() {
        viewModel?.onUpdate = {
            DispatchQueue.main.async {
                self.navigationItem.title = self.viewModel?.title
                self.detailView.titleLabel.text = self.viewModel?.title
                self.detailView.descriptionLabel.text = self.viewModel?.description
                self.detailView.finalPriceLabel.text = self.viewModel?.finalPrice
                self.detailView.pointLabel.text = self.viewModel?.point
                self.detailView.shippingInfoLabel.text = self.viewModel?.deliveryInfo
                self.detailView.shippingFeeLabel.text = self.viewModel?.deliveryFee

                if let normalPrice = self.viewModel?.normalPrice {
                    let attributedStyle = NSUnderlineStyle.single
                    let attributedString = NSMutableAttributedString(string: normalPrice)
                    attributedString.addAttribute(NSAttributedString.Key.strikethroughStyle,
                                                  value: attributedStyle.rawValue,
                                                  range: NSRange(0..<attributedString.length))
                    self.detailView.normalPriceLabel.attributedText = attributedString
                }
                
                if let discountType = self.viewModel?.discountType {
                    self.detailView.badgeStackView.isHidden = false
                    discountType.forEach {
                        switch $0 {
                            case .event:
                                self.detailView.eventBadgeLabel.isHidden = false
                            case .launching:
                                self.detailView.launchingBadgeLabel.isHidden = false
                        }
                    }
                }
            }
        }

        viewModel?.onUpdateWithTopImages = {
            DispatchQueue.main.async {
                self.viewModel?.topImages.forEach { image in
                    let topImageView = UIImageView(image: image)
                    topImageView.contentMode = .scaleAspectFit
                    topImageView.widthAnchor.constraint(equalTo: topImageView.heightAnchor).isActive = true

                    self.detailView.productImageContentView.addArrangedSubview(topImageView)
                }
            }
        }

        viewModel?.onUpdateWithDetailImages = {
            DispatchQueue.main.async {
                self.viewModel?.detailImages.forEach { image in
                    let ratio = image.size.height / image.size.width
                    let detailImageView = UIImageView(image: image)
                    let newWidth = self.detailView.detailImageStackView.frame.width
                    let newHeight = newWidth * ratio

                    detailImageView.contentMode = .scaleAspectFit
                    detailImageView.translatesAutoresizingMaskIntoConstraints = false
                    detailImageView.heightAnchor.constraint(equalToConstant: newHeight).isActive = true

                    self.detailView.detailImageStackView.addArrangedSubview(detailImageView)
                }
            }
        }
    }
}
