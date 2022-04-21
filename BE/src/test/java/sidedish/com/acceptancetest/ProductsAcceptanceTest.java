package sidedish.com.acceptancetest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

/**
 * 인수테스트 1 : 프로튼엔드가 특정 음식 타입 조회를 하게 해주세요
 * <p>
 * 성공 1 GET /api/products?meal={value} 일 때
 * <p>
 * Response - 200 OK - JSON return
 * <p>
 * 실패 1 : 유효하지 않은 value
 * <p>
 * Response - 400 BadRequest - JSON 리턴
 * <p>
 * 실패 2 : meal=value가 없는 경우
 * <p>
 * Response - 400 BadRequest - JSON 리턴
 */

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
			.body("[0].fixedPrice", equalTo(7440))
			.body("[0].originalPrice", equalTo(9300))
			.body("[0].event", equalTo("이벤트특가"));
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
}
