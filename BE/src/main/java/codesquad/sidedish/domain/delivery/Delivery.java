package codesquad.sidedish.domain.delivery;

import codesquad.sidedish.domain.address.Address;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class Delivery {

    public static final int FREE_DELIVERY_FEE = 0;
    public static final int DEFAULT_DELIVERY_FEE = 2500;
    public static final int MINIMUM_PRICE_FOR_FREE_DELIVERY = 40000;

    private Long deliveryId;
    private int deliveryFee;
    private DeliveryType deliveryType;
    private Address address;

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

    public void initDeliveryId(Long deliveryId) {
        this.deliveryId = deliveryId;
    }
}
