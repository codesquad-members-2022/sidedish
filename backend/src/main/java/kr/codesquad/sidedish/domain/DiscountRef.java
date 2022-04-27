package kr.codesquad.sidedish.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@RequiredArgsConstructor
@Table(value = "product_discount")
@ToString
public class DiscountRef {

    private final Long discountId;
}
