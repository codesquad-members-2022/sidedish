package kr.codesquad.sidedish.service;

import kr.codesquad.sidedish.domain.DishType;
import kr.codesquad.sidedish.domain.Product;
import kr.codesquad.sidedish.domain.SideDishType;
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
		DishType mainDishType = DishType.MAIN;
		when(productRepository.loadDishListByType(mainDishType.getType())).thenReturn(
			getStubMainDishProducts());

		DishType soupDishType = DishType.SOUP;
		when(productRepository.loadDishListByType(soupDishType.getType())).thenReturn(
			getStubSoupDishProducts());

		DishType sideDishType = DishType.SIDE;
		when(productRepository.loadDishListByType(sideDishType.getType())).thenReturn(
			getStubSideDishProducts());

		// when
		List<ProductDTO> mainDishProductDTOS = productService.loadDishListByType(mainDishType);
		List<ProductDTO> soupDishProductDTOS = productService.loadDishListByType(soupDishType);
		List<ProductDTO> sideDishProductDTOS = productService.loadDishListByType(sideDishType);

		// then
		assertThat(mainDishProductDTOS).allSatisfy(product ->
			assertThat(product.getDishType()).isEqualTo(mainDishType.getType())
		);
		assertThat(soupDishProductDTOS).allSatisfy(product ->
			assertThat(product.getDishType()).isEqualTo(soupDishType.getType())
		);
		assertThat(sideDishProductDTOS).allSatisfy(product ->
			assertThat(product.getDishType()).isEqualTo(sideDishType.getType())
		);
	}

	@Test
	@DisplayName("요리 카테고리가 '반찬'이 아닌 경우, 반찬 카테고리를 추가로 입력하여 조회할 경우 SIDE_DISH_ONLY_ALLOWED 예외가 발생한다.")
	void loadSideDishListByType_test1() {
		// given
		DishType mainDishType = DishType.MAIN;
		SideDishType meatSideDishType = SideDishType.MEAT;

		// when

		// then
		assertThatThrownBy(() -> productService.loadSideDishListByType(mainDishType,
			meatSideDishType))
			.isInstanceOf(CustomException.class)
			.hasMessageContaining(ErrorCode.SIDE_DISH_ONLY_ALLOWED.getDetail());
	}

	@Test
	@DisplayName("반찬 카테고리 조회 시 side_dish_type이 각각의 카테고리에 맞는 요리만 조회되어야 한다.")
	void loadSideDishListByType_test2() {
		// given
		DishType dishType = DishType.SIDE;

		SideDishType meatSideDishType = SideDishType.MEAT;
		when(productRepository.loadSideDishListByType(dishType.getType(),
			meatSideDishType.getType())).thenReturn(getStubMeatSideDishProducts());

		SideDishType convenienceSideDishType = SideDishType.CONVENIENCE;
		when(productRepository.loadSideDishListByType(dishType.getType(),
			convenienceSideDishType.getType())).thenReturn(getStubConvenienceSideDishProducts());

		SideDishType seasonSideDishType = SideDishType.SEASON;
		when(productRepository.loadSideDishListByType(dishType.getType(),
			seasonSideDishType.getType())).thenReturn(getStubSeasonSideDishProducts());

		SideDishType nutritionSideDishType = SideDishType.NUTRITION;
		when(productRepository.loadSideDishListByType(dishType.getType(),
			nutritionSideDishType.getType())).thenReturn(getStubNutritionSideDishProducts());

		// when
		List<ProductDTO> meatSideDishProductDTOS = productService.loadSideDishListByType(dishType,
			meatSideDishType);
		List<ProductDTO> convenienceSideDishProductDTOS = productService.loadSideDishListByType(
			dishType, convenienceSideDishType);
		List<ProductDTO> seasonSideDishProductDTOS = productService.loadSideDishListByType(dishType,
			seasonSideDishType);
		List<ProductDTO> nutritionSideDishProductDTOS = productService.loadSideDishListByType(
			dishType,
			nutritionSideDishType);

		// then
		assertThat(meatSideDishProductDTOS).allSatisfy(product ->
			assertThat(product.getSideDishType()).isEqualTo(meatSideDishType.getType())
		);
		assertThat(convenienceSideDishProductDTOS).allSatisfy(product ->
			assertThat(product.getSideDishType()).isEqualTo(convenienceSideDishType.getType())
		);
		assertThat(seasonSideDishProductDTOS).allSatisfy(product ->
			assertThat(product.getSideDishType()).isEqualTo(seasonSideDishType.getType())
		);
		assertThat(nutritionSideDishProductDTOS).allSatisfy(product ->
			assertThat(product.getSideDishType()).isEqualTo(nutritionSideDishType.getType())
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
		List<Product> meatSideDishProducts = productRepository.loadSideDishListByType(
			dishType.getType(), meatSideDishType.getType());
		List<Product> convenienceSideDishProducts = productRepository.loadSideDishListByType(
			dishType.getType(), convenienceSideDishType.getType());
		List<Product> seasonSideDishProducts = productRepository.loadSideDishListByType(
			dishType.getType(), seasonSideDishType.getType());
		List<Product> nutritionSideDishProducts = productRepository.loadSideDishListByType(
			dishType.getType(), nutritionSideDishType.getType());
		// then
		assertThat(meatSideDishProducts).allSatisfy(product ->
			assertThat(product.getSidedishType()).isEqualTo(meatSideDishType.getType())
		);
		assertThat(convenienceSideDishProducts).allSatisfy(product ->
			assertThat(product.getSidedishType()).isEqualTo(convenienceSideDishType.getType())
		);
		assertThat(seasonSideDishProducts).allSatisfy(product ->
			assertThat(product.getSidedishType()).isEqualTo(seasonSideDishType.getType())
		);
		assertThat(nutritionSideDishProducts).allSatisfy(product ->
			assertThat(product.getSidedishType()).isEqualTo(nutritionSideDishType.getType())
		);
	}

	private List<Product> getStubMainDishProducts() {
		List<Product> products = Arrays.asList(
			new Product(1, "오리 주물럭_반조리1", "감칠맛 나는 매콤한 양념1", 15800, 100, "메인", null, "런칭특가",
				"http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg", 1),
			new Product(2, "오리 주물럭_반조리2", "감칠맛 나는 매콤한 양념2", 15800, 100, "메인", null, "런칭특가",
				"http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg", 2),
			new Product(3, "오리 주물럭_반조리3", "감칠맛 나는 매콤한 양념3", 15800, 100, "메인", null, "런칭특가",
				"http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg", 3),
			new Product(4, "오리 주물럭_반조리4", "감칠맛 나는 매콤한 양념4", 15800, 100, "메인", null, "런칭특가",
				"http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg", 2)
		);
		return products;
	}

	private List<Product> getStubSoupDishProducts() {
		List<Product> products = Arrays.asList(
			new Product(1, "오리 주물럭_반조리1", "감칠맛 나는 매콤한 양념1", 15800, 100, "국물", null, "런칭특가",
				"http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg", 2),
			new Product(2, "오리 주물럭_반조리2", "감칠맛 나는 매콤한 양념2", 15800, 100, "국물", null, "런칭특가",
				"http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg", 1),
			new Product(3, "오리 주물럭_반조리3", "감칠맛 나는 매콤한 양념3", 15800, 100, "국물", null, "런칭특가",
				"http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg", 3),
			new Product(4, "오리 주물럭_반조리4", "감칠맛 나는 매콤한 양념4", 15800, 100, "국물", null, "런칭특가",
				"http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg", 1)
		);
		return products;
	}

	private List<Product> getStubSideDishProducts() {
		List<Product> products = Arrays.asList(
			new Product(1, "오리 주물럭_반조리1", "감칠맛 나는 매콤한 양념1", 15800, 100, "반찬", "고기", "런칭특가",
				"http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg", 2),
			new Product(2, "오리 주물럭_반조리2", "감칠맛 나는 매콤한 양념2", 15800, 100, "반찬", "고기", "런칭특가",
				"http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg", 1),
			new Product(3, "오리 주물럭_반조리3", "감칠맛 나는 매콤한 양념3", 15800, 100, "반찬", "영양", "런칭특가",
				"http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg", 3),
			new Product(4, "오리 주물럭_반조리4", "감칠맛 나는 매콤한 양념4", 15800, 100, "반찬", "영양", "런칭특가",
				"http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg", 2),
			new Product(5, "오리 주물럭_반조리5", "감칠맛 나는 매콤한 양념5", 15800, 100, "반찬", "편리", "런칭특가",
				"http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg", 1),
			new Product(6, "오리 주물럭_반조리6", "감칠맛 나는 매콤한 양념6", 15800, 100, "반찬", "편리", "런칭특가",
				"http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg", 2),
			new Product(7, "오리 주물럭_반조리7", "감칠맛 나는 매콤한 양념7", 15800, 100, "반찬", "제철", "런칭특가",
				"http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg", 1),
			new Product(8, "오리 주물럭_반조리8", "감칠맛 나는 매콤한 양념8", 15800, 100, "반찬", "제철", "런칭특가",
				"http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg", 2)
		);
		return products;
	}

	private List<Product> getStubMeatSideDishProducts() {
		List<Product> products = Arrays.asList(
			new Product(1, "오리 주물럭_반조리1", "감칠맛 나는 매콤한 양념1", 15800, 100, "반찬", "고기", "런칭특가",
				"http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg", 2),
			new Product(2, "오리 주물럭_반조리2", "감칠맛 나는 매콤한 양념2", 15800, 100, "반찬", "고기", "런칭특가",
				"http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg", 2)
		);
		return products;
	}

	private List<Product> getStubNutritionSideDishProducts() {
		List<Product> products = Arrays.asList(
			new Product(3, "오리 주물럭_반조리3", "감칠맛 나는 매콤한 양념3", 15800, 100, "반찬", "영양", "런칭특가",
				"http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg", 2),
			new Product(4, "오리 주물럭_반조리4", "감칠맛 나는 매콤한 양념4", 15800, 100, "반찬", "영양", "런칭특가",
				"http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg", 2)
		);
		return products;
	}

	private List<Product> getStubConvenienceSideDishProducts() {
		List<Product> products = Arrays.asList(
			new Product(5, "오리 주물럭_반조리5", "감칠맛 나는 매콤한 양념5", 15800, 100, "반찬", "편리", "런칭특가",
				"http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg", 2),
			new Product(6, "오리 주물럭_반조리6", "감칠맛 나는 매콤한 양념6", 15800, 100, "반찬", "편리", "런칭특가",
				"http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg", 2)
		);
		return products;
	}

	private List<Product> getStubSeasonSideDishProducts() {
		List<Product> products = Arrays.asList(
			new Product(7, "오리 주물럭_반조리7", "감칠맛 나는 매콤한 양념7", 15800, 100, "반찬", "제철", "런칭특가",
				"http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg", 2),
			new Product(8, "오리 주물럭_반조리8", "감칠맛 나는 매콤한 양념8", 15800, 100, "반찬", "제철", "런칭특가",
				"http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg", 2)
		);
		return products;
	}
}
