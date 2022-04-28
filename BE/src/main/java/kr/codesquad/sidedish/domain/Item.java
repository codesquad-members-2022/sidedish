package kr.codesquad.sidedish.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.List;

public class Item {

    @Id
    private final Long itemId;
    private final Long categoryId;
    private final String itemName;
    private final String description;
    private final Long originalPrice;
    private final Long discountPrice;
    private final Integer labelId;
    private final String mainImage;
    private final Integer deliveryId;
    private final Long bestId;
    private Integer stock;
    @MappedCollection(idColumn = "item_id", keyColumn = "image_id")
    private List<Image> images;

    public Item(Long itemId, Long categoryId, String itemName, String description, Long originalPrice, Long discountPrice, Integer labelId, String mainImage, Integer deliveryId, Long bestId, Integer stock, List<Image> images) {
        this.itemId = itemId;
        this.categoryId = categoryId;
        this.itemName = itemName;
        this.description = description;
        this.originalPrice = originalPrice;
        this.discountPrice = discountPrice;
        this.labelId = labelId;
        this.mainImage = mainImage;
        this.deliveryId = deliveryId;
        this.bestId = bestId;
        this.stock = stock;
        this.images = images;
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

    public Long getOriginalPrice() {
        return originalPrice;
    }

    public Long getDiscountPrice() {
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

    public List<Image> getImages() {
        return images;
    }
}
