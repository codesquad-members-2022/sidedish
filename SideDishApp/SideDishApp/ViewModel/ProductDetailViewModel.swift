//
//  ProductDetailViewModel.swift
//  SideDishApp
//
//  Created by Bumgeun Song on 2022/04/26.
//

import Foundation

struct ProductDetailViewModel {
    public let thumbImagesURL = Observable<[URL]>([])
    public let deliveryInfo = Observable<String>("")
    public let deliveryFee = Observable<String>("")
    public let point = Observable<Money<KRW>>(Money<KRW>(""))
    public let detailSectionURL = Observable<[URL]>([])

    let hash: String

    init(from hash: String) {
        self.hash = hash
    }

    func fetchDetail() {
        guard let productRequest = ProductDetailRequest(from: hash) else { return }

        productRequest.execute { productDetailResponse in
            guard let productDetail = productDetailResponse?.data else { return }

            thumbImagesURL.value = productDetail.thumbImagesURL
            deliveryFee.value = productDetail.deliveryFee
            deliveryInfo.value = productDetail.deliveryInfo
            point.value = productDetail.point
            detailSectionURL.value = productDetail.detailSectionURL
        }
    }
}
