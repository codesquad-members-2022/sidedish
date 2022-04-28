package kr.codesquad.sidedish.repository;

import kr.codesquad.sidedish.domain.DishType;
import kr.codesquad.sidedish.domain.Product;
import kr.codesquad.sidedish.domain.SideDishType;
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
        DishType mainDishType = DishType.MAIN;
        DishType soupDishType = DishType.SOUP;
        DishType sideDishType = DishType.SIDE;
        // when
        List<Product> mainDishProducts = productRepository.loadDishListByType(mainDishType.getName());
        List<Product> soupDishProducts = productRepository.loadDishListByType(soupDishType.getName());
        List<Product> sideDishProducts = productRepository.loadDishListByType(sideDishType.getName());
        // then
        assertThat(mainDishProducts).allSatisfy(product ->
                assertThat(product.getDishType()).isEqualTo(mainDishType.getName())
        );
        assertThat(soupDishProducts).allSatisfy(product ->
                assertThat(product.getDishType()).isEqualTo(soupDishType.getName())
        );
        assertThat(sideDishProducts).allSatisfy(product ->
                assertThat(product.getDishType()).isEqualTo(sideDishType.getName())
        );
    }

    @Test
    @DisplayName("반찬 카테고리 조회 시 side_dish_type이 각각의 카테고리에 맞는 요리만 조회되어야 한다.")
    void loadSideDishListByType_test() {
        // given
        DishType dishType = DishType.SIDE;
        SideDishType meatSideDishType = SideDishType.MEAT;
        SideDishType convenienceSideDishType = SideDishType.CONVENIENCE;
        SideDishType seasonSideDishType = SideDishType.SEASON;
        SideDishType nutritionSideDishType = SideDishType.NUTRITION;
        // when
        List<Product> meatSideDishProducts = productRepository.loadSideDishListByType(dishType.getName(), meatSideDishType.getName());
        List<Product> convenienceSideDishProducts = productRepository.loadSideDishListByType(
	        dishType.getName(), convenienceSideDishType.getName());
        List<Product> seasonSideDishProducts = productRepository.loadSideDishListByType(dishType.getName(), seasonSideDishType.getName());
        List<Product> nutritionSideDishProducts = productRepository.loadSideDishListByType(dishType.getName(), nutritionSideDishType.getName());
        // then
        assertThat(meatSideDishProducts).allSatisfy(product ->
                assertThat(product.getSidedishType()).isEqualTo(meatSideDishType.getName())
        );
        assertThat(convenienceSideDishProducts).allSatisfy(product ->
                assertThat(product.getSidedishType()).isEqualTo(convenienceSideDishType.getName())
        );
        assertThat(seasonSideDishProducts).allSatisfy(product ->
                assertThat(product.getSidedishType()).isEqualTo(seasonSideDishType.getName())
        );
        assertThat(nutritionSideDishProducts).allSatisfy(product ->
                assertThat(product.getSidedishType()).isEqualTo(nutritionSideDishType.getName())
        );
    }
}
