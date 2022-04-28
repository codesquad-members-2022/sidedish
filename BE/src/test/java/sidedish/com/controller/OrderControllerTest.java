package sidedish.com.controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Collections;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import sidedish.com.controller.model.OrderSaveResponse;
import sidedish.com.service.OrderService;

@WebMvcTest(OrderController.class)
@DisplayName("OrderController 클래스")
class OrderControllerTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	OrderService orderService;

	@Test
	void 만약_특정_상품_id로_주문_요청을_하는_경우_재고가_남아있다면_주문_성공() throws Exception {
		given(orderService.save(1L, 3))
			.willReturn(new OrderSaveResponse(1L));

		ObjectMapper objectMapper = new ObjectMapper();

		ResultActions perform = mockMvc.perform(
			post("/api/products/1/order")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(Collections.singletonMap("count", 3))));

		perform
			.andExpect(status().isCreated())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}
}
