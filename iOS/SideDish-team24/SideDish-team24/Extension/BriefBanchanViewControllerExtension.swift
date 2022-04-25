import UIKit

extension BriefBanchanViewController: UICollectionViewDelegate, UICollectionViewDataSource, UICollectionViewDelegateFlowLayout {
    
    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        return tmp[section].count
    }
    
    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, sizeForItemAt indexPath: IndexPath) -> CGSize {
        let cellWidth = collectionView.frame.width
        return CGSize(width: cellWidth, height: cellWidth/3)
    }
    
    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        guard let cell = collectionView.dequeueReusableCell(withReuseIdentifier: BriefBanchanViewCell.cellId, for: indexPath) as? BriefBanchanViewCell else {
            return UICollectionViewCell()
        }
        if let targetDish: Dish = tmp[indexPath.section][indexPath.row] {
            let won = targetDish.price.convertToWon()
            guard let special = targetDish.discountPolicy else { return UICollectionViewCell() }
            
            DispatchQueue.global().async {
                let data = try? Data(contentsOf: targetDish.image)
                DispatchQueue.main.async {
                    let image = UIImage(data: data!)
                    cell.configure(image: image!)
                }
            }
            cell.configure(title: targetDish.name, description: targetDish.description)
            cell.configure(specialBadge: special)
            cell.configure(price: won, listPrice: nil)
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
            headerView.setTitle(to: tmp[indexPath.section].type)
            return headerView
        } else {
            return UICollectionReusableView()
        }
    }
    
    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, insetForSectionAt section: Int) -> UIEdgeInsets {
        return UIEdgeInsets(top: 0, left: 0, bottom: CGFloat.defaultInset*2, right: 0)
    }
    
    func numberOfSections(in collectionView: UICollectionView) -> Int {
        return tmp.count
    }
    
}
