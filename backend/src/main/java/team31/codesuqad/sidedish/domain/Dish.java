package team31.codesuqad.sidedish.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Table("dishes")
public class Dish {

    @Id
    private Long id;

    private final String title;
    private final String description;
    private final Integer price;
    private final Integer stockQuantity;
    private final Integer point;
    private final Integer eventTabsId;
    private final Integer categoryId;
    private final Integer deliveryId;

    @MappedCollection(idColumn = "dish_id", keyColumn = "dish_id")
    private List<Image> images;

    @MappedCollection(idColumn = "dish_id", keyColumn = "dish_id")
    private List<Discount> discounts;

    @Transient
    private List<DiscountPolicy> discountPolicies;

    public Dish(String title, String description, Integer price, Integer stockQuantity, Integer point, Integer eventTabsId, Integer categoryId, Integer deliveryId) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.point = point;
        this.eventTabsId = eventTabsId;
        this.categoryId = categoryId;
        this.deliveryId = deliveryId;
        this.images = new ArrayList<>();
        this.discounts = new ArrayList<>();
        this.discountPolicies = new ArrayList<>();
    }

    public void mappingDiscountPolicies(Map<Integer, DiscountPolicy> discountPoliciesMap) {
        discountPolicies = discounts.stream()
                .map(Discount::getDiscountPolicyId)
                .map(discountPoliciesMap::get)
                .collect(Collectors.toList());
    }

    public Long getId() {
        return id;
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

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public Integer getPoint() {
        return point;
    }

    public Integer getEventTabsId() {
        return eventTabsId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public Integer getDeliveryId() {
        return deliveryId;
    }

    public List<Image> getImages() {
        return images;
    }

    public List<Discount> getDiscounts() {
        return discounts;
    }

    public List<DiscountPolicy> getDiscountPolicies() {
        return discountPolicies;
    }

}
