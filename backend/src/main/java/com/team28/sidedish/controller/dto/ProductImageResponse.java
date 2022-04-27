package com.team28.sidedish.controller.dto;

import com.team28.sidedish.repository.entity.ProductImageEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Schema(description = "상품 이미지")
@Getter
@AllArgsConstructor
public class ProductImageResponse {

    @Schema(description = "이미지 id")
    private Long imageId;

    @Schema(description = "이미지 URL")
    private String imageURL;

    @Schema(description = "대표 이미지 여부")
    private boolean representYn;

    @Schema(description = "순서")
    private int sequence;

    public static ProductImageResponse from(ProductImageEntity productImageEntity) {
        return new ProductImageResponse(
                productImageEntity.getId(),
                productImageEntity.getImagePath(),
                productImageEntity.isRepresentYn(),
                productImageEntity.getSequence()
        );
    }
}
