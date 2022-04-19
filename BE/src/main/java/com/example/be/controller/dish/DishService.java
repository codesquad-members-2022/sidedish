package com.example.be.controller.dish;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DishService {

    private final DishRepository dishRepository;

    public DishService(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    @Transactional
    public List<PlanningDataRequest> getPlanningData() {
        return dishRepository.getPlanningData();
    }
}
