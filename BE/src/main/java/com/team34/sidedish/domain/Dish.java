package com.team34.sidedish.domain;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

public class Dish {

    private static int MAIN_IMAGE_INDEX = 0;

    @Id
    private Long id;
    private String title;
    private String content;
    private String tag;
    private int price;
    private int stock;
    private int deliveryFee;
    private Integer freeShippingAmount;
    private double mileageRate;
    private boolean earlyDeliverable;

    @MappedCollection(idColumn = "dish_id", keyColumn = "id")
    private final List<CategoryDish> categories;

    @MappedCollection(idColumn = "dish_id", keyColumn = "id")
    private final List<DishImage> images;

    public Dish(Long id, String title, String content, String tag, int price, int stock,
        int deliveryFee, Integer freeShippingAmount, double mileageRate, boolean earlyDeliverable,
        List<CategoryDish> categories, List<DishImage> images) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.tag = tag;
        this.price = price;
        this.stock = stock;
        this.deliveryFee = deliveryFee;
        this.freeShippingAmount = freeShippingAmount;
        this.mileageRate = mileageRate;
        this.earlyDeliverable = earlyDeliverable;
        this.categories = categories;
        this.images = images;
    }

    public List<Long> categoryIds() {
        return categories.stream()
            .map(CategoryDish::getCategoryId)
            .collect(Collectors.toList());
    }

    public String mainImagePath() {
        if (isImageExist()) {
            return images.get(MAIN_IMAGE_INDEX).getPath();
        }
        return "";
    }

    private boolean isImageExist() {
        return images.size() > 0;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getTag() {
        return tag;
    }

    public int getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public int getDeliveryFee() {
        return deliveryFee;
    }

    public Integer getFreeShippingAmount() {
        return freeShippingAmount;
    }

    public double getMileageRate() {
        return mileageRate;
    }

    public boolean isEarlyDeliverable() {
        return earlyDeliverable;
    }

    public List<CategoryDish> getCategories() {
        return categories;
    }

    public List<DishImage> getImages() {
        return images;
    }

    public List<String> getImagePaths() {
        return images.stream()
            .map(DishImage::getPath)
            .collect(Collectors.toList());
    }

    public boolean isOrderable(int quantity) {
        return stock >= quantity;
    }

    public void order(int quantity) {
        stock -= quantity;
    }

    @Override
    public String toString() {
        return "Dish{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", content='" + content + '\'' +
            ", price=" + price +
            ", stock=" + stock +
            ", deliveryFee=" + deliveryFee +
            ", freeShippingAmount=" + freeShippingAmount +
            ", mileageRate=" + mileageRate +
            ", earlyDeliverable=" + earlyDeliverable +
            ", categories=" + categories +
            ", images=" + images +
            '}';
    }
}
