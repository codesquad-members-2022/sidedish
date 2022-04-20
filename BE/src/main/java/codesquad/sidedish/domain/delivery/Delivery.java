package codesquad.sidedish.domain.delivery;

import codesquad.sidedish.domain.address.District;
import lombok.Builder;

public class Delivery {
    private Long deliveryId;
    private int deliveryFee;
    DeliveryType deliveryType;
    District district;

    @Builder
    public Delivery(int deliveryFee, DeliveryType deliveryType, District district) {
        this.deliveryFee = deliveryFee;
        this.deliveryType = deliveryType;
        this.district = district;
    }

    @Builder
    public Delivery(Long deliveryId, int deliveryFee, DeliveryType deliveryType, District district) {
        this.deliveryId = deliveryId;
        this.deliveryFee = deliveryFee;
        this.deliveryType = deliveryType;
        this.district = district;
    }
}
