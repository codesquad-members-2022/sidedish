package team31.codesuqad.sidedish.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("discount_policies")
public class DiscountPolicy {

    @Id
    private Integer id;

    private final String name;
    private final Integer discountRate;

    public DiscountPolicy(String name, Integer discountRate) {
        this.name = name;
        this.discountRate = discountRate;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getDiscountRate() {
        return discountRate;
    }

}
