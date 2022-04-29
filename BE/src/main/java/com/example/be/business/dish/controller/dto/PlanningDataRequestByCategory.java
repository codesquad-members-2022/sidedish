package com.example.be.business.dish.controller.dto;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PlanningDataRequestByCategory {

    private Map<String, List<PlanningDataRequest>> planningData;

    private List<PlanningDataRequest> planningDataRequests;

    public PlanningDataRequestByCategory(List<PlanningDataRequest> planningDataRequests) {
        this.planningDataRequests = planningDataRequests;
        groupByCategory(planningDataRequests);
    }

    public void groupByCategory(List<PlanningDataRequest> planningDataRequests) {
        planningData = planningDataRequests.stream().collect(Collectors.groupingBy(PlanningDataRequest::getTitle));
    }

    public Map<String, List<PlanningDataRequest>> getPlanningData() {
        return planningData;
    }
}
