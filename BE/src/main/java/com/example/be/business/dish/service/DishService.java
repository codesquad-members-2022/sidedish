package com.example.be.business.dish.service;

import com.example.be.business.dish.controller.dto.PlanningDataRequest;
import com.example.be.common.exception.dish.DishTypeException;
import com.example.be.common.exception.BusinessException;
import com.example.be.business.dish.domain.Dish;
import com.example.be.business.dish.repository.DishRepository;
import com.example.be.business.dish.repository.jdbc.DishJdbcReadRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DishService {

    private final Logger logger = LoggerFactory.getLogger(DishService.class);

    private final DishJdbcReadRepository dishJdbcReadRepository;
    private final DishRepository dishRepository;
    private final InMemogryDatabase inMemogryDatabase;

    public DishService(DishJdbcReadRepository dishJdbcReadRepository, DishRepository dishRepository, InMemogryDatabase inMemogryDatabase) {
        this.dishJdbcReadRepository = dishJdbcReadRepository;
        this.dishRepository = dishRepository;
        this.inMemogryDatabase = inMemogryDatabase;
    }

    @Transactional(readOnly = true)
    public List<PlanningDataRequest> getPlanningData() {
        logger.info("기획전 데이터 조회");
        return dishRepository.getPlanningData();
    }

    @Transactional(readOnly = true)
    public Dish getDishDetail(Long id) {
        logger.info("상품 상세 조회: 상품번호 {}", id);
        return dishRepository.findById(id)
                .orElseThrow(() -> new BusinessException(DishTypeException.DISH_NOT_FOUND_EXCEPTION));
    }
}
