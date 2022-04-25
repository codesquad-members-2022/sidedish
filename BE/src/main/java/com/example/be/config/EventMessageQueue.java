package com.example.be.config;

import org.springframework.stereotype.Component;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Component
public class EventMessageQueue {
    private BlockingQueue<?> events = new LinkedBlockingQueue<>();
}
