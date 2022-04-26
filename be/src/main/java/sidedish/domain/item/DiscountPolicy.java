package sidedish.domain.item;

public enum DiscountPolicy {
    LUNCH("lunch", 0.1),
    EVENT("event", 0.2);


    private final String type;
    private final double rate;

    DiscountPolicy(String type, double rate) {
        this.type = type;
        this.rate = rate;
    }

    public String getType() {
        return type;
    }

    public double getRate() {
        return rate;
    }
}
