package com.example.be.business.event.common;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

public abstract class ApplicationEventz extends EventObjectz {

    private static final long serialVersionUID = 7099057708183571937L;

    private final long timestamp;

    public ApplicationEventz(Object source) {
        super(source);
        this.timestamp = System.currentTimeMillis();
    }

}
