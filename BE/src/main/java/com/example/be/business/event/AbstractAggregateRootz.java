package com.example.be.business.event;

import org.springframework.data.annotation.Transient;

import java.util.ArrayList;
import java.util.List;

public class AbstractAggregateRootz<A extends AbstractAggregateRootz<A>> {

    private transient final @Transient
    List<Object> domainEvents = new ArrayList<>();

    protected <T> T registerEvent(T event) {
        this.domainEvents.add(event);
        return event;
    }
}
