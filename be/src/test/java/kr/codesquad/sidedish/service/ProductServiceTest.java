package kr.codesquad.sidedish.service;

import kr.codesquad.sidedish.domain.Dish;
import kr.codesquad.sidedish.domain.Product;
import kr.codesquad.sidedish.domain.SideDish;
import kr.codesquad.sidedish.exception.CustomException;
import kr.codesquad.sidedish.repository.ProductRepository;
import kr.codesquad.sidedish.response.ErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    @DisplayName("service_요리 카테고리 조회 시 dish_type이 각각의 카테고리에 맞는 요리만 조회되어야 한다.")
    void loadDishListByType_test() {
        // given
        Dish mainDish = Dish.MAIN;
        when(productRepository.loadDishListByType(mainDish.getType())).thenReturn(getStubMainDishProducts());

        Dish soupDish = Dish.SOUP;
        when(productRepository.loadDishListByType(soupDish.getType())).thenReturn(getStubSoupDishProducts());

        Dish sideDish = Dish.SIDE;
        when(productRepository.loadDishListByType(sideDish.getType())).thenReturn(getStubSideDishProducts());

        // when
        List<ProductDTO> mainDishProductDTOS = productService.loadDishListByType(mainDish);
        List<ProductDTO> soupDishProductDTOS = productService.loadDishListByType(soupDish);
        List<ProductDTO> sideDishProductDTOS = productService.loadDishListByType(sideDish);

        // then
        assertThat(mainDishProductDTOS).allSatisfy(product ->
                assertThat(product.getDishType()).isEqualTo(mainDish.getType())
        );
        assertThat(soupDishProductDTOS).allSatisfy(product ->
                assertThat(product.getDishType()).isEqualTo(soupDish.getType())
        );
        assertThat(sideDishProductDTOS).allSatisfy(product ->
                assertThat(product.getDishType()).isEqualTo(sideDish.getType())
        );
    }

    @Test
    @DisplayName("요리 카테고리가 '반찬'이 아닌 경우, 반찬 카테고리를 추가로 입력하여 조회할 경우 SIDE_DISH_ONLY_ALLOWED 예외가 발생한다.")
    void loadSideDishListByType_test1() {
        // given
        Dish mainDish = Dish.MAIN;
        SideDish meatSideDish = SideDish.MEAT;

        // when

        // then
        assertThatThrownBy(() -> productService.loadSideDishListByType(mainDish, meatSideDish))
                .isInstanceOf(CustomException.class)
                .hasMessageContaining(ErrorCode.SIDE_DISH_ONLY_ALLOWED.getDetail());
    }

    @Test
    @DisplayName("반찬 카테고리 조회 시 side_dish_type이 각각의 카테고리에 맞는 요리만 조회되어야 한다.")
    void loadSideDishListByType_test2() {
        // given
        Dish dish = Dish.SIDE;
        
        SideDish meatSideDish = SideDish.MEAT;
        when(productRepository.loadSideDishListByType(dish.getType(), meatSideDish.getType())).thenReturn(getStubMeatSideDishProducts());
        
        SideDish convenienceSideDish = SideDish.CONVENIENCE;
        when(productRepository.loadSideDishListByType(dish.getType(), convenienceSideDish.getType())).thenReturn(getStubConvenienceSideDishProducts());

        SideDish seasonSideDish = SideDish.SEASON;
        when(productRepository.loadSideDishListByType(dish.getType(), seasonSideDish.getType())).thenReturn(getStubSeasonSideDishProducts());

        SideDish nutritionSideDish = SideDish.NUTRITION;
        when(productRepository.loadSideDishListByType(dish.getType(), nutritionSideDish.getType())).thenReturn(getStubNutritionSideDishProducts());

        // when
        List<ProductDTO> meatSideDishProductDTOS = productService.loadSideDishListByType(dish, meatSideDish);
        List<ProductDTO> convenienceSideDishProductDTOS = productService.loadSideDishListByType(dish, convenienceSideDish);
        List<ProductDTO> seasonSideDishProductDTOS = productService.loadSideDishListByType(dish, seasonSideDish);
        List<ProductDTO> nutritionSideDishProductDTOS = productService.loadSideDishListByType(dish, nutritionSideDish);

        // then
        assertThat(meatSideDishProductDTOS).allSatisfy(product ->
                assertThat(product.getSideDishType()).isEqualTo(meatSideDish.getType())
        );
        assertThat(convenienceSideDishProductDTOS).allSatisfy(product ->
                assertThat(product.getSideDishType()).isEqualTo(convenienceSideDish.getType())
        );
        assertThat(seasonSideDishProductDTOS).allSatisfy(product ->
                assertThat(product.getSideDishType()).isEqualTo(seasonSideDish.getType())
        );
        assertThat(nutritionSideDishProductDTOS).allSatisfy(product ->
                assertThat(product.getSideDishType()).isEqualTo(nutritionSideDish.getType())
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

    private List<Product> getStubMainDishProducts() {
        List<Product> products = Arrays.asList(
                new Product(1, "오리 주물럭_반조리1", "감칠맛 나는 매콤한 양념1", 15800, 100, "메인", null, "런칭특가", "http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg"),
                new Product(2, "오리 주물럭_반조리2", "감칠맛 나는 매콤한 양념2", 15800, 100, "메인", null, "런칭특가", "http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg"),
                new Product(3, "오리 주물럭_반조리3", "감칠맛 나는 매콤한 양념3", 15800, 100, "메인", null, "런칭특가", "http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg"),
                new Product(4, "오리 주물럭_반조리4", "감칠맛 나는 매콤한 양념4", 15800, 100, "메인", null, "런칭특가", "http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg")
        );
        return products;
    }

    private List<Product> getStubSoupDishProducts() {
        List<Product> products = Arrays.asList(
                new Product(1, "오리 주물럭_반조리1", "감칠맛 나는 매콤한 양념1", 15800, 100, "국물", null, "런칭특가", "http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg"),
                new Product(2, "오리 주물럭_반조리2", "감칠맛 나는 매콤한 양념2", 15800, 100, "국물", null, "런칭특가", "http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg"),
                new Product(3, "오리 주물럭_반조리3", "감칠맛 나는 매콤한 양념3", 15800, 100, "국물", null, "런칭특가", "http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg"),
                new Product(4, "오리 주물럭_반조리4", "감칠맛 나는 매콤한 양념4", 15800, 100, "국물", null, "런칭특가", "http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg")
        );
        return products;
    }

    private List<Product> getStubSideDishProducts() {
        List<Product> products = Arrays.asList(
                new Product(1, "오리 주물럭_반조리1", "감칠맛 나는 매콤한 양념1", 15800, 100, "반찬", "고기", "런칭특가", "http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg"),
                new Product(2, "오리 주물럭_반조리2", "감칠맛 나는 매콤한 양념2", 15800, 100, "반찬", "고기", "런칭특가", "http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg"),
                new Product(3, "오리 주물럭_반조리3", "감칠맛 나는 매콤한 양념3", 15800, 100, "반찬", "영양", "런칭특가", "http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg"),
                new Product(4, "오리 주물럭_반조리4", "감칠맛 나는 매콤한 양념4", 15800, 100, "반찬", "영양", "런칭특가", "http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg"),
                new Product(5, "오리 주물럭_반조리5", "감칠맛 나는 매콤한 양념5", 15800, 100, "반찬", "편리", "런칭특가", "http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg"),
                new Product(6, "오리 주물럭_반조리6", "감칠맛 나는 매콤한 양념6", 15800, 100, "반찬", "편리", "런칭특가", "http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg"),
                new Product(7, "오리 주물럭_반조리7", "감칠맛 나는 매콤한 양념7", 15800, 100, "반찬", "제철", "런칭특가", "http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg"),
                new Product(8, "오리 주물럭_반조리8", "감칠맛 나는 매콤한 양념8", 15800, 100, "반찬", "제철", "런칭특가", "http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg")
        );
        return products;
    }

    private List<Product> getStubMeatSideDishProducts() {
        List<Product> products = Arrays.asList(
                new Product(1, "오리 주물럭_반조리1", "감칠맛 나는 매콤한 양념1", 15800, 100, "반찬", "고기", "런칭특가", "http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg"),
                new Product(2, "오리 주물럭_반조리2", "감칠맛 나는 매콤한 양념2", 15800, 100, "반찬", "고기", "런칭특가", "http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg")
        );
        return products;
    }

    private List<Product> getStubNutritionSideDishProducts() {
        List<Product> products = Arrays.asList(
                new Product(3, "오리 주물럭_반조리3", "감칠맛 나는 매콤한 양념3", 15800, 100, "반찬", "영양", "런칭특가", "http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg"),
                new Product(4, "오리 주물럭_반조리4", "감칠맛 나는 매콤한 양념4", 15800, 100, "반찬", "영양", "런칭특가", "http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg")
        );
        return products;
    }

    private List<Product> getStubConvenienceSideDishProducts() {
        List<Product> products = Arrays.asList(
                new Product(5, "오리 주물럭_반조리5", "감칠맛 나는 매콤한 양념5", 15800, 100, "반찬", "편리", "런칭특가", "http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg"),
                new Product(6, "오리 주물럭_반조리6", "감칠맛 나는 매콤한 양념6", 15800, 100, "반찬", "편리", "런칭특가", "http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg")
        );
        return products;
    }

    private List<Product> getStubSeasonSideDishProducts() {
        List<Product> products = Arrays.asList(
                new Product(7, "오리 주물럭_반조리7", "감칠맛 나는 매콤한 양념7", 15800, 100, "반찬", "제철", "런칭특가", "http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg"),
                new Product(8, "오리 주물럭_반조리8", "감칠맛 나는 매콤한 양념8", 15800, 100, "반찬", "제철", "런칭특가", "http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg")
        );
        return products;
    }
}
