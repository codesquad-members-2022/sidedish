package sidedish.com.controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import sidedish.com.controller.model.ProductMealTypeResponse;
import sidedish.com.domain.DisCountPolicy;
import sidedish.com.domain.Image;
import sidedish.com.domain.Product;
import sidedish.com.service.ProductsService;

@WebMvcTest(ProductsController.class)
@DisplayName("ProductsControllerTest 클래스")
class ProductsControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ProductsService productsService;

	@Test
	void 만약_meal_type이_soup인_경우_soup음식_타입_조회_성공() throws Exception {
		given(productsService.findByMealType("soup"))
			.willReturn(createProductsMealTypeResponse());

		ResultActions perform = mockMvc.perform(get("/api/products?meal=soup"));

		perform
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}

	private List<ProductMealTypeResponse> createProductsMealTypeResponse() {
		List<Product> products = new ArrayList<>();

		products.add(new Product(5L, List.of(new Image("http://kukukukukukukukuku.com/test.jpg")),
			"한돈 돼지 김치찌개", "김치찌개에는 역시 돼지고기", 8370, 9300, new DisCountPolicy("이벤트특가")));
		products.add(new Product(6L, List.of(new Image("http://kukukukukukukukuku.com/test2.jpg")),
			"하하하 테스트 음식", "맛있어요", 8370, 9300, new DisCountPolicy("이벤트특가")));

		return ProductsDtoMapper.toProductsMealTypeResponseFromDomain(products);
	}
}
