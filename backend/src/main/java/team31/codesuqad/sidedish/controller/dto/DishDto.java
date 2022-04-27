package team31.codesuqad.sidedish.controller.dto;

import team31.codesuqad.sidedish.domain.Dishes;
import team31.codesuqad.sidedish.domain.Images;

import java.util.List;

public class DishDto {

    private Long dishId;
    private String title;
    private String description;
    private Integer price;
    private String mainImage;
    private List<DiscountDto> eventBadge;

    public DishDto(Dishes dish, Images images, List<DiscountDto> discountDtos) {
        this.dishId = dish.getId();
        this.title = dish.getTitle();
        this.description = dish.getDescription();
        this.price = dish.getPrice();
        this.mainImage = images.getUrl();
        this.eventBadge = discountDtos;
    }

    public Long getDishId() {
        return dishId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Integer getPrice() {
        return price;
    }

    public String getMainImage() {
        return mainImage;
    }

    public List<DiscountDto> getEventBadge() {
        return eventBadge;
    }
}
