package kr.codesquad.sidedish.web.dto.item;

import kr.codesquad.sidedish.domain.Item;

public class ItemResponseDto {

    private final Long item_id;
    private final Long category_id;
    private final String item_name;
    private final String description;
    private final Integer or_price;
    private final Integer dc_price;
    private final Integer label_id;
    private final String main_image;
    private final Integer delivery_id;
    private final Long best_id;

    public ItemResponseDto(Long item_id, Long category_id, String item_name, String description,
                           Integer or_price, Integer dc_price, Integer label_id,
                           String main_image, Integer delivery_id, Long best_id) {
        this.item_id = item_id;
        this.category_id = category_id;
        this.item_name = item_name;
        this.description = description;
        this.or_price = or_price;
        this.dc_price = dc_price;
        this.label_id = label_id;
        this.main_image = main_image;
        this.delivery_id = delivery_id;
        this.best_id = best_id;
    }

    public static ItemResponseDto of(Item item) {
        return new ItemResponseDto(item.getItem_id(),
                item.getCategory_id(),
                item.getItem_name(),
                item.getDescription(),
                item.getOr_price(),
                item.getDc_price(),
                item.getLabel_id(),
                item.getMain_image(),
                item.getDelivery_id(),
                item.getBest_id());
    }

    public Long getItem_id() {
        return item_id;
    }

    public Long getCategory_id() {
        return category_id;
    }

    public String getItem_name() {
        return item_name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getOr_price() {
        return or_price;
    }

    public Integer getDc_price() {
        return dc_price;
    }

    public Integer getLabel_id() {
        return label_id;
    }

    public String getMain_image() {
        return main_image;
    }

    public Integer getDelivery_id() {
        return delivery_id;
    }

    public Long getBest_id() {
        return best_id;
    }
}
