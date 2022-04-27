package codesquad.sidedish.web.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class ItemDetailResponse {

    private String name = "오리 주물럭_반조리";
    private String description = "감칠맛 나는 매콤한 양념";
    private int originalPrice = 10000;
    private int discountedPrice = 8000;
    private String discountPolicy = "런칭특가";
    private int mileage = 80;
    private boolean supportDawnDelivery = true;
    private int deliveryFee = 2500;
    private int deliveryFeeFreeMinPay = 40000;
    private int stock = 10;
    private List<String> mainImages = List.of("https://i.imgur.com/A14QwVW.jpeg", "https://i.imgur.com/AD3MbBi.jpeg");
    private List<String> subImages = List.of("https://i.imgur.com/Jvh1OQm.jpeg");

}
