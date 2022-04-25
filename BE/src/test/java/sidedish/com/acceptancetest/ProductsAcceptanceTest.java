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

	@Test
	void 만약_category가_meat인_경우_best_category가_meat인_음식_조회_성공() {
		given()
			.accept(MediaType.APPLICATION_JSON_VALUE)

			.when()
			.get("/api/products/best?category=meat")

			.then()
			.statusCode(HttpStatus.OK.value())
			.assertThat()
			.body("[0].id", equalTo(1))
			.body("[0].image", containsString("s3"))
			.body("[0].productName", equalTo("오리주물럭"))
			.body("[0].description", equalTo("감칠맛 나는 매콤한 양념"))
			.body("[0].event", equalTo("런칭특가"))
			.body("[0].fixedPrice", equalTo(14220))
			.body("[0].originalPrice", equalTo(15800))
			.body("[1].id", equalTo(3))
			.body("[1].image", containsString("s3"))
			.body("[1].productName", equalTo("소갈비찜"))
			.body("[1].description", equalTo("촉촉하게 밴 양념이 일품"))
			.body("[1].event", equalTo("이벤트특가"))
			.body("[1].fixedPrice", equalTo(23120))
			.body("[1].originalPrice", equalTo(28900))
			.body("[2].id", equalTo(5))
			.body("[2].image", containsString("s3"))
			.body("[2].productName", equalTo("한돈 돼지 김치찌개"))
			.body("[2].description", equalTo("김치찌개에는 역시 돼지고기"))
			.body("[2].event", equalTo("이벤트특가"))
			.body("[2].fixedPrice", equalTo(7440))
			.body("[2].originalPrice", equalTo(9300));
	}

	@Test
	void 만약_파라미터인_category를_입력하지_않은_경우_베스트_카테고리_음식_조회_실패() {
		given()
			.accept(MediaType.APPLICATION_JSON_VALUE)

			.when()
			.get("/api/products/best")

			.then()
			.statusCode(HttpStatus.BAD_REQUEST.value());
	}

	@Test
	void 만약_category의_값이_유효하지_않는_경우_조회_실패() {
		given()
			.accept(MediaType.APPLICATION_JSON_VALUE)

			.when()
			.get("/api/products/best?category=abc")

			.then()
			.statusCode(HttpStatus.NOT_FOUND.value());
	}
}
