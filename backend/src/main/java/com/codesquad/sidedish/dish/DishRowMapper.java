package com.codesquad.sidedish.dish;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class DishRowMapper implements RowMapper<Dish> {

    @Override
    public Dish mapRow(ResultSet rs, int rowNum) throws SQLException {
        EventBadge eventBadge = new EventBadge(
            rs.getString("event_badge_name"),
            rs.getFloat("discount")
        );

        return new Dish(
            rs.getInt("dish_id"),
            rs.getInt("event_badge_id"),
            rs.getString("title"),
            rs.getString("description"),
            rs.getInt("price"),
            rs.getInt("stock"),
            eventBadge
        );
    }
}
