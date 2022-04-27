package kr.codesquad.sidedish.controller.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class ProductListResponse {

    private final ProductListRequest requestDetail;
    private final List<ProductResponse> products;
}
