package sidedish.com.acceptancetest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DisplayName("Product 인수테스트")
class ProductsAcceptanceTest {

	@LocalServerPort
	int port;

	@BeforeEach
	void setUp() {
		RestAssured.port = port;
	}


	@Test
	void 만약_meal_type이_soup인_경우_soup음식_타입_조회_성공() {
		given()
			.accept(MediaType.APPLICATION_JSON_VALUE)

			.when()
			.get("/api/products?meal=soup")

			.then()
			.statusCode(HttpStatus.OK.value())
			.assertThat()
			.body("[0].id", equalTo(5))
			.body("[0].image", containsString("s3"))
			.body("[0].productName", equalTo("한돈 돼지 김치찌개"))
			.body("[0].description", equalTo("김치찌개에는 역시 돼지고기"))
			.body("[0].event", equalTo("이벤트특가"))
			.body("[0].fixedPrice", equalTo(7440))
			.body("[0].originalPrice", equalTo(9300))
			.body("[3].productName", equalTo("동태찌개"))
			.body("[3].originalPrice", equalTo(12000))
			.body("[3].fixedPrice", equalTo(12000));
	}

	@Test
	void 만약_meal_type이_유효하지_않은_경우_음식_타입_조회_실패() {
		given()
			.accept(MediaType.APPLICATION_JSON_VALUE)

		.when()
			.get("/api/products?meal=WrongType")

		.then()
			.statusCode(HttpStatus.NOT_FOUND.value());
	}

	@Test
	void 만약_유효한_product_id가_주어졌을때_음식_상세조회_성공() {
		given()
			.accept(MediaType.APPLICATION_JSON_VALUE)

		.when()
			.get("api/products/5")

		.then()
			.statusCode(HttpStatus.OK.value())
			.body("id", equalTo(5))
			.body("images", hasSize(1))
			.body("productName", equalTo("한돈 돼지 김치찌개"))
			.body("description", equalTo("김치찌개에는 역시 돼지고기"))
			.body("event", equalTo("이벤트특가"))
			.body("fixedPrice", equalTo(7440))
			.body("originalPrice", equalTo(9300))
			.body("mileage", equalTo(74))
			.body("deliveryInfo", equalTo("서울 경기 새벽 배송, 전국 택배 배송"))
			.body("deliveryCharge", equalTo(2500))
			.body("freeDeliveryOverAmount", equalTo(40000));

	}

	@Test
	void 만약_유요하지않은_product_id가_주어졌을때_음식_상세조회_실패() {
		given()
			.accept(MediaType.APPLICATION_JSON_VALUE)

			.when()
			.get("api/products/-1")

			.then()
			.statusCode(HttpStatus.NOT_FOUND.value());
	}

	@Test
	void 만약_유요한_product_id지만_해당_id음식_존재하지_않는경우_상세조회_실패() {
		given()
			.accept(MediaType.APPLICATION_JSON_VALUE)

			.when()
			.get("api/products/999999")

			.then()
			.statusCode(HttpStatus.NOT_FOUND.value());
	}

}
