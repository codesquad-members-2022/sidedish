package com.example.be.service.dish;

import com.example.be.domain.dish.Dish;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class InMemogryDatabase {
    private List<Dish> dishes = new ArrayList<>();
}
