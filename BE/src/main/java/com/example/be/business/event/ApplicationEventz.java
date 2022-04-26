package com.example.be.business.event;

public abstract class ApplicationEventz extends EventObjectz {

    private static final long serialVersionUID = 7099057708183571937L;

    /** System time when the event happened. */
    private final long timestamp;

    public ApplicationEventz(Object source) {
        super(source);
        this.timestamp = System.currentTimeMillis();
    }
}
