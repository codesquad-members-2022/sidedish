package com.codesquad.sidedish.dish;

import com.codesquad.sidedish.dish.domain.Dish;
import com.codesquad.sidedish.dish.domain.DishImage;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class DishRowMapper implements RowMapper<Dish> {

    @Override
    public Dish mapRow(ResultSet rs, int rowNum) throws SQLException {
        Dish dish = new Dish(
            rs.getInt("dish_id"),
            rs.getString("title"),
            rs.getString("description"),
            rs.getInt("price"),
            rs.getInt("stock"),
            rs.getInt("category_id")
        );
        DishImage dishImage = new DishImage(
            rs.getInt("dish_image_id"),
            rs.getString("image_path"),
            null
        );

        if (rs.getInt("dish_image_id") != 0) {
            dish.setDishImage(dishImage);
        }
        return dish;
    }
}
