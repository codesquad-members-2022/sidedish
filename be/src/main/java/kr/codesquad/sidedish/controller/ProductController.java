package kr.codesquad.sidedish.controller;

import kr.codesquad.sidedish.domain.DishType;
import kr.codesquad.sidedish.domain.SideDishType;
import kr.codesquad.sidedish.response.CommonCode;
import kr.codesquad.sidedish.response.CommonResponse;
import kr.codesquad.sidedish.service.ProductDTO;
import kr.codesquad.sidedish.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    /**
     * 상품 카테고리별 목록 불러오기
     */
    @ResponseBody
    @GetMapping(value = {"/{dishType}", "/{dishType}/{sideDishType}"})
    public ResponseEntity<CommonResponse> loadList(
            @PathVariable String dishType,
            @PathVariable(required = false) Optional<String> sideDishType) {
        List<ProductDTO> productDTOs = loadListByType(dishType, sideDishType);

        List<ResponseSimpleProductInfo> simpleDTOs = productDTOs.stream()
                .map(p -> ResponseSimpleProductInfo.from(p))
                .collect(Collectors.toList());

        if (productDTOs.size() == 0) {
            return noContentCommonResponse().toResponseEntity();
        }

        return OKCommonResponse(simpleDTOs).toResponseEntity();
    }

    private List<ProductDTO> loadListByType(String dishType, Optional<String> sideDishType) {
        if (sideDishType.isPresent()) {
            return productService.loadSideDishListByType(DishType.stringToEnum(dishType), SideDishType.stringToEnum(sideDishType.get()));
        }
        return productService.loadDishListByType(DishType.stringToEnum(dishType));
    }

    /**
     * 상품 세부 정보 불러오기
     */
    @ResponseBody
    @GetMapping("/{id}/detail")
    public ResponseEntity<CommonResponse> loadDetail(@PathVariable Integer id) {
        return OKCommonResponse(ResponseDetailProductInfo.from(productService.findById(id)))
                .toResponseEntity();
    }

    /**
     * 주문 넣기
     */
    @PostMapping("/orders")
    public ResponseEntity<CommonResponse> order(@RequestBody RequestProduct requestProduct) {
        productService.order(requestProduct);

        return noContentCommonResponse().toResponseEntity();
    }

    private CommonResponse noContentCommonResponse() {
        return new CommonResponse(CommonCode.SUCCESS_NO_CONTENT);
    }

    private CommonResponse OKCommonResponse(Object data) {
        return new CommonResponse(CommonCode.SUCCESS, data);
    }
}
