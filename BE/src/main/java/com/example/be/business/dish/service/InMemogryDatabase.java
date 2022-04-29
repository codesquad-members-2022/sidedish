package com.example.be.business.dish.service;

import com.example.be.business.dish.domain.Dish;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class InMemogryDatabase {
    private List<Dish> dishes = new ArrayList<>();
}
