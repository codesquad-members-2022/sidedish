import UIKit

class HomeViewController: UIViewController {

    @IBOutlet weak var collectionView: UICollectionView!
    override func viewDidLoad() {
        super.viewDidLoad()
        self.collectionView.dataSource = self
        self.collectionView.delegate = self
        setUnderbarAtNavigationBar()
        let nib = UINib(nibName: "DishCell", bundle: nil)
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

    func collectionView(_ collectionView: UICollectionView,
                        viewForSupplementaryElementOfKind kind: String, at indexPath: IndexPath)
                        -> UICollectionReusableView {
        switch kind {
        case UICollectionView.elementKindSectionHeader:
            let headerView = collectionView
                .dequeueReusableSupplementaryView(
                    ofKind: kind, withReuseIdentifier: SectionHeader.cellId, for: indexPath) as? SectionHeader
            headerView?.setup()
            return headerView!
        default:
            assert(false, "invalid element Type")
        }
    }
}

// MARK: - 행 당 셀의 개수, 셀의 크기
extension HomeViewController: UICollectionViewDelegateFlowLayout {
    func collectionView(_ collectionView: UICollectionView,
                        layout collectionViewLayout: UICollectionViewLayout,
                        sizeForItemAt indexPath: IndexPath) -> CGSize {
        let numberOfCellPerRow = 1
        guard let flowLayout = collectionViewLayout as? UICollectionViewFlowLayout else {
            return CGSize(width: 100, height: 100)
        }
        // MARK: - Cell 사이 간격 (상하좌우)
        flowLayout.sectionInset.left = 16
        flowLayout.sectionInset.right = 16
        flowLayout.sectionInset.bottom = 8
        
        let totalSpace = flowLayout.sectionInset.left
                        + flowLayout.sectionInset.right
                        + (flowLayout.minimumInteritemSpacing * CGFloat(numberOfCellPerRow - 1))
        let size = Int((collectionView.frame.width - totalSpace)
                       / CGFloat(numberOfCellPerRow))
//        let size = Int((collectionView.frame.width)
//                       / CGFloat(numberOfCellPerRow))
        // TODO: - Cell 높이와 맞춰야함
        let height: Int = 130
        return CGSize(width: size, height: height)

    }
    // MARK: - Section Header 크기
    func collectionView(_ collectionView: UICollectionView,
                        layout collectionViewLayout: UICollectionViewLayout,
                        referenceSizeForHeaderInSection section: Int) -> CGSize {
        let width: CGFloat = collectionView.frame.width
        let height: CGFloat = 126
        return CGSize(width: width, height: height)
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
