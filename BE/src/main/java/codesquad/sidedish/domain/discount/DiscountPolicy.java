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

    @Builder
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

    public void initDiscountPolicy(Long discountPolicyId) {
        this.discountPolicyId = discountPolicyId;
    }

    public long calculateDiscountedPrice(long price) {
        return (long)(price * (1 - discountRate));
    }
}
