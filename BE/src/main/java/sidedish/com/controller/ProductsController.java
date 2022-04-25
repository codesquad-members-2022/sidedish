package sidedish.com.controller;

import java.util.List;
import javax.validation.constraints.Negative;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sidedish.com.controller.model.ProductDetailTypeResponse;
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

	@GetMapping("/{id}")
	public ProductDetailTypeResponse findById(@PathVariable @Negative @NotNull Long id) {
		 return productsService.findById(id);
	}
}
