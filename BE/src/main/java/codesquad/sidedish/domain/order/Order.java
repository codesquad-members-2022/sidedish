package codesquad.sidedish.domain.order;

import codesquad.sidedish.domain.delivery.Delivery;
import codesquad.sidedish.domain.discount.DiscountPolicy;
import codesquad.sidedish.domain.item.Item;
import codesquad.sidedish.domain.member.Member;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class Order {
    private Long orderId;
    private Item item;
    private Member member;
    private Delivery delivery;
    private DiscountPolicy discountPolicy;
    private int orderItemPrice;
    private int itemCount;

    public Order(Item item, Member member, Delivery delivery, DiscountPolicy discountPolicy, int orderItemPrice, int itemCount) {
        this.item = item;
        this.member = member;
        this.delivery = delivery;
        this.discountPolicy = discountPolicy;
        this.orderItemPrice = orderItemPrice;
        this.itemCount = itemCount;
    }

    @Builder
    public Order(Long orderId, Item item, Member member, Delivery delivery, DiscountPolicy discountPolicy, int orderItemPrice, int itemCount) {
        this.orderId = orderId;
        this.item = item;
        this.member = member;
        this.delivery = delivery;
        this.discountPolicy = discountPolicy;
        this.orderItemPrice = orderItemPrice;
        this.itemCount = itemCount;
    }

    public void initOrderId(Long orderId) {
        this.orderId = orderId;
    }
}


