package kr.codesquad.sidedish.repository;

import kr.codesquad.sidedish.domain.Dish;
import kr.codesquad.sidedish.domain.Product;
import kr.codesquad.sidedish.domain.SideDish;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJdbcTest
class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    @DisplayName("요리 카테고리 조회 시 dish_type이 각각의 카테고리에 맞는 요리만 조회되어야 한다.")
    void loadDishListByType_test() {
        // given
        Dish mainDish = Dish.MAIN;
        Dish soupDish = Dish.SOUP;
        Dish sideDish = Dish.SIDE;
        // when
        List<Product> mainDishProducts = productRepository.loadDishListByType(mainDish.getType());
        List<Product> soupDishProducts = productRepository.loadDishListByType(soupDish.getType());
        List<Product> sideDishProducts = productRepository.loadDishListByType(sideDish.getType());
        // then
        assertThat(mainDishProducts).allSatisfy(product ->
                assertThat(product.getDishType()).isEqualTo(mainDish.getType())
        );
        assertThat(soupDishProducts).allSatisfy(product ->
                assertThat(product.getDishType()).isEqualTo(soupDish.getType())
        );
        assertThat(sideDishProducts).allSatisfy(product ->
                assertThat(product.getDishType()).isEqualTo(sideDish.getType())
        );
    }

    @Test
    @DisplayName("반찬 카테고리 조회 시 side_dish_type이 각각의 카테고리에 맞는 요리만 조회되어야 한다.")
    void loadSideDishListByType_test() {
        // given
        Dish dish = Dish.SIDE;
        SideDish meatSideDish = SideDish.MEAT;
        SideDish convenienceSideDish = SideDish.CONVENIENCE;
        SideDish seasonSideDish = SideDish.SEASON;
        SideDish nutritionSideDish = SideDish.NUTRITION;
        // when
        List<Product> meatSideDishProducts = productRepository.loadSideDishListByType(dish.getType(), meatSideDish.getType());
        List<Product> convenienceSideDishProducts = productRepository.loadSideDishListByType(dish.getType(), convenienceSideDish.getType());
        List<Product> seasonSideDishProducts = productRepository.loadSideDishListByType(dish.getType(), seasonSideDish.getType());
        List<Product> nutritionSideDishProducts = productRepository.loadSideDishListByType(dish.getType(), nutritionSideDish.getType());
        // then
        assertThat(meatSideDishProducts).allSatisfy(product ->
                assertThat(product.getSideDishType()).isEqualTo(meatSideDish.getType())
        );
        assertThat(convenienceSideDishProducts).allSatisfy(product ->
                assertThat(product.getSideDishType()).isEqualTo(convenienceSideDish.getType())
        );
        assertThat(seasonSideDishProducts).allSatisfy(product ->
                assertThat(product.getSideDishType()).isEqualTo(seasonSideDish.getType())
        );
        assertThat(nutritionSideDishProducts).allSatisfy(product ->
                assertThat(product.getSideDishType()).isEqualTo(nutritionSideDish.getType())
        );
    }
}
