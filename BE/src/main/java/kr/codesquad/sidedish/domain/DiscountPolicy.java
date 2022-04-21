package kr.codesquad.sidedish.domain;

import java.util.function.Function;

public enum DiscountPolicy {
    NONE(price -> price),
    FIX(price -> price - 3000),
    RATE(price -> Math.toIntExact(Math.round(price * 0.9)));

    private final Function<Integer, Integer> calculate;

    DiscountPolicy(Function<Integer, Integer> calculate) {
        this.calculate = calculate;
    }

    public int calculate(int price) {
        return this.calculate.apply(price);
    }
}
