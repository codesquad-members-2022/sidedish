package codesquad.sidedish.domain.order;

import codesquad.sidedish.domain.address.Address;
import codesquad.sidedish.domain.delivery.Delivery;
import codesquad.sidedish.domain.delivery.DeliveryRepository;
import codesquad.sidedish.domain.delivery.DeliveryType;
import codesquad.sidedish.domain.item.Item;
import codesquad.sidedish.domain.item.ItemRepository;
import codesquad.sidedish.domain.member.Member;
import codesquad.sidedish.domain.member.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest
@Transactional
class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private DeliveryRepository deliveryRepository;

    @Test
    @DisplayName("주문을 저장하고 같은 주문 Id로 조회했을 때, 같은 주문이 찾아져야한다.")
    void saveAndFindTest() {
        Member member = new Member("testMember",new Address("서울특별시", "강남구"));
        memberRepository.save(member);

        Item item = itemRepository.findById(1L).get();

        Delivery delivery = Delivery.builder()
                .deliveryFee(2500)
                .deliveryType(DeliveryType.DAWN)
                .address(member.getAddress())
                .build();
        deliveryRepository.save(delivery);

        Order saveOrder = Order.builder()
                .item(item)
                .member(member)
                .delivery(delivery)
                .discountPolicy(item.getDiscountPolicy())
                .orderItemPrice(item.getPrice())
                .itemCount(5)
                .build();

        orderRepository.save(saveOrder);
        log.info("saveOrder = {}", saveOrder);

        Order findOrder = orderRepository.findById(saveOrder.getOrderId()).get();
        log.info("findOrder = {}", findOrder);

        assertThat(saveOrder).isEqualTo(findOrder);
    }

}
