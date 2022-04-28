package kr.codesquad.sidedish.controller;

import kr.codesquad.sidedish.domain.DishType;
import kr.codesquad.sidedish.domain.SideDishType;
import kr.codesquad.sidedish.response.CommonResponse;
import kr.codesquad.sidedish.service.ProductDTO;
import kr.codesquad.sidedish.service.ProductService;
import kr.codesquad.sidedish.service.ShippingInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.beans.PropertyEditorSupport;
import java.util.List;
import java.util.stream.Collectors;

import static kr.codesquad.sidedish.response.CommonResponse.*;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    public static final Integer MinimumProductId = 1;
    public static final Integer MaximumProductId = 24;

    private final ProductService productService;
    private final ShippingInfoService shippingInfoService;

    @InitBinder
    private void initBinder(final WebDataBinder webdataBinder) {
        webdataBinder.registerCustomEditor(DishType.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                setValue(DishType.fromName(text));
            }
        });
        webdataBinder.registerCustomEditor(SideDishType.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                setValue(SideDishType.fromName(text));
            }
        });
    }

    /**
     * 요리 카테고리별 목록 불러오기
     */
    @ResponseBody
    @GetMapping("/{dishType}")
    public ResponseEntity<CommonResponse> loadDishProducts(@PathVariable DishType dishType) {
        List<ProductDTO> productDTOs = productService.loadDishListByType(dishType);

        if (productDTOs.size() == 0) {
            return noContentCommonResponse().toResponseEntity();
        }

        List<ResponseSimpleProductInfo> simpleDTOs = productDTOs.stream()
                .map(p -> ResponseSimpleProductInfo.from(p))
                .collect(Collectors.toList());

        return okCommonResponse(simpleDTOs).toResponseEntity();
    }

    /**
     * 반찬 카테고리별 목록 불러오기
     */
    @ResponseBody
    @GetMapping("/{dishType}/{sideDishType}")
    public ResponseEntity<CommonResponse> loadSideDishProducts(@PathVariable DishType dishType, @PathVariable SideDishType sideDishType) {
        List<ProductDTO> productDTOs = productService.loadSideDishListByType(dishType, sideDishType);

        if (productDTOs.size() == 0) {
            return noContentCommonResponse().toResponseEntity();
        }

        List<ResponseSimpleProductInfo> simpleDTOs = productDTOs.stream()
                .map(p -> ResponseSimpleProductInfo.from(p))
                .collect(Collectors.toList());

        return okCommonResponse(simpleDTOs).toResponseEntity();
    }

    /**
     * 상품 세부 정보 불러오기
     */
    @ResponseBody
    @GetMapping("/{id}/detail")
    public ResponseEntity<CommonResponse> loadDetail(
            @Min(value = 1, message = "1 미만의 상품 ID는 존재하지 않습니다.")
            @Max(value = 24, message = "24 초과의 상품 ID는 존재하지 않습니다.")
            @PathVariable Integer id) {

        ProductDTO productDTO = productService.findById(id);

        ResponseShippingInfo responseShippingInfo = ResponseShippingInfo.from(
                shippingInfoService.findByDeliveryType(productDTO.getDeliveryType()));

        return okCommonResponse(
                ResponseDetailProductInfo.from(productService.findById(id), responseShippingInfo))
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
}
