package sidedish.com.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import sidedish.com.domain.Product;

@DataJdbcTest
@DisplayName("ProductsRepository 클래스")
class ProductsRepositoryTest  {

	@Autowired
	private ProductsRepository productsRepository;

	@BeforeEach
	@Sql({"/testdb/schema.sql", "/testdb/data.sql"})
	void setUp() {

	}

	@Nested
	@DisplayName("findByMealType(String meal) 메서드")
	class Describe_findByMealType {

	    @Nested
	    @DisplayName("만약 meal 타입이 유효한 soup으로 주어진다면")
	    class Context_with_meal_type_is_soup {

	        @Test
	        @DisplayName("meal 타입이 soup인 모든 Product의 리스트를 반환한다")
	        void It_returns_products_type_soup() {
				List<Product> result = productsRepository.findByMealType("soup");

				assertThat(result.get(0).getMealCategory()).isEqualTo("soup");
	        }
	    }

		@Nested
		@DisplayName("만약 meal이 유효한 main으로 주어진다면")
		class Context_with_meal_type_is_main {

			@Test
			@DisplayName("meal 타입이 main인 모든 Product의 리스트를 반환한다")
			void It_returns_products_type_main() {
				List<Product> result = productsRepository.findByMealType("main");

				assertThat(result.get(0).getMealCategory()).isEqualTo("main");
			}
		}

		@Nested
		@DisplayName("만약 meal이 유효한 side으로 주어진다면")
		class Context_with_meal_type_is_side {

			@Test
			@DisplayName("meal 타입이 side인 모든 Product의 리스트를 반환한다")
			void It_returns_products_type_side() {
				List<Product> result = productsRepository.findByMealType("side");

				assertThat(result.get(0).getMealCategory()).isEqualTo("side");
			}
		}

		@Nested
		@DisplayName("만약 meal이 유효하지 않은 값으로 주어진다면")
		class Context_with_meal_type_error {

			@Test
			@DisplayName("빈 리스트를 반환한다.")
			void It_returns_products_type_side() {
				List<Product> result = productsRepository.findByMealType("error Meal Type");

				assertThat(result).isEmpty();
			}
		}
	}

}
