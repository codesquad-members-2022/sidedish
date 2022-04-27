package team31.codesuqad.sidedish.domain;

public class Discount {

    private Long dishId;
    private Integer discountPolicyId;

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
