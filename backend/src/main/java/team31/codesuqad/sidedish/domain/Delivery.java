package team31.codesuqad.sidedish.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("deliveries")
public class Delivery {

    @Id
    private Integer id;

    private final Integer deliveryPay;
    private final String deliveryArea;
    private final Boolean deliveryMorning;

    public Delivery(Integer deliveryPay, String deliveryArea, Boolean deliveryMorning) {
        this.deliveryPay = deliveryPay;
        this.deliveryArea = deliveryArea;
        this.deliveryMorning = deliveryMorning;
    }

    public Integer getId() {
        return id;
    }

    public Integer getDeliveryPay() {
        return deliveryPay;
    }

    public String getDeliveryArea() {
        return deliveryArea;
    }

    public Boolean getDeliveryMorning() {
        return deliveryMorning;
    }
}
