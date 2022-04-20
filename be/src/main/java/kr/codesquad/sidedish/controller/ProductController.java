package kr.codesquad.sidedish.controller;

import java.util.List;
import kr.codesquad.sidedish.dto.RequestProduct;
import kr.codesquad.sidedish.dto.ResponseProduct;
import kr.codesquad.sidedish.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/products")
public class ProductController {

	private final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/{dishType}/{sideDishType}")
	public List<ResponseProduct> loadListByType(@PathVariable String dishType,
		@PathVariable String sideDishType) {
		// 상품 카테고리별 목록 불러오기
		return productService.loadListByType(dishType, sideDishType);
	}

	@GetMapping("/{id}")
	public ResponseProduct loadDetails(@PathVariable int id) {
		// 상품 세부 정보 불러오기
		return productService.findById(id);
	}

	@PatchMapping("/purchase")
	public void ordered(@RequestBody RequestProduct requestProduct) {
		// 주문 넣기
		productService.ordered(requestProduct);
	}
}
