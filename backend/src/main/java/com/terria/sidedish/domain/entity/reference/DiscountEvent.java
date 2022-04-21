package com.terria.sidedish.domain.entity.reference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;

@Getter
@AllArgsConstructor
public class DiscountEvent {

    @Id
    private long id;
    private String title;
    private double discountRate;

    @Override
    public String toString() {
        return "DiscountEvent{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", discountRate=" + discountRate +
                '}';
    }
}
