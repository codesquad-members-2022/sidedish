package codesquad.sidedish.domain.item;

import codesquad.sidedish.domain.discount.DiscountPolicy;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@EqualsAndHashCode
@ToString
public class Item {
    private Long itemId;
    private String name;
    private String description;
    private int price;
    private DiscountPolicy discountPolicy;
    private ItemSection itemSection;
    private int stock;
    private List<ItemImage> itemImages;
    private boolean supportDawnDelivery;

    public Item(String name, String description, int price, DiscountPolicy discountPolicy, ItemSection itemSection, int stock, List<ItemImage> itemImages, boolean supportDawnDelivery) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.discountPolicy = discountPolicy;
        this.itemSection = itemSection;
        this.stock = stock;
        this.itemImages = itemImages;
        this.supportDawnDelivery = supportDawnDelivery;
    }

    @Builder
    public Item(Long itemId, String name, String description, int price, DiscountPolicy discountPolicy, ItemSection itemSection, int stock, List<ItemImage> itemImages, boolean supportDawnDelivery) {
        this.itemId = itemId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.discountPolicy = discountPolicy;
        this.itemSection = itemSection;
        this.stock = stock;
        this.itemImages = itemImages;
        this.supportDawnDelivery = supportDawnDelivery;
    }

    public void initItemId(Long itemId) {
        this.itemId = itemId;
    }

    public void reduceStock(int reduceQuantity) {
        validateReduceQuantity(reduceQuantity);
        this.stock -= reduceQuantity;
    }

    private void validateReduceQuantity(int reduceNumber) {
        if (reduceNumber > this.stock) {
            throw new IllegalArgumentException(
                    String.format("최대 구입 가능 개수는 %d개입니다.", this.stock)
            );
        }
    }
}


