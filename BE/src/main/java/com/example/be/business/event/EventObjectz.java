package com.example.be.business.event;

public class EventObjectz {
    private static final long serialVersionUID = 5516075349620653480L;

    protected transient Object source;

    public EventObjectz(Object source) {
        if (source == null)
            throw new IllegalArgumentException("null source");

        this.source = source;
    }

    public Object getSource() {
        return source;
    }

}
