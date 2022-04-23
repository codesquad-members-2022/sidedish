package kr.codesquad.sidedish.domain;

import org.springframework.data.annotation.Id;

public class Delivery {

    @Id
    private final Long delivery_id;
    private final String delivery_name;

    public Delivery(Long delivery_id, String delivery_name) {
        this.delivery_id = delivery_id;
        this.delivery_name = delivery_name;
    }

    public Long getDelivery_id() {
        return delivery_id;
    }

    public String getDelivery_name() {
        return delivery_name;
    }
}
