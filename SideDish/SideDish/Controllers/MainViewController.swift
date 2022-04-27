import UIKit
import OSLog

class MainViewController: UIViewController {
    
    private var ordering: Ordering?
    private var logger: Logger?
    
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
        ordering = Ordering(repository: Repository())
        logger = Logger()
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
    
    func moveToDetailView(foodDetail: FoodDetail, foodTitle: String) {
        let detailViewController = DetailViewController(foodDetail: foodDetail, foodTitle: foodTitle)
        navigationController?.pushViewController(detailViewController, animated: true)
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
            ordering.requesetFoodImage(imageUrl: food.imageUrl){ result in
                switch result{
                case.success(let imageData):
                    cell.updateFoodImage(imageData: imageData)
                case .failure(let error):
                    self.logger?.error("\(error.localizedDescription)")
                }
            }
        }
        return cell
    }
    
    func collectionView(_ collectionView: UICollectionView, didSelectItemAt indexPath: IndexPath) {
        guard let ordering = ordering else { return }
        let category = ordering.getCategoryWithIndex(index: indexPath.section)
        guard let food = ordering[indexPath.row,category] else { return }
        
        ordering.requestFoodDetail(detailHash: food.detailHash){ result in
            switch result {
            case .success(let response):
                self.moveToDetailView(foodDetail: response.data, foodTitle: food.title)
            case .failure(let error):
                self.logger?.error("\(error.localizedDescription)")
            }
        }
    }
}
