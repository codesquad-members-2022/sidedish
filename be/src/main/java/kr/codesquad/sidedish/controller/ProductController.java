package kr.codesquad.sidedish.controller;

import java.util.List;
import kr.codesquad.sidedish.dto.RequestProduct;
import kr.codesquad.sidedish.dto.ResponseProduct;
import kr.codesquad.sidedish.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {

	private final ProductService productService;

	/**
	 * 상품 카테고리별 목록 불러오기
	 */
	@GetMapping("/{dishType}/{sideDishType}")
	public List<ResponseProduct> loadListByType(@PathVariable String dishType,
		@PathVariable String sideDishType) {
		return productService.loadListByType(dishType, sideDishType);
	}

	/**
	 * 상품 세부 정보 불러오기
	 */
	@GetMapping("/details/{id}")
	public ResponseProduct loadDetails(@PathVariable Integer id) {
		return productService.findById(id);
	}

	/**
	 * 주문 넣기
	 */
	@PostMapping("/orders")
	public void ordered(@RequestBody RequestProduct requestProduct) {
		productService.ordered(requestProduct);
	}
}
