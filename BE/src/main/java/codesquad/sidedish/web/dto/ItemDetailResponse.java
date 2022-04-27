package codesquad.sidedish.web.dto;

import codesquad.sidedish.domain.delivery.Delivery;
import codesquad.sidedish.domain.item.Item;
import codesquad.sidedish.domain.item.ItemImage;
import codesquad.sidedish.domain.item.ItemImageType;
import lombok.Getter;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ItemDetailResponse {

    private String name;
    private String description;
    private int originalPrice;
    private int discountedPrice;
    private String discountPolicy;
    private int mileage;
    private boolean supportDawnDelivery;
    private int deliveryFee = Delivery.DEFAULT_DELIVERY_FEE;
    private int deliveryFeeFreeMinPay = Delivery.MINIMUM_PRICE_FOR_FREE_DELIVERY;
    private int stock;
    private List<String> mainImages;
    private List<String> subImages;

    public ItemDetailResponse(Item item) {
        this.name = item.getName();
        this.description = item.getDescription();
        this.originalPrice = item.getPrice();
        this.discountedPrice = item.getDiscountedItemPrice();
        this.discountPolicy = item.getDiscountPolicy().getName();
        this.mileage = item.getMileage();
        this.supportDawnDelivery = item.isSupportDawnDelivery();
        this.stock = item.getStock();
        this.mainImages = getItemImages(item, ItemImageType.MAIN);
        this.subImages = getItemImages(item, ItemImageType.SUB);
    }

    private List<String> getItemImages(Item item, ItemImageType type) {
        return item.getItemImages().stream()
                .filter(itemImage -> itemImage.getItemImageType() == type)
                .sorted(Comparator.comparing(ItemImage::getItemImageSequence))
                .map(ItemImage::getItemImageUrl)
                .collect(Collectors.toList());
    }

}
