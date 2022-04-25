package com.example.be.config;

import org.springframework.context.annotation.Configuration;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Configuration
public class EventQueue {
    private BlockingQueue<?> events = new LinkedBlockingQueue<>();
}
