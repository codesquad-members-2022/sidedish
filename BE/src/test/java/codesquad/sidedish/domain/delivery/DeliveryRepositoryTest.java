package codesquad.sidedish.domain.delivery;

import codesquad.sidedish.domain.address.Address;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class DeliveryRepositoryTest {

    @Autowired
    DeliveryRepository deliveryRepository;

    @Test
    @DisplayName("save() 메서드를 호출하면 주문이 생성되어 DB에 저장되고 id값이 리턴된다.")
    void saveTest() {
        Delivery delivery = new Delivery(2500, DeliveryType.DAWN, new Address("서울특별시", "강남구"));
        Long savedDeliveryId = deliveryRepository.save(delivery);
        Delivery foundDelivery = deliveryRepository.findById(savedDeliveryId).get();
        assertThat(delivery.equals(foundDelivery));
    }

    @Test
    @DisplayName("findById() 메서드를 호출하면 리포지토리에서 해당 id값을 가진 Delivery를 찾아 리턴한다.")
    void findByIdTest() {
        Delivery deliveryOne = new Delivery(2500, DeliveryType.DAWN, new Address("서울특별시", "강남구"));
        Delivery deliveryTwo = new Delivery(0, DeliveryType.DAWN, new Address("강원도", "춘천시"));

        Long savedDeliveryOneId = deliveryRepository.save(deliveryOne);
        Long savedDeliveryTwoId = deliveryRepository.save(deliveryTwo);

        Delivery foundDeliveryOne = deliveryRepository.findById(savedDeliveryOneId).get();
        Delivery foundDeliveryTwo = deliveryRepository.findById(savedDeliveryTwoId).get();

        assertThat(deliveryOne.equals(foundDeliveryOne));
        assertThat(deliveryTwo.equals(foundDeliveryTwo));
        assertThat(!deliveryOne.equals(foundDeliveryTwo));
        assertThat(!deliveryTwo.equals(foundDeliveryOne));

        assertThrows(NoSuchElementException.class, () -> deliveryRepository.findById(-1L).get());
    }
}