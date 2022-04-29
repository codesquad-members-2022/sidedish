package kr.codesquad.sidedish.domain;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.List;

@Getter
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

    public void changeStock(Integer quantity) {
        this.stock = this.getStock() - quantity;
    }

    public boolean checkStock(int quantity) {
        return this.stock < quantity;
    }
}
