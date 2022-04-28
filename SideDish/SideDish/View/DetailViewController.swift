import UIKit

class DetailViewController: UIViewController {

    private let detailDishSectionView = DetailDishSectionView()
    private let deliverySectionView = DeliverySectionView()
    private let amountSectionView = AmountSectionView()
    private var viewModel: DishDetailViewModel?

    private let mainScrollView: UIScrollView = {
        var scrollView = UIScrollView()
        scrollView.translatesAutoresizingMaskIntoConstraints = false
        scrollView.showsVerticalScrollIndicator = false
        return scrollView
    }()

    private let contentView: UIView = {
        var view = UIView()
        view.translatesAutoresizingMaskIntoConstraints = false
        return view
    }()

    private let detailImageStackView: UIStackView = {
        var stackView = UIStackView()
        stackView.axis = .vertical
        stackView.distribution = .fill
        stackView.alignment = .fill
        stackView.translatesAutoresizingMaskIntoConstraints = false
        return stackView
    }()

    init(viewModel: DishDetailViewModel) {
        self.viewModel = viewModel
        super.init(nibName: nil, bundle: nil)

        setViewModel()
    }

    required init?(coder: NSCoder) {
        self.viewModel = nil
        super.init(coder: coder)
    }

    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(animated)

        viewModel?.fetchDetailData()
    }

    override func viewDidLoad() {
        super.viewDidLoad()
        setNavigationItems()
        view.backgroundColor = .white

        setMainScrollViewLayout()
        setDetailDishSectionViewLayout()
        setDeliverySectionViewLayout()
        setAmountSectionViewLayout()
        setDetailImageStackViewLayout()
    }

    private func setNavigationItems() {
        navigationController?.navigationBar.topItem?.backButtonTitle = "뒤로"
        navigationController?.navigationBar.titleTextAttributes =
        [NSAttributedString.Key.font: UIFont(name: Font.sfSemiBold, size: 17) ?? UIFont.systemFont(ofSize: 17)]
    }

    private func setViewModel() {
        setOnUpdate()
        setOnUpdateWithTopImages()
        setOnUpdateWithDetailImages()
    }

    private func setOnUpdate() {
        viewModel?.onUpdate = {
            DispatchQueue.main.async {[weak self] in
                self?.navigationItem.title = self?.viewModel?.title
                self?.detailDishSectionView.setComponents(with: self?.viewModel)
                self?.deliverySectionView.setComponents(with: self?.viewModel)
            }
        }
    }

    private func setOnUpdateWithTopImages() {
        viewModel?.onUpdateWithTopImages = {
            DispatchQueue.main.async {[weak self] in
                self?.viewModel?.topImages.forEach { image in
                    self?.detailDishSectionView.addTopImage(with: image)
                }
            }
        }
    }

    private func setOnUpdateWithDetailImages() {
        viewModel?.onUpdateWithDetailImages = {
            DispatchQueue.main.async {[weak self] in
                self?.viewModel?.detailImages.forEach { image in
                    let ratio = image.size.height / image.size.width
                    let detailImageView = UIImageView(image: image)
                    let newWidth = self?.detailImageStackView.frame.width ?? 0
                    let newHeight = newWidth * ratio

                    detailImageView.contentMode = .scaleAspectFit
                    detailImageView.translatesAutoresizingMaskIntoConstraints = false
                    detailImageView.heightAnchor.constraint(equalToConstant: newHeight).isActive = true

                    self?.detailImageStackView.addArrangedSubview(detailImageView)
                }
            }
        }
    }
}

// MARK: - subView들의 layout설정
extension DetailViewController {
    private func setMainScrollViewLayout() {
        let safeArea = view.safeAreaLayoutGuide
        view.addSubview(mainScrollView)

        NSLayoutConstraint.activate([
            mainScrollView.leadingAnchor.constraint(equalTo: view.leadingAnchor),
            mainScrollView.topAnchor.constraint(equalTo: safeArea.topAnchor),
            mainScrollView.trailingAnchor.constraint(equalTo: view.trailingAnchor),
            mainScrollView.bottomAnchor.constraint(equalTo: view.bottomAnchor),
            mainScrollView.contentLayoutGuide.topAnchor.constraint(equalTo: mainScrollView.topAnchor),
            mainScrollView.contentLayoutGuide.leadingAnchor.constraint(equalTo: mainScrollView.leadingAnchor),
            mainScrollView.contentLayoutGuide.widthAnchor.constraint(equalTo: mainScrollView.widthAnchor)
        ])
        mainScrollView.addSubview(contentView)

        NSLayoutConstraint.activate([
            contentView.centerXAnchor.constraint(equalTo: view.centerXAnchor),
            contentView.topAnchor.constraint(equalTo: mainScrollView.topAnchor),
            contentView.bottomAnchor.constraint(equalTo: mainScrollView.bottomAnchor),
            contentView.widthAnchor.constraint(equalTo: mainScrollView.widthAnchor)
        ])
    }

    private func setDetailDishSectionViewLayout() {
        detailDishSectionView.setLayout()
        contentView.addSubview(detailDishSectionView)

        NSLayoutConstraint.activate([
            detailDishSectionView.leadingAnchor.constraint(equalTo: contentView.leadingAnchor),
            detailDishSectionView.topAnchor.constraint(equalTo: contentView.topAnchor),
            detailDishSectionView.trailingAnchor.constraint(equalTo: contentView.trailingAnchor),
            detailDishSectionView.widthAnchor.constraint(equalTo: contentView.widthAnchor)
        ])
    }

    private func setDeliverySectionViewLayout() {
        deliverySectionView.setLayout()
        contentView.addSubview(deliverySectionView)

        NSLayoutConstraint.activate([
            deliverySectionView.topAnchor.constraint(equalTo: detailDishSectionView.bottomAnchor),
            deliverySectionView.leadingAnchor.constraint(equalTo: contentView.leadingAnchor),
            deliverySectionView.trailingAnchor.constraint(equalTo: contentView.trailingAnchor)
        ])
    }

    private func setAmountSectionViewLayout() {
        amountSectionView.setLayout()
        contentView.addSubview(amountSectionView)

        NSLayoutConstraint.activate([
            amountSectionView.topAnchor.constraint(equalTo: deliverySectionView.bottomAnchor),
            amountSectionView.leadingAnchor.constraint(equalTo: contentView.leadingAnchor),
            amountSectionView.trailingAnchor.constraint(equalTo: contentView.trailingAnchor),
            mainScrollView.contentLayoutGuide.heightAnchor.constraint(equalTo: contentView.heightAnchor)
        ])
    }

    private func setDetailImageStackViewLayout() {
        contentView.addSubview(detailImageStackView)

        NSLayoutConstraint.activate([
            detailImageStackView.topAnchor.constraint(equalTo: amountSectionView.bottomAnchor, constant: 48),
            detailImageStackView.leadingAnchor.constraint(equalTo: contentView.leadingAnchor, constant: 16),
            detailImageStackView.trailingAnchor.constraint(equalTo: contentView.trailingAnchor, constant: -16),
            detailImageStackView.bottomAnchor.constraint(equalTo: mainScrollView.bottomAnchor),
            contentView.bottomAnchor.constraint(equalTo: detailImageStackView.bottomAnchor)
        ])
    }
}
