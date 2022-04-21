package sidedish.web.dto.item;

import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import sidedish.domain.item.Item;

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

    public ResponseItemDto(Item item) {
        this.id = item.getId();
        this.title = item.getTitle();
        this.description = item.getDescription();
        this.price = item.getPrice();
        this.accumulate = item.getPrice() * 0.01;
        this.discountPolicy = item.getDiscountPolicy();
        this.discountRate = 0.1;
        this.morningDelivery = item.isMorningDelivery();
        this.mainImage = "이미지";
        this.tabList = new ArrayList<>();
    }
}
