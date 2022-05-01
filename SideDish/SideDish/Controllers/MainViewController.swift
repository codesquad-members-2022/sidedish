import UIKit
import OSLog

class MainViewController: UIViewController {
    
    private var ordering: Ordering?
    private let logger = Logger()
    
    private lazy var foodCollectionView: UICollectionView = {
        let layout = UICollectionViewFlowLayout()
        layout.headerReferenceSize = CGSize(width: .zero, height: 100)
        layout.scrollDirection = .vertical
        layout.itemSize = CGSize(width: view.frame.width * 0.85, height: 150)
        let collectionView = UICollectionView(frame: .zero, collectionViewLayout: layout)
        
        collectionView.register(
            FoodCollectionViewCell.self,
            forCellWithReuseIdentifier: FoodCollectionViewCell.identifier
        )
        
        collectionView.register(
            HeaderCollectionReusableView.self,
            forSupplementaryViewOfKind: UICollectionView.elementKindSectionHeader,
            withReuseIdentifier: HeaderCollectionReusableView.identifier
        )
        
        collectionView.translatesAutoresizingMaskIntoConstraints = false
        return collectionView
    }()
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        ordering = Ordering(repository: Repository())
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        navigationItem.title = "Ordering"
        setFoodCollectionView()
        setLayout()
        addObservers()
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
    
    private func addObservers() {
        NotificationCenter.default.addObserver(self, selector: #selector(moveToDetailView(_:)), name: NotificationName.foodSelected, object: ordering)
        NotificationCenter.default.addObserver(self, selector: #selector(handleRequestFailure(_:)), name: NotificationName.dataRequestFailed, object: ordering)
    }
    
    @objc func moveToDetailView(_ notification: Notification) {
        guard let ordering = ordering,
              let foodTitle = notification.userInfo?[UserInfoKey.foodTitleResponse] as? String else { return }
        let detailViewController = DetailViewController(foodTitle: foodTitle, ordering: ordering)
        navigationController?.pushViewController(detailViewController, animated: true)
    }
    
    @objc func handleRequestFailure(_ notification: Notification) {
        guard let errorMessage = notification.userInfo?[UserInfoKey.dataRequestFailureMessage] as? String else { return }
        presentAlert(title: "데이터 요청 실패", message: errorMessage)
    }
    
    private func presentAlert(title: String, message: String) {
        let alert = UIAlertController(title: title, message: message, preferredStyle: .alert)
        let defaultAction =  UIAlertAction(title: "확인", style: UIAlertAction.Style.default)
        alert.addAction(defaultAction)
        DispatchQueue.main.async { [weak self] in
            self?.present(alert, animated: true, completion: nil)
        }
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
        guard let food = ordering[index,category] else { return cell }
        
        cell.receiveFood(food: food)
        ordering.requesetFoodImage(imageUrl: food.imageUrl){ result in
            switch result{
            case.success(let imageData):
                cell.updateFoodImage(imageData: imageData)
            case .failure(let error):
                self.logger.error("\(error.localizedDescription)")
            }
        }
        
        return cell
    }
    
    func collectionView(_ collectionView: UICollectionView, didSelectItemAt indexPath: IndexPath) {
        guard let ordering = ordering else { return }
        let category = ordering.getCategoryWithIndex(index: indexPath.section)
        guard let food = ordering[indexPath.row,category] else { return }
        
        ordering.selectFood(foodHash: food.detailHash, category: category)
    }
    
    func collectionView(_ collectionView: UICollectionView, viewForSupplementaryElementOfKind kind: String, at indexPath: IndexPath) -> UICollectionReusableView {
        let reusableView = collectionView.dequeueReusableSupplementaryView(ofKind: kind, withReuseIdentifier: HeaderCollectionReusableView.identifier, for: indexPath)
        guard let headerValue = reusableView as? HeaderCollectionReusableView else { return reusableView}
        guard let ordering = ordering else { return headerValue }
        
        let category = ordering.getCategoryWithIndex(index: indexPath.section)
        headerValue.inputHeader(category: category.headerText)
        
        return headerValue
    }

}
