package codesquad.sidedish.web.dto;

import lombok.Getter;

@Getter
public class OrderCreateResponse {

    private Long orderId = 4L;
    private String orderMemberName = "sampleMember";
    private String deliveryAddress = "서울특별시 강남구";
    private String orderItemName = "땃쥐고기";
    private int originalItemPrice = 10000;
    private int discountedItemPrice = 8000;
    private int orderItemCount = 3;
    private String discountPolicy = "런칭특가";
    private String deliveryType = "새벽배송";
    private int deliveryFee = 2500;
    private int totalPrice = 26500;
    private int mileage = 240;

}
