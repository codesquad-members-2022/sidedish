import Foundation

extension String {
    func toInt() -> Int {
        let price = self
            .replacingOccurrences(of: ",", with: "")
            .replacingOccurrences(of: "원", with: "")

        return Int(price) ?? 0
    }

    func toPrice() -> String {
        var price = String(self.reversed())
        var splittedPrice = [String]()
        let offset = 3

        while price.count > offset {
            let startPoint = price.startIndex
            let endPoint = price.index(startPoint, offsetBy: offset)

            splittedPrice.append(String(price[startPoint..<endPoint].reversed()))
            price.removeSubrange(startPoint..<endPoint)

            if price.count <= offset {
                splittedPrice.append(String(price.reversed()))
            }
        }

        return splittedPrice.reversed().joined(separator: ",") + "원"
    }
}
