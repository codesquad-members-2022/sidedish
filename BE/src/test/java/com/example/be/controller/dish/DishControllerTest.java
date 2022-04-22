package com.example.be.controller.dish;

import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.be.controller.dish.dto.PlanningDataRequest;
import com.example.be.domain.dish.Badge;
import com.example.be.domain.dish.DeliveryType;
import com.example.be.domain.dish.DishStatus;
import com.example.be.service.dish.DishService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

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

	@Test
	void getPlanningDataTest() throws Exception {
		List<PlanningDataRequest> dishes = createTestData();

		given(dishService.getPlanningData())
			.willReturn(dishes);

		ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get("/api/dishes"));

		result
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON))
			.andDo(document("sidedish",
				responseFields(
					fieldWithPath("[].title").description("title 제목 작성"),
					fieldWithPath("[].description").description("description 본문 작성").optional(),
					fieldWithPath("[].dishId").description("1"),
					fieldWithPath("[].name").description("이름"),
					fieldWithPath("[].normalPrice").description("10000"),
					fieldWithPath("[].salePrice").description("9000"),
					fieldWithPath("[].badge").description("NONE"),
					fieldWithPath("[].deliveryType").description("NONE"),
					fieldWithPath("[].thumbnail").description("naver.com"),
					fieldWithPath("[].dishStatus").description("OUT_OF_STOCK"),
					fieldWithPath("[].categoryId").description("1")
				)
			));

	}

	private List<PlanningDataRequest> createTestData() {
		List<PlanningDataRequest> dishes = new ArrayList<>();
		dishes.add(0,
			new PlanningDataRequest(1L, "이름", "설명", new BigDecimal(10000), new BigDecimal(9000),
				Badge.NONE, DeliveryType.NONE, "naver.com", DishStatus.OUT_OT_STOCK, 1L,
				"타이틀"));
		dishes.add(1,
			new PlanningDataRequest(2L, "이름2", "설명2", new BigDecimal(100002), new BigDecimal(90002),
				Badge.NONE, DeliveryType.NONE, "naver.com222", DishStatus.OUT_OT_STOCK, 2L,
				"타이틀2"));


		return dishes;
	}
}
