package com.example.be.repository.dish;

import com.example.be.controller.dish.dto.PlanningDataRequest;
import com.example.be.domain.dish.Badge;
import com.example.be.domain.dish.DeliveryType;
import com.example.be.domain.dish.DishStatus;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DishReadRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public DishReadRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
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
                    rs.getBigDecimal("normal_price"),
                    Badge.valueOf(rs.getString("badge")),
                    DeliveryType.valueOf(rs.getString("delivery_type")),
                    rs.getString("thumbnail"),
                    DishStatus.valueOf(rs.getString("dish_status")),
                    rs.getLong("category_id"),
                    rs.getString("title")
            );
}
