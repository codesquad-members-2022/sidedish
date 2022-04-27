import Foundation

final class MockNetworkHandler: NetworkHandlable{
    
    var sampleJSONData: Data {
        Data(
                """
                {
                  "hash": "H72C3",
                  "data": {
                    "top_image": "http://public.codesquad.kr/jk/storeapp/data/soup/28_ZIP_P_1003_T.jpg",
                    "thumb_images": [
                      "http://public.codesquad.kr/jk/storeapp/data/soup/28_ZIP_P_1003_T.jpg",
                      "http://public.codesquad.kr/jk/storeapp/data/soup/28_ZIP_P_1003_S.jpg"
                    ],
                    "product_description": "김치찌개에는 역시 돼지고기",
                    "point": "83원",
                    "delivery_info": "서울 경기 새벽 배송 / 전국 택배 배송",
                    "delivery_fee": "2,500원 (40,000원 이상 구매 시 무료)",
                    "prices": ["9,300원", "8,370원"],
                    "detail_section": [
                      "http://public.codesquad.kr/jk/storeapp/data/soup/28_ZIP_P_1003_D1.jpg",
                      "http://public.codesquad.kr/jk/storeapp/data/soup/28_ZIP_P_1003_D2.jpg",
                      "http://public.codesquad.kr/jk/storeapp/data/soup/28_ZIP_P_1003_D3.jpg",
                      "http://public.codesquad.kr/jk/storeapp/data/pakage_regular.jpg"
                    ]
                  }
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
                delegate?.cachingDataRequested(url: url, data: sampleJSONData)
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
