import UIKit

class BriefBanchanViewController: UIViewController, UIGestureRecognizerDelegate {
    
    @IBOutlet private weak var briefBanchanList: UICollectionView!
    private let mockData = MockData()
    var tmp: [Dishes] = []
    
    override func viewDidLoad() {
        super.viewDidLoad()
        tmp.append(mockData.mainDishes)
        tmp.append(mockData.soupDishes)
        tmp.append(mockData.sideDishes)
        self.registerCollectionView()
    }
}

private extension BriefBanchanViewController {
    func registerCollectionView() {
        briefBanchanList.delegate = self
        briefBanchanList.dataSource = self
        
        let tapGesture = UITapGestureRecognizer(target: self, action: #selector(tapCell(_:)))
        self.briefBanchanList.addGestureRecognizer(tapGesture)
        
        self.briefBanchanList?.register(BriefBanchanViewCell.self, forCellWithReuseIdentifier: BriefBanchanViewCell.cellId)
        self.briefBanchanList?.register(BriefBanchanReusableView.self, forSupplementaryViewOfKind: UICollectionView.elementKindSectionHeader, withReuseIdentifier: BriefBanchanReusableView.identifier)
    }
    
    @objc func tapCell(_ recognizer: UITapGestureRecognizer) {
        if recognizer.state == UIGestureRecognizer.State.ended {
            let tappedLocation = recognizer.location(in: self.briefBanchanList)
            guard let tappedIndexPath = self.briefBanchanList.indexPathForItem(at: tappedLocation) else { return }

            guard let dish = tmp[tappedIndexPath.section][tappedIndexPath.item] else { return }
            let dishViewModel = BanchanViewModel(dish: dish)
            
            guard let detailView = self.storyboard?.instantiateViewController(withIdentifier: "detailBanchanViewController") as? DetailBanchanViewController else { return }
            detailView.title = dishViewModel.title
            detailView.configure(title: dishViewModel.title, description: dishViewModel.description, price: dishViewModel.price, listPrice: dishViewModel.listPrice)
            detailView.configure(specialBadge: dishViewModel.discountPolicy)
            DispatchQueue.global().async {
                let image = dishViewModel.image
                DispatchQueue.main.sync {
                    detailView.configure(image: image)
                }
            }
            self.navigationController?.pushViewController(detailView, animated: true)
        }
    }
}
