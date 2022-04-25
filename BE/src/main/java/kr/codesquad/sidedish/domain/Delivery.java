package kr.codesquad.sidedish.domain;

import org.springframework.data.annotation.Id;

public class Delivery {

    @Id
    private final Long deliveryId;
    private final String deliveryName;

    public Delivery(Long deliveryId, String deliveryName) {
        this.deliveryId = deliveryId;
        this.deliveryName = deliveryName;
    }

    public Long getDeliveryId() {
        return deliveryId;
    }

    public String getDeliveryName() {
        return deliveryName;
    }
}
