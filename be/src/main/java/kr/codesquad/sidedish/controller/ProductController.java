package kr.codesquad.sidedish.controller;

import java.util.ArrayList;
import java.util.List;
import kr.codesquad.sidedish.dto.DetailProductInfo;
import kr.codesquad.sidedish.dto.ProductDTO;
import kr.codesquad.sidedish.dto.RequestProduct;
import kr.codesquad.sidedish.dto.SimpleProductInfo;
import kr.codesquad.sidedish.response.CommonCode;
import kr.codesquad.sidedish.response.CommonResponse;
import kr.codesquad.sidedish.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController("/api/v1/products")
public class ProductController {

	private final ProductService productService;

	/**
	 * 상품 카테고리별 목록 불러오기
	 */
	@ResponseBody
	@GetMapping("/{dishType}/{sideDishType}")
	public ResponseEntity<CommonResponse<List<SimpleProductInfo>>> loadListByType(
		@PathVariable String dishType,
		@PathVariable String sideDishType) {
		List<ProductDTO> dtoList = productService.loadListByType(dishType, sideDishType);

		List<SimpleProductInfo> simpleDtoList = new ArrayList<>();
		for (int i = 0; i < dtoList.size(); i++) {
			SimpleProductInfo simpleDto = SimpleProductInfo.from(dtoList.get(i));
			simpleDtoList.add(simpleDto);
		}
		return new CommonResponse(CommonCode.SUCCESS, simpleDtoList).toResponseEntity();
	}


	/**
	 * 상품 세부 정보 불러오기
	 */
	@ResponseBody
	@GetMapping("/details/{id}")
	public ResponseEntity<CommonResponse<DetailProductInfo>> loadDetails(@PathVariable Integer id) {
		return new CommonResponse(CommonCode.SUCCESS,
			DetailProductInfo.from(productService.findById(id))).toResponseEntity();
	}

	/**
	 * 주문 넣기
	 */
	@PostMapping("/orders")
	public ResponseEntity<CommonResponse> ordered(@RequestBody RequestProduct requestProduct) {
		productService.ordered(requestProduct);

		return new CommonResponse(CommonCode.SUCCESS).toResponseEntity();
	}
}
