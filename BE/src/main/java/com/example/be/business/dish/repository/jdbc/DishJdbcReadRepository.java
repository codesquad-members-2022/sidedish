package com.example.be.business.dish.repository.jdbc;

import com.example.be.business.dish.controller.dto.PlanningDataRequest;
import com.example.be.business.dish.domain.Badge;
import com.example.be.business.dish.domain.DeliveryPriceOption;
import com.example.be.business.dish.domain.DishStatus;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DishJdbcReadRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public DishJdbcReadRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<PlanningDataRequest> getPlanningData() {
        String query = "SELECT dish.*, category.* FROM dish JOIN category ON dish.category_id = category.category_id";
        return namedParameterJdbcTemplate.query(query, generalMapper);
    }

    public static RowMapper<PlanningDataRequest> generalMapper = (rs, rowNum) ->
            new PlanningDataRequest(
                    rs.getLong("dish_id"),
                    rs.getString("name"),
                    rs.getString("description"),
                    rs.getBigDecimal("price"),
                    Badge.valueOf(rs.getString("badge")),
                    DeliveryPriceOption.valueOf(rs.getString("delivery_price_option")),
                    rs.getString("thumbnail"),
                    DishStatus.valueOf(rs.getString("dish_status")),
                    rs.getString("description")
            );
}
