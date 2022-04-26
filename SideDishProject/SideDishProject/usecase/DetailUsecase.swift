import Foundation

final class DetailUsecase {
    private let repository: ProductDetailRepository
    
    init(repository: ProductDetailRepository, uniqueId: UniqueID){
        self.repository = repository
        self.loadData(id: uniqueId)
    }
    
    private func loadData(id: UniqueID) {
        repository.fetchOne(id: id) { result in
            // TODO: delegate 호출
        }
    }
}
