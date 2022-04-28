package sidedish.com.acceptancetest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.RestAssured;
import net.minidev.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Sql({"/testdb/schema.sql", "/testdb/data.sql"})
@DisplayName("Order 인수테스트")
class OrderAcceptanceTest {

	@LocalServerPort
	int port;

	@BeforeEach
	void setUp() {
		RestAssured.port = port;
	}

	@Test
	void 재고가_충분할_경우_특정_상품_주문_성공() {
		JSONObject requestBody = new JSONObject();
		requestBody.put("count", "10");

		given()
			.accept(MediaType.APPLICATION_JSON_VALUE)
			.header("Content-type", "application/json")
			.body(requestBody)

		.when()
			.post("/api/products/1/order")

		.then()
			.statusCode(HttpStatus.CREATED.value())
			.assertThat()
			.body("id", equalTo(1));
	}

	@Test
	void 재고가_충분하지_않을_경우_특정_상품_주문_실패() {
		JSONObject requestBody = new JSONObject();
		requestBody.put("count", 1000);

		given()
			.accept(MediaType.APPLICATION_JSON_VALUE)
			.header("Content-type", "application/json")
			.body(requestBody)

		.when()
			.post("/api/products/1/order")

		.then()
			.statusCode(HttpStatus.BAD_REQUEST.value())
			.assertThat()
			.body("currentStockQuantity", equalTo(100));
	}
}
