package codesquad.sidedish.domain.discount;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class DiscountPolicy {
    private Long discountPolicyId;
    private String name;
    private double discountRate;

    public DiscountPolicy(String name, double discountRate) {
        this.name = name;
        this.discountRate = discountRate;
    }

    @Builder
    public DiscountPolicy(Long discountPolicyId, String name, double discountRate) {
        this.discountPolicyId = discountPolicyId;
        this.name = name;
        this.discountRate = discountRate;
    }

    public void initDiscountPolicyId(Long discountPolicyId) {
        this.discountPolicyId = discountPolicyId;
    }

    public int calculateDiscountedPrice(int price) {
        return (int)(price * (1 - discountRate));
    }
}
