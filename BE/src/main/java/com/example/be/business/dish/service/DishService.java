package com.example.be.business.dish.service;

import com.example.be.business.dish.controller.dto.PlanningDataRequest;
import com.example.be.business.dish.domain.Badge;
import com.example.be.business.dish.domain.DeliveryPriceOption;
import com.example.be.business.dish.domain.Dish;
import com.example.be.business.dish.domain.DishStatus;
import com.example.be.business.dish.repository.DishRepository;
import com.example.be.business.dish.repository.jdbc.DishJdbcReadRepository;
import com.example.be.common.exception.BusinessException;
import com.example.be.common.exception.dish.DishTypeException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class DishService {

    private final Logger logger = LoggerFactory.getLogger(DishService.class);

    private final DishJdbcReadRepository dishJdbcReadRepository;
    private final InMemogryDatabase inMemogryDatabase;
    private final DishRepository dishRepository;

    public DishService(DishJdbcReadRepository dishJdbcReadRepository, InMemogryDatabase inMemogryDatabase, DishRepository dishRepository) {
        this.dishJdbcReadRepository = dishJdbcReadRepository;
        this.inMemogryDatabase = inMemogryDatabase;
        this.dishRepository = dishRepository;
    }

    @Transactional(readOnly = true)
    public List<PlanningDataRequest> getPlanningData() {
        logger.info("기획전 데이터 조회");
        return dishJdbcReadRepository.getPlanningData();
    }

    @Transactional(readOnly = true)
    public Dish getDishDetail(Long id) {
        logger.info("상품 상세 조회: 상품번호 {}", id);
        return dishRepository.findById(id)
                .orElseThrow(() -> new BusinessException(DishTypeException.DISH_NOT_FOUND_EXCEPTION));
    }

    @Transactional
    public void updateDish(Long id, BigDecimal price, Badge badge, DeliveryPriceOption deliveryPriceOption, String thumbnail, DishStatus dishStatus, Long categoryId, int count) {
        logger.info("상품 수정: 상품번호 {}", id);
        Dish findDish = dishRepository.findById(id).orElseThrow(
                () -> new BusinessException(DishTypeException.DISH_NOT_FOUND_EXCEPTION));
        findDish.publishUpdateDish(price, badge, deliveryPriceOption, thumbnail, dishStatus, categoryId, count);
    }
}
