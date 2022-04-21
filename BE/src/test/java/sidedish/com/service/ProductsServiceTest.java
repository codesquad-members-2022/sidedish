package sidedish.com.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sidedish.com.controller.model.ProductMealTypeResponse;
import sidedish.com.domain.Image;
import sidedish.com.domain.Product;
import sidedish.com.repository.ProductsRepository;

@DisplayName("ProductsServiceTest 클래스")
class ProductsServiceTest {

	private ProductsService productsService;
	private ProductsRepository productsRepository;

	@BeforeEach
	void setUp() {
		productsRepository = mock(ProductsRepository.class);
		productsService = new ProductsService(productsRepository);
	}

	@Test
	void 만약_meal_type이_soup인_경우_soup음식_타입_조회_성공() throws Exception {
		given(productsRepository.findByMealType("soup"))
			.willReturn(createListProducts());

		List<ProductMealTypeResponse> result = productsService.findByMealType("soup");

		assertThat(result.size()).isEqualTo(2);
	}

	private List<Product> createListProducts() {
		List<Product> products = new ArrayList<>();

		products.add(
			new Product(5L, 1L, List.of(new Image("http://kukukukukukukukuku.com/test.jpg")),
				"한돈 돼지 김치찌개", "김치찌개에는 역시 돼지고기", 8370, "soup", "meat"));
		products.add(
			new Product(6L, 2L, List.of(new Image("http://kukukukukukukukuku.com/test2.jpg")),
				"하하하 테스트 음식", "맛있어요", 8370, "main", "soup"));

		return products;
	}
}
