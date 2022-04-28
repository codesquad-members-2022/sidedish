import UIKit

class HomeViewController: UIViewController {

    @IBOutlet weak var collectionView: UICollectionView!
    private var viewModel = DishCellViewModel()

    override func viewDidLoad() {
        super.viewDidLoad()
        setUnderbarAtNavigationBar()
        registerDishCell()
        collectionViewDelegate()
        fetchAndDrawCell()
    }

    private func fetchAndDrawCell() {
        viewModel.onUpdate = {
            DispatchQueue.main.async {
                self.collectionView.reloadData()
            }
        }
        viewModel.fetchData()
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
        guard let model: ProductModel = viewModel.model else { return 0 }
        switch section {
        case 0:
            return model[.main]?.count ?? 0
        case 1:
            return model[.soup]?.count ?? 0
        case 2:
            return model[.side]?.count ?? 0
        default:
            return 0
        }
    }

    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath)
    -> UICollectionViewCell {
        guard let model: ProductModel = viewModel.model else { return UICollectionViewCell() }
        guard let cell = collectionView
                .dequeueReusableCell(withReuseIdentifier: DishCell.identifier, for: indexPath) as? DishCell else {
                    return UICollectionViewCell()
                }
        guard let main = model[.main],
              let soup = model[.soup],
              let side = model[.side] else {
                  return UICollectionViewCell()
              }

        let sectionNumber = indexPath.section
        switch sectionNumber {
        case 0:
            cell.configure(with: main[indexPath.row])
        case 1:
            cell.configure(with: soup[indexPath.row])
        case 2:
            cell.configure(with: side[indexPath.row])
        default:
            return UICollectionViewCell()
        }
        return cell
    }
    func numberOfSections(in collectionView: UICollectionView) -> Int {
        guard let model: ProductModel = viewModel.model else { return 0 }
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
            return UICollectionReusableView()
        }
    }
    // MARK: - Cell 이 클릭되게 만듦
    func collectionView(_ collectionView: UICollectionView, didSelectItemAt indexPath: IndexPath) {
        var targetSort: ProductSort = .main
        guard let model: ProductModel = viewModel.model else { return }
        guard let targetSection = model[targetSort] else { return }
        switch indexPath.section {
        case 0:
            targetSort = .main
        case 1:
            targetSort = .soup
        default:
            targetSort = .side
        }
        let targetDish = targetSection[indexPath.item]
        let dishTitle = targetDish.title
        let detailHash = targetDish.hash
        let dishDetailViewModel = DishDetailViewModel(title: dishTitle,
                                                      detailHash: detailHash,
                                                      repository: DishDetailRepository())
        if let discountType = targetDish.discountType {
            dishDetailViewModel.setDiscountType(discountType)
        }
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
