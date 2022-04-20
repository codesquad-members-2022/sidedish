package sidedish.com.controller;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.constraints.NotEmpty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sidedish.com.controller.model.ProductsMealTypeResponse;
import sidedish.com.domain.Product;
import sidedish.com.service.ProductsService;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

	ProductsService productsService;

	public ProductsController(ProductsService productsService) {
		this.productsService = productsService;
	}

	@GetMapping
	public List<ProductsMealTypeResponse> findProductsMealType(
		@RequestParam @NotEmpty String meal) {
		List<Product> products = productsService.findByMealType(meal);

		return products.stream()
			.map(ProductsDtoMapper::toProductsMealTypeResponseFromDomain)
			.collect(Collectors.toList());
	}
}
