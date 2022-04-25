import Foundation

extension String {
    func toInt() -> Int {
        let price = self
            .replacingOccurrences(of: ",", with: "")
            .replacingOccurrences(of: "원", with: "")

        return Int(price) ?? 0
    }

    func toPrice() -> String {
        var price = self
        var splittedPrice = [String]()
        let offset = 3

        while price.count > offset {
            let startPoint = price.startIndex
            let endPoint = price.index(startPoint, offsetBy: offset)

            splittedPrice.append(String(price[startPoint..<endPoint]))
            price.removeSubrange(startPoint..<endPoint)

            if price.count <= offset {
                splittedPrice.append(price)
            }
        }

        return splittedPrice.joined(separator: ",")
    }
}
