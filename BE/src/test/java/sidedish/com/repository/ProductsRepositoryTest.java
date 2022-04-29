package sidedish.com.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.test.context.jdbc.Sql;
import sidedish.com.repository.entity.ProductEntity;

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
				List<ProductEntity> result = productsRepository.findByMealType("soup");

				assertThat(result.get(0).getMealCategory()).isEqualTo("soup");
	        }
	    }

		@Nested
		@DisplayName("만약 meal이 유효한 main으로 주어진다면")
		class Context_with_meal_type_is_main {

			@Test
			@DisplayName("meal 타입이 main인 모든 Product의 리스트를 반환한다")
			void It_returns_products_type_main() {
				List<ProductEntity> result = productsRepository.findByMealType("main");

				assertThat(result.get(0).getMealCategory()).isEqualTo("main");
			}
		}

		@Nested
		@DisplayName("만약 meal이 유효한 side으로 주어진다면")
		class Context_with_meal_type_is_side {

			@Test
			@DisplayName("meal 타입이 side인 모든 Product의 리스트를 반환한다")
			void It_returns_products_type_side() {
				List<ProductEntity> result = productsRepository.findByMealType("side");

				assertThat(result.get(0).getMealCategory()).isEqualTo("side");
			}
		}

		@Nested
		@DisplayName("만약 meal이 유효하지 않은 값으로 주어진다면")
		class Context_with_meal_type_error {

			@Test
			@DisplayName("빈 리스트를 반환한다.")
			void It_returns_products_type_side() {
				List<ProductEntity> result = productsRepository.findByMealType("error Meal Type");

				assertThat(result).isEmpty();
			}
		}
	}

	@Nested
	@DisplayName("findById 메서드")
	class Describe_findById {

	    @Nested
	    @DisplayName("만약 유효한 id가 주어진다면")
	    class Context_with_valid_id {

	        @Test
	        @DisplayName("Product 객체를 리턴한다")
	        void It_returns_product() {
				ProductEntity sut = productsRepository.findById(1L).get();

				assertThat(sut.getId()).isEqualTo(1);
				assertThat(sut.getDeliveryPolicyId()).isEqualTo(1);
			}
	    }
	}

	@Nested
	@DisplayName("findAllByBestCategory(String Category) 메서드")
	class Describe_findAllByBestCategory {

		@Nested
		@DisplayName("만약 category가 유효한 meat로 주어진다면")
		class Context_with__category_is_meat {

			@Test
			@DisplayName("category가 meat인 모든 Product의 List를 반환한다")
			void It_returns_products_best_category_meat() {
				List<ProductEntity> result = productsRepository.findAllByBestCategory("meat");
				ProductEntity sut = result.get(0);

				assertThat(result.size()).isEqualTo(3);
				assertThat(sut.getBestCategory()).isEqualTo("meat");
			}
		}

		@Nested
		@DisplayName("만약 category가 유효한 easy로 주어진다면")
		class Context_with__category_is_easy {

			@Test
			@DisplayName("category가 easy인 모든 Product의 List를 반환한다")
			void It_returns_products_best_category_easy() {
				List<ProductEntity> result = productsRepository.findAllByBestCategory("easy");
				ProductEntity sut = result.get(0);

				assertThat(result.size()).isEqualTo(3);
				assertThat(sut.getBestCategory()).isEqualTo("easy");
			}
		}

		@Nested
		@DisplayName("만약 category가 유효한 season으로 주어진다면")
		class Context_with__category_is_season {

			@Test
			@DisplayName("category가 season인 모든 Product의 List를 반환한다")
			void It_returns_products_best_category_season() {
				List<ProductEntity> result = productsRepository.findAllByBestCategory("season");
				ProductEntity sut = result.get(0);

				assertThat(result.size()).isEqualTo(2);
				assertThat(sut.getBestCategory()).isEqualTo("season");
			}
		}

		@Nested
		@DisplayName("만약 category가 유효한 kids으로 주어진다면")
		class Context_with__category_is_kids {

			@Test
			@DisplayName("category가 kids인 모든 Product의 List를 반환한다")
			void It_returns_products_best_category_kids() {
				List<ProductEntity> result = productsRepository.findAllByBestCategory("kids");
				ProductEntity sut = result.get(0);

				assertThat(result.size()).isEqualTo(2);
				assertThat(sut.getBestCategory()).isEqualTo("kids");
			}
		}
	}
}
