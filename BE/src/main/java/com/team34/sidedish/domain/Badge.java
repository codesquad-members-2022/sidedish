package com.team34.sidedish.domain;

public enum Badge {
    NONE("", 0), EVENT("이벤트특가", 0.1), NEW("런칭특가", 0.2);

    private final String name;
    private final double discountRate;

    Badge(String name, double discountRate) {
        this.name = name;
        this.discountRate = discountRate;
    }

    public String getName() {
        return name;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public int calculateDiscountPrice(int originPrice) {
        return (int) (originPrice - (originPrice * discountRate));
    }

    static public Badge of(String name) {
        for (Badge value : Badge.values()) {
            if(value.getName().equals(name)) {
                return value;
            }
        }
        return NONE;
    }
}
