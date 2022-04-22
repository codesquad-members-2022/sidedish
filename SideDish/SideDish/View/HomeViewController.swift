import UIKit

class HomeViewController: UIViewController {

    @IBOutlet weak var collectionView: UICollectionView!
    override func viewDidLoad() {
        super.viewDidLoad()
        setUnderbarAtNavigationBar()
        registerDishCell()
        collectionViewDelegate()

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
        return 3
    }

    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath)
    -> UICollectionViewCell {
        guard let cell = collectionView
                .dequeueReusableCell(withReuseIdentifier: DishCell.identifier, for: indexPath) as? DishCell else {
                    return UICollectionViewCell()
                }
        return cell
    }
    func numberOfSections(in collectionView: UICollectionView) -> Int {
        return 3
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
            headerView.setup()
            return headerView
        default:
            assert(false, "invalid element Type")
        }
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
