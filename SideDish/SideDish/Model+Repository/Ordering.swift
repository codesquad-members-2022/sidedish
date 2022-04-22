    private var repository: RepositoryApplicable = Repository()
    init(){
        for category in Category.allCases {
            foodMap[category] = [String:Food]()
        }
        repository.delegate = self
        getSampleFoodList()
    }
    
    private func getSampleFoodList(){
        for category in Category.allCases{
            repository.fetchBackgroundData(category: category, dataType: Food.self)
        }
    }
extension Ordering: RepositoryDelegate{
    func fetchBackgroundData(category: Category, backgroundData: Codable) {
        guard let food = backgroundData as? Food else { return }
        foodMap[category]?[food.detailHash] = food
    }
}


