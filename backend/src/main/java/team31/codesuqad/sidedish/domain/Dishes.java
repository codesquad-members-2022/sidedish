package team31.codesuqad.sidedish.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Dishes {

    @Id
    private Long id;

    private String title;
    private String description;
    private Integer price;
    private Integer stockQuantity;
    private Integer point;
    private Integer eventTabsId;
    private Integer categoryId;
    private Integer deliveryId;

    @MappedCollection(idColumn = "dish_id", keyColumn = "dish_id")
    private List<Images> images;

    @MappedCollection(idColumn = "dish_id", keyColumn = "dish_id")
    private List<Discount> discounts;

    @Transient
    private List<DiscountPolicies> eventBadge;

    public Dishes(Long id, String title, String description, int price, Integer stockQuantity, Integer point) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.point = point;
        images = new ArrayList<>();
        discounts = new ArrayList<>();
        eventBadge = new ArrayList<>();
    }

    public void setEventBadge(List<DiscountPolicies> discountPolicies) {
        this.eventBadge = discountPolicies;
    }

    public boolean isSameEvent(EventTabs eventTab) {
        return Objects.equals(eventTabsId, eventTab.getId());
    }

    public boolean isSameCategory(Category category) {
        return Objects.equals(categoryId, category.getId());
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

    public List<Images> getImages() {
        return images;
    }

    public List<Discount> getDiscounts() {
        return discounts;
    }

    public List<DiscountPolicies> getEventBadge() {
        return eventBadge;
    }

}
