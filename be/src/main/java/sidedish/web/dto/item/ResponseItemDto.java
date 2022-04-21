package sidedish.web.dto.item;

import lombok.AllArgsConstructor;
import lombok.Getter;
import sidedish.domain.item.Item;

import java.util.List;

@Getter
@AllArgsConstructor
public class ResponseItemDto {
    private Long id;
    private String title;
    private String description;
    private int price;
    private double accumulate;
    private String discountPolicy;
    private double discountRate;
    private boolean morningDelivery;
    private String mainImage;
    private List<String> tabList;

    public ResponseItemDto(Item item, String mainImage, List<String> tabList) {
        this.id = item.getId();
        this.title = item.getTitle();
        this.description = item.getDescription();
        this.price = item.getPrice();
        this.accumulate = item.getPrice() * 0.01;
        this.discountPolicy = item.getDiscountPolicy();
        this.discountRate = 0.1;
        this.morningDelivery = item.isMorningDelivery();
        this.mainImage = mainImage;
        this.tabList = tabList;
    }
}
