package team31.codesuqad.sidedish.domain;

import org.springframework.data.annotation.Id;

public class Deliveries {

    @Id
    private Integer id;

    private Integer deliveryPay;
    private String deliveryArea;
    private Boolean deliveryMorning;

    public Deliveries(Integer id, Integer deliveryPay, String deliveryArea, Boolean deliveryMorning) {
        this.id = id;
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
