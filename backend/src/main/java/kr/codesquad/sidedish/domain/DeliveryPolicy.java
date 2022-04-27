package kr.codesquad.sidedish.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;

@Getter
@RequiredArgsConstructor
public class DeliveryPolicy {

    @Id
    private Long id;
    private final String description;
    private final Boolean earlyMorningDelivery;
    private final Boolean nationwideDelivery;
    private final Integer deliveryRate;
    private final Integer freeDeliveryThreshold;
}
