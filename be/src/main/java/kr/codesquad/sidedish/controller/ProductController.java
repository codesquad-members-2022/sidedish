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
@RequestMapping("/products")
public class ProductController {

	private final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping
	public List<ResponseProduct> home() {
		// DTO 다 불러오는 메소드 (애당초 필요 없을 수도 있음)
		return productService.findAll();
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

	@PatchMapping("/order/{id}")
	public void ordered(@PathVariable int id, @RequestBody RequestProduct requestProduct) {
		// 주문 넣기
		productService.ordered(id, requestProduct);
	}
}
