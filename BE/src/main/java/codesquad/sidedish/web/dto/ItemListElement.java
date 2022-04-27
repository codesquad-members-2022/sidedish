package codesquad.sidedish.web.dto;

import codesquad.sidedish.domain.item.Item;
import lombok.Getter;

@Getter
public class ItemListElement {
    private Long itemId;
    private String name;
    private String description;
    private int originalPrice;
    private int discountedPrice;
    private String discountPolicy;
    private String mainImage;

    public ItemListElement (Item item) {
        this.itemId = item.getItemId();
        this.name = item.getName();
        this.description = item.getDescription();
        this.originalPrice = item.getPrice();
        this.discountedPrice = item.getDiscountedItemPrice();
        this.discountPolicy = item.getDiscountPolicy().getName();
        this.mainImage = initMainImageUrl(item);
    }

    private String initMainImageUrl(Item item) {
        return item.getMainImageUrls()
                .stream()
                .findFirst()
                .orElse(null);
    }
}
