package team31.codesuqad.sidedish.controller.dto;

import team31.codesuqad.sidedish.domain.DiscountPolicy;
import team31.codesuqad.sidedish.domain.Dish;
import team31.codesuqad.sidedish.domain.Image;
import team31.codesuqad.sidedish.type.ImageType;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class DishDto {

    private final Long dishId;
    private final String title;
    private final String description;
    private final Integer price;
    private String mainImage;
    private List<DiscountDto> eventBadge;

    public DishDto(Dish dish) {
        this.dishId = dish.getId();
        this.title = dish.getTitle();
        this.description = dish.getDescription();
        this.price = dish.getPrice();
        this.mainImage = makeImages(dish.getImages());
        this.eventBadge = makeEventBadge(dish.getDiscountPolicies());
    }

    private String makeImages(List<Image> images) {
        Image image = images.stream()
                .filter(i -> i.isSameType(ImageType.main))
                .findAny()
                .orElseThrow(() -> new NoSuchElementException("메인 이미지가 없습니다."));
        return image.getUrl();
    }

    private List<DiscountDto> makeEventBadge(List<DiscountPolicy> discountPolicies) {
        return discountPolicies.stream()
                .map(DiscountDto::new)
                .collect(Collectors.toList());
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
