import UIKit

class MainViewController: UIViewController {
    
    private let ordering = Ordering()
    private lazy var foodCollectionView: UICollectionView = {
       let layout = UICollectionViewFlowLayout()
        layout.scrollDirection = .vertical // 수직으로 표현된다.

        let collectionView = UICollectionView(frame: .zero, collectionViewLayout: layout)
        return collectionView
    }()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        navigationItem.title = "Ordering"
        
    }
}

