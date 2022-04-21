import UIKit

class BriefBanchanViewController: UIViewController, UIGestureRecognizerDelegate {
    
    @IBOutlet private weak var briefBanchanList: UICollectionView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        self.registerCollectionView()
    }
    
    private func registerCollectionView() {
        briefBanchanList.delegate = self
        briefBanchanList.dataSource = self
        
        let tapGesture = UITapGestureRecognizer(target: self, action: #selector(tapCell(_:)))
        self.briefBanchanList.addGestureRecognizer(tapGesture)
        
        self.briefBanchanList?.register(BriefBanchanViewCell.self, forCellWithReuseIdentifier: BriefBanchanViewCell.cellId)
        self.briefBanchanList?.register(BriefBanchanReusableView.self, forSupplementaryViewOfKind: UICollectionView.elementKindSectionHeader, withReuseIdentifier: BriefBanchanReusableView.identifier)
    }
    
    @objc private func tapCell(_ recognizer: UITapGestureRecognizer) {
        if recognizer.state == UIGestureRecognizer.State.ended {
            let tappedLocation = recognizer.location(in: self.briefBanchanList)
            guard let tappedIndexPath = self.briefBanchanList.indexPathForItem(at: tappedLocation) else { return }
            guard let tappedCell = self.briefBanchanList.cellForItem(at: tappedIndexPath) as? BriefBanchanViewCell else { return }
            
            guard let detailView = self.storyboard?.instantiateViewController(withIdentifier: "detailBanchanViewController") as? DetailBanchanViewController else { return }
            self.navigationController?.pushViewController(detailView, animated: true)
        }
    }
}

extension BriefBanchanViewController: UICollectionViewDelegate, UICollectionViewDataSource, UICollectionViewDelegateFlowLayout {
    
    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        return 12
    }
    
    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, sizeForItemAt indexPath: IndexPath) -> CGSize {
        let cellWidth = collectionView.frame.width
        return CGSize(width: cellWidth, height: cellWidth/3)
    }
    
    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        guard let cell = collectionView.dequeueReusableCell(withReuseIdentifier: BriefBanchanViewCell.cellId, for: indexPath) as? BriefBanchanViewCell else {
            return UICollectionViewCell()
        }
        return cell
    }
    
    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, referenceSizeForHeaderInSection section: Int) -> CGSize {
        let width: CGFloat = collectionView.frame.width
        
        let height: CGFloat = 96
        
        return CGSize(width: width, height: height)
    }
    
    func collectionView(_ collectionView: UICollectionView, viewForSupplementaryElementOfKind kind: String, at indexPath: IndexPath) -> UICollectionReusableView {
        if kind == UICollectionView.elementKindSectionHeader {
            guard let headerView = collectionView.dequeueReusableSupplementaryView(ofKind: kind, withReuseIdentifier: BriefBanchanReusableView.identifier, for: indexPath) as? BriefBanchanReusableView else {return UICollectionReusableView()}
            return headerView
        }else {
            return UICollectionReusableView()
        }
    }
    
    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, insetForSectionAt section: Int) -> UIEdgeInsets {
        return UIEdgeInsets(top: 0, left: 0, bottom: CGFloat.defaultInset*2, right: 0)
    }
    
    func numberOfSections(in collectionView: UICollectionView) -> Int {
        return 3
    }

}
