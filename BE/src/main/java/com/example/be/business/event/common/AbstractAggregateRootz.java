package com.example.be.business.event.common;

import org.springframework.data.annotation.Transient;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AbstractAggregateRootz<A extends AbstractAggregateRootz<A>> {

    @Transient
    private transient final List<Object> domainEvents = new ArrayList<>();

    protected <T> T registerEvent(T event) {
        this.domainEvents.add(event);
        return event;
    }
}
