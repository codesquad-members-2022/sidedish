package com.example.be.business.dish.service;

import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

@Configuration
public class InMemogryDatabase {

    private static final int LIMIT = 3;
    private List<DishInformationResponse> planningDataResponses = new ArrayList<>();

    public Map<CategoryType, List<DishInformationResponse>> getPlanningDataByCategory() {
        return planningDataResponses.stream()
                .collect(groupingBy(DishInformationResponse::getCategoryType));
    }

    public Map<Long, List<DishInformationResponse>> getPlanningDataBySubCategory(Long id) {
        Collections.shuffle(planningDataResponses);
        return planningDataResponses.stream()
                .filter(x -> x.equalTo(id))
                .limit(LIMIT)
                .collect(groupingBy(DishInformationResponse::getCategoryId));
    }

    public boolean planningDataisEmpty() {
        return planningDataResponses.isEmpty();
    }

    public void savePlanningData(List<DishInformationResponse> planningData) {
        planningDataResponses.addAll(planningData);
    }
}
