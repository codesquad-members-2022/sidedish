package com.example.be.business.event.common;


import com.example.be.business.event.common.ApplicationEventz;
import com.example.be.business.event.common.EventListenerz;

@FunctionalInterface
public interface ApplicationListenerz<E extends ApplicationEventz> extends EventListenerz {
    void onApplicationEvent(E event);
}
