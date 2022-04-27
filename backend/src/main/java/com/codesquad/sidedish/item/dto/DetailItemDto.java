package com.codesquad.sidedish.item.dto;

import java.util.Set;

import com.codesquad.sidedish.item.domain.ItemImage;
import io.swagger.v3.oas.annotations.media.Schema;

public class DetailItemDto {
    @Schema(description = "Item 번호", example = "1")
    private Integer id;
    @Schema(description = "할인 정책 이름", example = "런칭특가")
    private String discountPolicy;
    @Schema(description = "할인율", example = "20")
    private Integer discountRate;
    @Schema(description = "상품 설명", example = "감칠맛 나는 매콤한 양념")
    private String description;
    @Schema(description = "상품 이름", example = "오리 주물럭_반조리")
    private String name;
    @Schema(description = "상품 가격(원가)", example = "15800")
    private Integer price;
    @Schema(description = "적립금", example = "158")
    private Integer point;
    @Schema(description = "메인 이미지 링크", example = "https://leejohy-springboot-build.s3.ap-northeast-2.amazonaws.com/2cdf7235b65a114abff05b9133f90085.jpeg")
    private String mainImageLink;
    private Set<ItemImage> detailImageLink;

    public DetailItemDto(Integer id, String discountPolicy, Integer discountRate, String description, String name, Integer price, Integer point, String mainImageLink, Set<ItemImage> detailImageLink) {
        this.id = id;
        this.discountPolicy = discountPolicy;
        this.discountRate = discountRate;
        this.description = description;
        this.name = name;
        this.price = price;
        this.point = point;
        this.mainImageLink = mainImageLink;
        this.detailImageLink = detailImageLink;
    }

    public Integer getId() {
        return id;
    }

    public String getDiscountPolicy() {
        return discountPolicy;
    }

    public Integer getDiscountRate() {
        return discountRate;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getPoint() {
        return point;
    }

    public String getMainImageLink() {
        return mainImageLink;
    }

    public Set<ItemImage> getDetailImageLink() {
        return detailImageLink;
    }
}
