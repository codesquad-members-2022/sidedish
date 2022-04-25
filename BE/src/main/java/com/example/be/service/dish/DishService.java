package com.example.be.service.dish;

import com.example.be.controller.dish.dto.PlanningDataRequest;
import com.example.be.controller.exception.BusinessException;
import com.example.be.controller.exception.DishTypeException;
import com.example.be.domain.dish.Dish;
import com.example.be.repository.dish.DishRepository;
import com.example.be.repository.dish.jdbc.DishJdbcReadRepository;
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

    public DishService(DishJdbcReadRepository dishJdbcReadRepository, DishRepository dishRepository) {
        this.dishJdbcReadRepository = dishJdbcReadRepository;
        this.dishRepository = dishRepository;
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
