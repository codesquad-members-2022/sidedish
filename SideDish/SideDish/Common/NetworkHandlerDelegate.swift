import Foundation

protocol NetworkHandlerDelegate: AnyObject {
    func cachingDataRequested(url: EndPoint, data: Data)
}
