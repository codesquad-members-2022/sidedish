package com.example.be.controller.dish;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishService {

    private final DishRepository dishRepository;

    public DishService(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    public List<PlanningDataRequest> getPlanningData() {
        return dishRepository.getPlanningData();
    }
}
