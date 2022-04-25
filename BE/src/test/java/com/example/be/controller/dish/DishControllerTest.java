package com.example.be.controller.dish;

import com.example.be.domain.category.Category;
import com.example.be.domain.category.SubCategory;
import com.example.be.domain.dish.Badge;
import com.example.be.domain.dish.DeliveryPriceOption;
import com.example.be.domain.dish.Dish;
import com.example.be.domain.dish.DishStatus;
import com.example.be.service.dish.DishService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.example.be.domain.category.Country.KOREA;

@AutoConfigureMockMvc
@AutoConfigureRestDocs
@ExtendWith(RestDocumentationExtension.class)
@WebMvcTest(DishController.class)
@DisplayName("API /api/dishes/* 컨트롤러 계층 단위 테스트")
class DishControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DishService dishService;

//	@BeforeEach
//	public void setUp(WebApplicationContext webApplicationContext,
//		RestDocumentationContextProvider restDocumentation) {
//		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
//			.apply(documentationConfiguration(restDocumentation))
//			.build();
//	}

    private Category category;

    private List<Dish> dishes;
    private List<SubCategory> subCategories;

    private List<Dish> getDishes() {
        List<Dish> dishes = new ArrayList<>();
        Dish dishA = new Dish("한식", "한국 전통음식", new BigDecimal(30000L), Badge.EVENT, DeliveryPriceOption.FREE, "www.naver.com", DishStatus.IN_STOCK, 10, 1L, null);
        Dish dishB = new Dish("일식", "일본 전통음식", new BigDecimal(20000L), Badge.EVENT, DeliveryPriceOption.FREE, "www.naver.com", DishStatus.IN_STOCK, 10, 1L, null);
        dishes.add(dishA);
        dishes.add(dishB);
        return dishes;
    }

    private List<SubCategory> getSubCategories() {
        List<SubCategory> subCategories = new ArrayList<>();
        SubCategory subCategoryA = new SubCategory("", KOREA);
        SubCategory subCategoryB = new SubCategory("", KOREA);
        subCategories.add(subCategoryA);
        subCategories.add(subCategoryB);
        return subCategories;
    }

    private Category getCategory() {
        List<Dish> dishes = getDishes();
        List<SubCategory> subCategories = getSubCategories();
        return new Category("한국 전통음식입니다.", subCategories);
    }

    @Test
    @DisplayName("")
    void m() throws Exception {

    }

    @Test
    void getPlanningDataTest() throws Exception {
//		List<PlanningDataRequest> dishes = createTestData();
//
//		given(dishService.getPlanningData())
//			.willReturn(dishes);
//
//		ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get("/api/dishes"));
//
//		result
//			.andExpect(status().isOk())
//			.andExpect(content().contentType(MediaType.APPLICATION_JSON))
//			.andDo(document("sidedish",
//				responseFields(
//					fieldWithPath("[].title").description("title 제목 작성"),
//					fieldWithPath("[].description").description("description 본문 작성").optional(),
//					fieldWithPath("[].dishId").description("1"),
//					fieldWithPath("[].name").description("이름"),
//					fieldWithPath("[].normalPrice").description("10000"),
//					fieldWithPath("[].salePrice").description("9000"),
//					fieldWithPath("[].badge").description("NONE"),
//					fieldWithPath("[].deliveryType").description("NONE"),
//					fieldWithPath("[].thumbnail").description("naver.com"),
//					fieldWithPath("[].dishStatus").description("OUT_OF_STOCK"),
//					fieldWithPath("[].categoryId").description("1")
//				)
//			));

    }

//	private List<PlanningDataRequest> createTestData() {
////		List<PlanningDataRequest> dishes = new ArrayList<>();
////		dishes.add(0,
////			new PlanningDataRequest(1L, "이름", "설명", new BigDecimal(10000), new BigDecimal(9000),
////				Badge.NONE, DeliveryType.NONE, "naver.com", DishStatus.OUT_OF_STOCK, 1L,
////				"타이틀"));
////		dishes.add(1,
////			new PlanningDataRequest(2L, "이름2", "설명2", new BigDecimal(100002), new BigDecimal(90002),
////				Badge.NONE, DeliveryType.NONE, "naver.com222", DishStatus.OUT_OF_STOCK, 2L,
////				"타이틀2"));
//
//
//		return dishes;
//	}
}
