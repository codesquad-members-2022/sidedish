package kr.codesquad.sidedish.domain;

import org.springframework.data.annotation.Id;

public class Item {

    @Id
    private final Long itemId;
    private final Long categoryId;
    private final String itemName;
    private final String description;
    private final Integer originalPrice;
    private final Integer discountPrice;
    private Integer stock;
    private final Integer labelId;
    private final String mainImage;
    private final Integer deliveryId;
    private final Long bestId;

    public Item(Long itemId, Long categoryId, String itemName, String description, Integer originalPrice,
                Integer discountPrice, Integer stock, Integer labelId, String mainImage, Integer deliveryId, Long bestId) {
        this.itemId = itemId;
        this.categoryId = categoryId;
        this.itemName = itemName;
        this.description = description;
        this.originalPrice = originalPrice;
        this.discountPrice = discountPrice;
        this.stock = stock;
        this.labelId = labelId;
        this.mainImage = mainImage;
        this.deliveryId = deliveryId;
        this.bestId = bestId;
    }

    public Long getItemId() {
        return itemId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public String getItemName() {
        return itemName;
    }

    public String getDescription() {
        return description;
    }

    public Integer getOriginalPrice() {
        return originalPrice;
    }

    public Integer getDiscountPrice() {
        return discountPrice;
    }

    public Integer getStock() {
        return stock;
    }

    public Integer getLabelId() {
        return labelId;
    }

    public String getMainImage() {
        return mainImage;
    }

    public Integer getDeliveryId() {
        return deliveryId;
    }

    public Long getBestId() {
        return bestId;
    }

}
