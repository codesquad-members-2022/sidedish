import UIKit

class BriefBanchanViewController: UIViewController {

    @IBOutlet weak var briefBanchanList: UICollectionView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        briefBanchanList.delegate = self
        briefBanchanList.dataSource = self
        
        self.briefBanchanList!.register(BriefBanchanViewCell.self, forCellWithReuseIdentifier: BriefBanchanViewCell.cellId)
    }
    
}

extension BriefBanchanViewController: UICollectionViewDelegate, UICollectionViewDataSource, UICollectionViewDelegateFlowLayout {
    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        return 1
    }
    
    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, sizeForItemAt indexPath: IndexPath) -> CGSize {
        let cellWidth = collectionView.frame.width
        return CGSize(width: cellWidth, height: cellWidth/3)
    }
    
    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        guard let cell = collectionView.dequeueReusableCell(withReuseIdentifier: BriefBanchanViewCell.cellId, for: indexPath) as? BriefBanchanViewCell else {
            return UICollectionViewCell()
        }
        cell.backgroundColor = .red
        return cell
    }
    
}
