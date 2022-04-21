package sidedish.com.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("ProductTest 클래스")
class ProductTest {


	@Nested
	@DisplayName("Product 생성자")
	class Describe_constructor {

	    @Nested
	    @DisplayName("만약 이벤트특가 Discount Policy가 주어진다면")
	    class Context_with_event_discount_policy {

	        @Test
	        @DisplayName("20% 할인된 Product를 생성한다.")
	        void It_returns_a_Product() {
				DiscountPolicy discountPolicy = new DiscountPolicy("이벤트특가", 20);
				Image image = new Image("https://louie.com/test.jpg");

				Product sut = new Product(1L, discountPolicy, List.of(image), "김치찌개", "맛있어요",
					10000, "soup", "meat");

				assertThat(sut.getDiscountPolicy().getPolicyName()).isEqualTo("이벤트특가");
				assertThat(sut.getFixedPrice()).isEqualTo(8000);
			}
	    }

		@Nested
		@DisplayName("만약 런칭특가 Discount Policy가 주어진다면")
		class Context_with_launching_discount_policy {

			@Test
			@DisplayName("10% 할인된 Product를 생성한다.")
			void It_returns_a_Product() {
				DiscountPolicy discountPolicy = new DiscountPolicy("런칭특가", 10);
				Image image = new Image("https://louie.com/test.jpg");

				Product sut = new Product(1L, discountPolicy, List.of(image), "김치찌개", "맛있어요",
					10000, "soup", "meat");

				assertThat(sut.getDiscountPolicy().getPolicyName()).isEqualTo("런칭특가");
				assertThat(sut.getFixedPrice()).isEqualTo(9000);
			}
		}
	}
}
