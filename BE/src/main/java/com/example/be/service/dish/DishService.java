package com.example.be.service.dish;

import com.example.be.controller.ApiResult;
import com.example.be.controller.dish.DishDetail;
import com.example.be.controller.dish.dto.PlanningDataRequest;
import com.example.be.controller.exception.UserTypeException;
import com.example.be.domain.dish.Dish;
import com.example.be.repository.dish.DishReadRepository;
import com.example.be.repository.dish.DishRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DishService {

    private final DishReadRepository dishReadRepository;
    private final DishRepository dishRepository;

    public DishService(DishReadRepository dishReadRepository, DishRepository dishRepository) {
        this.dishReadRepository = dishReadRepository;
        this.dishRepository = dishRepository;
    }

    @Transactional
    public List<PlanningDataRequest> getPlanningData() {
        return dishReadRepository.getPlanningData();
    }

    // TODO UserTypeException 설정
    @Transactional(readOnly = true)
    public Dish getDishDetail(Long id) {
        return dishRepository.findById(id).orElseThrow();
    }
}
