import Foundation

enum NetworkTarget {
    case loadDishes(productSort: ProductSort)
    case loadDishDetail(hash: String)
}

extension NetworkTarget {
    var scheme: String {
        return "https"
    }

    var host: String {
        return "api.codesquad.kr"
    }

    var path: String {
        switch self {
        case .loadDishes(let productSort):
            return "/onban\(productSort.rawValue)"
        case .loadDishDetail(let hash):
            return "/onban/detail/\(hash)"
        }
    }

    var url: URL? {
        var urlComponent = URLComponents()
        urlComponent.scheme = self.scheme
        urlComponent.host = self.host
        urlComponent.path = self.path

        return urlComponent.url
    }
}
