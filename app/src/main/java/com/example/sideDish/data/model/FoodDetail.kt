package com.example.sideDish.data.model

data class FoodDetail(
    val deliveryFee: String,
    val deliveryInfo: String,
    val detailImageUrls: List<String>,
    val point: String,
    val originalPrice: String,
    val discountedPrice: String,
    val productDescription: String,
    val thumbImageUrls: List<String>,
    val topImageUrl: String
)

//fun FoodDetail.convertDto(detailDto: DetailDto): FoodDetail {
//    return FoodDetail(
//        detailDto.detail.deliveryFee,
//        detailDto.detail.deliveryInfo,
//        detailDto.detail.detailSection,
//        detailDto.detail.point,
//        detailDto.detail.prices[0],
//        detailDto.detail.prices[1],
//        detailDto.detail.productDescription,
//        detailDto.detail.thumbImages,
//        detailDto.detail.topImage,
//    )
//}
