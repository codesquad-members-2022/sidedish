package sidedish.web.dto.item;

import lombok.AllArgsConstructor;
import lombok.Getter;
import sidedish.domain.item.DiscountPolicy;
import sidedish.domain.item.Item;
import sidedish.web.dto.image.ResponseImagesDto;

import java.util.List;

@Getter
@AllArgsConstructor
public class ResponseItemDto {
    private Long id;
    private String title;
    private String description;
    private int price;
    private int quantity;
    private double accumulate;
    private String discountPolicy;
    private double discountRate;
    private boolean morningDelivery;
    private List<ResponseImagesDto> images;

    public ResponseItemDto(Item item, List<ResponseImagesDto> images) {
        this.id = item.getId();
        this.title = item.getTitle();
        this.description = item.getDescription();
        this.price = item.getPrice();
        this.quantity = item.getQuantity();
        this.accumulate = item.getAccumulate();
        this.discountPolicy = item.getDiscountPolicy();
        this.discountRate = item.getDiscountRate();
        this.morningDelivery = item.isMorningDelivery();
        this.images = images;

    }
}
