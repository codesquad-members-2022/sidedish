package codesquad.sidedish.domain.delivery;

import codesquad.sidedish.domain.address.Address;
import lombok.Builder;

public class Delivery {
    private Long deliveryId;
    private int deliveryFee;
    DeliveryType deliveryType;
    Address address;

    @Builder
    public Delivery(int deliveryFee, DeliveryType deliveryType, Address address) {
        this.deliveryFee = deliveryFee;
        this.deliveryType = deliveryType;
        this.address = address;
    }

    @Builder
    public Delivery(Long deliveryId, int deliveryFee, DeliveryType deliveryType, Address address) {
        this.deliveryId = deliveryId;
        this.deliveryFee = deliveryFee;
        this.deliveryType = deliveryType;
        this.address = address;
    }
}
