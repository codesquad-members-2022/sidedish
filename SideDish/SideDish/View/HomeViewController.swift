import UIKit

class HomeViewController: UIViewController {

    @IBOutlet weak var collectionView: UICollectionView!
    private var model = [[Product]]()

    override func viewDidLoad() {
        super.viewDidLoad()
        setUnderbarAtNavigationBar()
        registerDishCell()
        collectionViewDelegate()

//        self.model = factory.convertCell2Product()

    }

    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(animated)
        let repository = DishCellRepository()
        let factory = CellFactory(repository: repository)
        factory.onUpdate = {
            DispatchQueue.main.async {
                let product = factory.convertCell2Product()
                self.model = product
                self.collectionView.reloadData()
            }
        }
        factory.fetchData()
    }

    private func collectionViewDelegate() {
        self.collectionView.dataSource = self
        self.collectionView.delegate = self
    }
    private func registerDishCell() {
        let nib = UINib(nibName: DishCell.identifier, bundle: nil)
        self.collectionView.register(nib, forCellWithReuseIdentifier: DishCell.identifier)
    }
}

extension HomeViewController: UICollectionViewDataSource, UICollectionViewDelegate {
    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        print("number of section: \(model.isEmpty)")
        return model[section].count
    }

    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath)
    -> UICollectionViewCell {
        guard let cell = collectionView
                .dequeueReusableCell(withReuseIdentifier: DishCell.identifier, for: indexPath) as? DishCell else {
                    return UICollectionViewCell()
                }
        // TODO: - 팩토리 메서드 패턴으로, 셀.configure
        cell.configure(with: model[indexPath.section][indexPath.item])
        print("Cell for item: \(model.isEmpty)")
        return cell
    }
    func numberOfSections(in collectionView: UICollectionView) -> Int {
        return model.count
    }
    // MARK: - Section Header 선언
    func collectionView(_ collectionView: UICollectionView,
                        viewForSupplementaryElementOfKind kind: String, at indexPath: IndexPath)
    -> UICollectionReusableView {
        switch kind {
        case UICollectionView.elementKindSectionHeader:
            guard let headerView = collectionView
                .dequeueReusableSupplementaryView(
                    ofKind: kind, withReuseIdentifier: SectionHeader.cellId, for: indexPath) as? SectionHeader else {
                        return UICollectionReusableView()
                    }

            headerView.setup(at: indexPath.section)
            return headerView
        default:
            assert(false, "invalid element Type")
        }
    }
    // MARK: - Cell 이 클릭되게 만듦
    func collectionView(_ collectionView: UICollectionView, didSelectItemAt indexPath: IndexPath) {

        let detailHash = model[indexPath.section][indexPath.item].hash
        let dishDetailViewModel = DishDetailViewModel(detailHash: detailHash, repository: DishDetailRepository())
        let nextViewController = DetailViewController(viewModel: dishDetailViewModel)
        navigationController?.pushViewController(nextViewController, animated: true)
    }
}

extension HomeViewController: UICollectionViewDelegateFlowLayout {
    // MARK: - Section Header 크기
    func collectionView(_ collectionView: UICollectionView,
                        layout collectionViewLayout: UICollectionViewLayout,
                        referenceSizeForHeaderInSection section: Int) -> CGSize {
        let width: CGFloat = collectionView.frame.width
        let upperSpacing: CGFloat = 15
        let lowerSpacing: CGFloat = 15
        let height: CGFloat = SectionHeader.labelHeight + upperSpacing + lowerSpacing
        return CGSize(width: width, height: height)
    }
    // MARK: - Collection View 를 Table View 처럼 사용하도록 설정
    func collectionView(_ collectionView: UICollectionView,
                        layout collectionViewLayout: UICollectionViewLayout,
                        sizeForItemAt indexPath: IndexPath) -> CGSize {

        guard let flowLayout = collectionViewLayout as? UICollectionViewFlowLayout else {
            return CGSize(width: 100, height: 100)
        }
        // MARK: - SectionInset 및 셀 크기 조정
        flowLayout.sectionInset = UIEdgeInsets(top: 24, left: 16, bottom: 24, right: 16)
        flowLayout.minimumLineSpacing = 8
        let width = collectionView.bounds.width
        let widthPadding = flowLayout.sectionInset.left + flowLayout.sectionInset.right
        let cellWidth = (width - widthPadding)
        return CGSize(width: cellWidth, height: 130)
    }
}

extension HomeViewController {
    private func setUnderbarAtNavigationBar() {
        let navigationBar = navigationController?.navigationBar
        let navigationBarAppearance = UINavigationBarAppearance()
        navigationBarAppearance.shadowColor = .systemGray3
        navigationBar?.scrollEdgeAppearance = navigationBarAppearance
    }
}
