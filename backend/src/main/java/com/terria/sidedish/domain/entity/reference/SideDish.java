package com.terria.sidedish.domain.entity.reference;

import lombok.*;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SideDish {

    @Id
    private long id;
    private String name;
    private String description;
    private int price;
    private double accrualRate;

    private String shippingInfo;
    private int shippingFee;
    private int exemptionCondition;

    @Override
    public String toString() {
        return "SideDish{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", accrualRate=" + accrualRate +
                ", shippingInfo='" + shippingInfo + '\'' +
                ", shippingFee=" + shippingFee +
                ", exemptionCondition=" + exemptionCondition +
                '}';
    }
}
