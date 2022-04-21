package sidedish.web.dto.item;

import lombok.AllArgsConstructor;
import lombok.Getter;

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
}
