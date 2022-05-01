package team31.codesuqad.sidedish.domain;

import org.springframework.data.relational.core.mapping.Table;

@Table("discounts")
public class Discount {

    private final Long dishId;
    private final Integer discountPolicyId;

    public Discount(Long dishId, Integer discountPolicyId) {
        this.dishId = dishId;
        this.discountPolicyId = discountPolicyId;
    }

    public Long getDishId() {
        return dishId;
    }

    public Integer getDiscountPolicyId() {
        return discountPolicyId;
    }

}
