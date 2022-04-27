package team31.codesuqad.sidedish.domain;

import org.springframework.data.annotation.Id;

public class DiscountPolicies {

    @Id
    private Integer id;

    private String name;
    private Integer discountRate;

    public DiscountPolicies(Integer id, String name, Integer discountRate) {
        this.id = id;
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
