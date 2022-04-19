//
//  BanchanListViewController.swift
//  BanchanApp
//
//  Created by 송태환 on 2022/04/18.
//

import UIKit

class BanchanListViewController: UICollectionViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
    }

    private func configureUI() {

    }

    override func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        return 10
    }

    override func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        let cell = collectionView.dequeueReusableCell(withReuseIdentifier: "Cell", for: indexPath)
        return cell
    }
    
    override func collectionView(_ collectionView: UICollectionView, didSelectItemAt indexPath: IndexPath) {
        guard let viewController = UIStoryboard(name: "BanchanDetailViewController", bundle: nil)
            .instantiateInitialViewController() else { return }
        self.navigationController?.pushViewController(viewController, animated: true)
    }
}
