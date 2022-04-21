import UIKit

class MainViewController: UIViewController {
    
    private let ordering = Ordering()
    
    private lazy var foodCollectionView: UICollectionView = {
       let layout = UICollectionViewFlowLayout()
        layout.scrollDirection = .vertical // 수직으로 표현된다.
        layout.itemSize = CGSize(width: view.frame.width * 0.85, height: 150)
        let collectionView = UICollectionView(frame: .zero, collectionViewLayout: layout)
        
        collectionView.register(FoodCollectionViewCell.self, forCellWithReuseIdentifier: "FoodCollectionViewCell")
        
        collectionView.translatesAutoresizingMaskIntoConstraints = false
            return collectionView
    }()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        navigationItem.title = "Ordering"
        foodCollectionView.delegate = self
        foodCollectionView.dataSource = self
        view.addSubview(foodCollectionView)
        NSLayoutConstraint.activate([
            foodCollectionView.topAnchor.constraint(equalTo: view.safeAreaLayoutGuide.topAnchor),
            foodCollectionView.leadingAnchor.constraint(equalTo: view.safeAreaLayoutGuide.leadingAnchor),
            foodCollectionView.trailingAnchor.constraint(equalTo: view.safeAreaLayoutGuide.trailingAnchor),
            foodCollectionView.bottomAnchor.constraint(equalTo: view.safeAreaLayoutGuide.bottomAnchor)
        ])
    }
}

extension MainViewController: UICollectionViewDelegate, UICollectionViewDataSource{
    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        return 50000
    }
    
    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        guard let cell = foodCollectionView .dequeueReusableCell(withReuseIdentifier: "FoodCollectionViewCell", for: indexPath) as? FoodCollectionViewCell else { return UICollectionViewCell() }
        return cell
    }
    
}
