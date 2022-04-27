import UIKit

class MainViewController: UIViewController {
    
    private var ordering: Ordering?
    
    private lazy var foodCollectionView: UICollectionView = {
        let layout = UICollectionViewFlowLayout()
        layout.scrollDirection = .vertical
        layout.itemSize = CGSize(width: view.frame.width * 0.85, height: 150)
        let collectionView = UICollectionView(frame: .zero, collectionViewLayout: layout)
        
        collectionView.register(FoodCollectionViewCell.self, forCellWithReuseIdentifier: "FoodCollectionViewCell")
        
        collectionView.translatesAutoresizingMaskIntoConstraints = false
        return collectionView
    }()
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        let repository = Repository()
        ordering = Ordering(repository: repository)
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        navigationItem.title = "Ordering"
        setFoodCollectionView()
        setLayout()
    }
    
    private func setFoodCollectionView() {
        foodCollectionView.delegate = self
        foodCollectionView.dataSource = self
    }
    
    private func setLayout() {
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
    func numberOfSections(in collectionView: UICollectionView) -> Int {
        return ordering?.categoryCount ?? 0
    }
    
    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        guard let ordering = ordering else { return 0 }
        let category = ordering.getCategoryWithIndex(index: section)
        return ordering.getFoodCountInCertainCategory(category: category)
    }
    
    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        guard let ordering = ordering,
              let cell = foodCollectionView .dequeueReusableCell(withReuseIdentifier: "FoodCollectionViewCell", for: indexPath) as? FoodCollectionViewCell else { return UICollectionViewCell() }
        let category = ordering.getCategoryWithIndex(index: indexPath.section)
        let index = indexPath.row
        if let food = ordering[index, category] {
            cell.receiveFood(food: food)
            ordering.requesetFoodImage(imageUrl: food.imageUrl) { data in
                cell.updateFoodImage(imageData: data)
            }
        }
        return cell
    }
}
