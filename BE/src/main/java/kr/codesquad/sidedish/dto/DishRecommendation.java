package kr.codesquad.sidedish.dto;

import kr.codesquad.sidedish.domain.Dish;

public class DishRecommendation {

    private static final int MAIN_IMAGE_INDEX = 0;

    private final Long id;
    private final String name;
    private final String image;
    private final int normalPrice;
    private final int discountPrice;

    public DishRecommendation(Long id, String name, String image, int normalPrice, int discountPrice) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.normalPrice = normalPrice;
        this.discountPrice = discountPrice;
    }

    public static DishRecommendation from(Dish dish) {
        return new DishRecommendation(dish.getId(), dish.getName(), dish.getImagePath(MAIN_IMAGE_INDEX),
                dish.getPrice(), dish.getDiscountPrice());
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public int getNormalPrice() {
        return normalPrice;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }
}
