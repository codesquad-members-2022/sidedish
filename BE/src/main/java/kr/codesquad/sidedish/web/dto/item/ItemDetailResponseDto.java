package kr.codesquad.sidedish.web.dto.item;

import kr.codesquad.sidedish.domain.Image;
import kr.codesquad.sidedish.domain.Item;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.List;
import java.util.stream.Collectors;

public class ItemDetailResponseDto {

    private Long itemId;
    private String itemName;
    private Long originalPrice;
    private Long discountPrice;
    private Integer labelId;
    private String mainImage;
    private Integer deliveryId;
    private Integer stock;
    private List<String> images;

    public ItemDetailResponseDto(Long itemId, String itemName, Long originalPrice, Long discountPrice, Integer labelId, String mainImage, Integer deliveryId, Integer stock, List<String> images) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.originalPrice = originalPrice;
        this.discountPrice = discountPrice;
        this.labelId = labelId;
        this.mainImage = mainImage;
        this.deliveryId = deliveryId;
        this.stock = stock;
        this.images = images;
    }

    public static ItemDetailResponseDto of(Item item) {
        return new ItemDetailResponseDto(item.getItemId(), item.getItemName(), item.getOriginalPrice(),
                item.getDiscountPrice(), item.getLabelId(), item.getMainImage(), item.getDeliveryId(), item.getStock(),
                item.getImages().stream().map(Image::getDetailImages).collect(Collectors.toList()));
    }

    public Long getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public Long getOriginalPrice() {
        return originalPrice;
    }

    public Long getDiscountPrice() {
        return discountPrice;
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

    public Integer getStock() {
        return stock;
    }

    public List<String> getImages() {
        return images;
    }
}
