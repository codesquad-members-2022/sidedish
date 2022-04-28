import Foundation

final class DetailUsecase {
    private let repository: ProductDetailRepository
    
    init(repository: ProductDetailRepository, uniqueId: Int){
        self.repository = repository
        self.loadData(id: uniqueId)
    }
    
    private func loadData(id: Int) {
        repository.fetchOne(id: id) { result in
            // TODO: delegate 호출
        }
    }
}
