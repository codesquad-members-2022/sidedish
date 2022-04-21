package sidedish.com.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sidedish.com.controller.ProductsDtoMapper;
import sidedish.com.controller.model.ProductMealTypeResponse;
import sidedish.com.repository.DiscountPolicyRepository;
import sidedish.com.repository.DomainEntityMapper;
import sidedish.com.repository.ProductsRepository;

@DisplayName("ProductsServiceTest 클래스")
class ProductsServiceTest {

	private ProductsService productsService;
	private ProductsRepository productsRepository;
	private DiscountPolicyRepository discountPolicyRepository;
	private ProductsDtoMapper productsDtoMapper;
	private DomainEntityMapper domainEntityMapper;

	@BeforeEach
	void setUp() {
		productsRepository = mock(ProductsRepository.class);
		discountPolicyRepository = mock(DiscountPolicyRepository.class);
		productsDtoMapper = mock(ProductsDtoMapper.class);
		domainEntityMapper = mock(DomainEntityMapper.class);
		productsService = new ProductsService(productsRepository, discountPolicyRepository,
			productsDtoMapper, domainEntityMapper);
	}

	@Test
	void 만약_meal_type이_soup인_경우_soup음식_타입_조회_성공() {
		List<ProductMealTypeResponse> result = productsService.findByMealType("soup");

		verify(productsRepository, times(1)).findByMealType("soup");
		verify(discountPolicyRepository, times(1)).findAll();
	}

}
