package sidedish.com.controller;

import java.util.List;
import javax.validation.constraints.NotEmpty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sidedish.com.controller.model.ProductMealTypeResponse;
import sidedish.com.service.ProductsService;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

	private final ProductsService productsService;

	public ProductsController(ProductsService productsService) {
		this.productsService = productsService;
	}

	@GetMapping
	public List<ProductMealTypeResponse> findProductsMealType(
		@RequestParam @NotEmpty String meal) {
		return productsService.findByMealType(meal);
	}
}
