package com.team28.sidedish.service;

import com.team28.sidedish.controller.dto.ProductListResponse;
import com.team28.sidedish.controller.dto.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MockProductService implements ProductService {

    @Override
    public ProductListResponse findProductList(Long categoryId) {
        List<ProductResponse> productResponseList = new ArrayList<>();

        if (categoryId == 1L) productResponseList = getMainMenu();
        else if (categoryId == 2L) productResponseList = getSoupMenu();
        else if (categoryId == 3L) productResponseList = getSideMenu();

        return ProductListResponse.builder()
                .count(productResponseList.size())
                .addAllProducts(productResponseList)
                .build();
    }

    private List<ProductResponse> getMainMenu() {
        return List.of(
                ProductResponse.builder()
                        .productId(1L)
                        .productName("오리 주물럭_반조리")
                        .description("감칠맛 나는 매콤한 양념")
                        .price(15800)
                        .discountPrice(12640)
                        .discountName("런칭 특가")
                        .build(),
                ProductResponse.builder()
                        .productId(2L)
                        .productName("소갈비찜")
                        .description("촉촉하게 밴 양념이 일품")
                        .price(28900)
                        .discountPrice(26010)
                        .discountName("이벤트 특가")
                        .build(),
                ProductResponse.builder()
                        .productId(3L)
                        .productName("꼬막비빔밥")
                        .description("매콤하게 입맛을 돋우는 꼬막비빔밥입니다.")
                        .price(10900)
                        .build()
        );
    }

    private List<ProductResponse> getSoupMenu() {
        return List.of(
                ProductResponse.builder()
                        .productId(4L)
                        .productName("한돈 돼지김치찌개")
                        .description("김치찌개에는 역시 돼지고기")
                        .price(9300)
                        .discountPrice(8370)
                        .discountName("이벤트 특가")
                        .build(),
                ProductResponse.builder()
                        .productId(5L)
                        .productName("된장찌개")
                        .description("특별하지 않아서 더 좋은 우리맛")
                        .price(8800)
                        .discountPrice(7920)
                        .discountName("이벤트 특가")
                        .build(),
                ProductResponse.builder()
                        .productId(6L)
                        .productName("우리콩 강된장찌개")
                        .description("우리콩으로 만들어 안심")
                        .price(5800)
                        .build()
        );
    }

    private List<ProductResponse> getSideMenu() {
        return List.of(
                ProductResponse.builder()
                        .productId(7L)
                        .productName("새콤달콤 오징어무침")
                        .description("국내산 오징어를 새콤달콤하게")
                        .price(7500)
                        .discountPrice(6000)
                        .discountName("런칭 특가")
                        .build(),
                ProductResponse.builder()
                        .productId(8L)
                        .productName("야채 어묵볶음")
                        .description("첨가물 없는 순수어묵과 야채의 환상적인 조합")
                        .price(4900)
                        .discountPrice(4410)
                        .discountName("이벤트 특가")
                        .build(),
                ProductResponse.builder()
                        .productId(9L)
                        .productName("두부조림")
                        .description("각종 영양이 가득 담긴")
                        .price(6900)
                        .build()
        );
    }

}
