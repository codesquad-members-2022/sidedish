package kr.codesquad.sidedish.web.dto.item;

import kr.codesquad.sidedish.domain.Item;
import lombok.Getter;

@Getter
public class ItemListResponseDto {

    private Long itemId;
    private String itemName;
    private String description;
    private Long originalPrice;
    private Long discountPrice;
    private Integer labelId;
    private String mainImage;
    private Integer deliveryId;
    private Long bestId;

    public ItemListResponseDto(Long itemId, String itemName, String description, Long originalPrice, Long discountPrice, Integer labelId, String mainImage, Integer deliveryId, Long bestId) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.description = description;
        this.originalPrice = originalPrice;
        this.discountPrice = discountPrice;
        this.labelId = labelId;
        this.mainImage = mainImage;
        this.deliveryId = deliveryId;
        this.bestId = bestId;
    }

    public static ItemListResponseDto of(Item item) {
        return new ItemListResponseDto(item.getItemId(), item.getItemName(), item.getDescription(),
                item.getOriginalPrice(), item.getDiscountPrice(), item.getLabelId(), item.getMainImage(),
                item.getDeliveryId(), item.getBestId());
    }

}
