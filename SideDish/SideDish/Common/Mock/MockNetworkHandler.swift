import Foundation

final class MockNetworkHandler: NetworkHandlable{
    
    var sampleJSONData: Data {
        Data(
                """
                {
                  "statusCode": 200,
                  "body": [
                    {
                      "detail_hash": "HBDEF",
                      "image": "https://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg",
                      "alt": "오리 주물럭_반조리",
                      "delivery_type": ["새벽배송", "전국택배"],
                      "title": "오리 주물럭_반조리",
                      "description": "감칠맛 나는 매콤한 양념",
                      "n_price": "15,800원",
                      "s_price": "12,640원",
                      "badge": ["런칭특가"]
                    }
                  ]
                }
                """.utf8
        )
    }
    
    var delegate: NetworkHandlerDelegate?
    var isResponseFailed: Bool = false
    private (set) var responseData: Data?
    
    func request(url: EndPoint, method: HttpMethod, contentType: ContentType, completionHandler: @escaping (Result<Data,Error>) -> Void) {
        
        if !isResponseFailed{
            switch contentType {
            case .json:
                completionHandler(.success(sampleJSONData))
            case .image:
                let mockImageData = Data()
                completionHandler(.success(mockImageData))
                delegate?.cachingDataRequested(url: url, data: mockImageData)
            }
        }else{
            completionHandler(.failure(HttpError.unknownError))
        }
    }
    
}
