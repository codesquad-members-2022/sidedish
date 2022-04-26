package com.team28.sidedish.service;

import com.team28.sidedish.controller.dto.ProductImageResponse;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class MockProductImageService {

    private final Map<Long, List<ProductImageResponse>> images = new ConcurrentHashMap<>();

    @PostConstruct
    private void setup() {
        images.put(1L, List.of(
                new ProductImageResponse(1L, "http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_D1.jpg", true, 1),
                new ProductImageResponse(2L, "http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_S.jpg", true, 2),
                new ProductImageResponse(3L, "http://public.codesquad.kr/jk/storeapp/data/main/349_ZIP_P_0024_T.jpg", false, 1)
        ));
        images.put(2L, List.of(
                new ProductImageResponse(1L, "http://public.codesquad.kr/jk/storeapp/data/main/349_ZIP_P_0024_S.jpg", true, 1),
                new ProductImageResponse(2L, "http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg", true, 2),
                new ProductImageResponse(3L, "http://public.codesquad.kr/jk/storeapp/data/main/349_ZIP_P_0024_D1.jpg", false, 1)
        ));
        images.put(3L, List.of(
                new ProductImageResponse(1L, "http://public.codesquad.kr/jk/storeapp/data/main/417_ZIP_P_0041_T.jpg", true, 1),
                new ProductImageResponse(2L, "http://public.codesquad.kr/jk/storeapp/data/main/417_ZIP_P_0041_S.jpg", true, 2),
                new ProductImageResponse(3L, "http://public.codesquad.kr/jk/storeapp/data/main/417_ZIP_P_0041_D1.jpg", false, 1)
        ));
        images.put(4L, List.of(
                new ProductImageResponse(1L, "http://public.codesquad.kr/jk/storeapp/data/soup/28_ZIP_P_1003_T.jpg", true, 1),
                new ProductImageResponse(2L, "http://public.codesquad.kr/jk/storeapp/data/soup/28_ZIP_P_1003_S.jpg", true, 2),
                new ProductImageResponse(3L, "http://public.codesquad.kr/jk/storeapp/data/soup/28_ZIP_P_1003_D1.jpg", false, 1)
        ));
        images.put(5L, List.of(
                new ProductImageResponse(1L, "http://public.codesquad.kr/jk/storeapp/data/soup/33_ZIP_P_1004_T.jpg", true, 1),
                new ProductImageResponse(2L, "http://public.codesquad.kr/jk/storeapp/data/soup/33_ZIP_P_1004_S.jpg", true, 2),
                new ProductImageResponse(3L, "http://public.codesquad.kr/jk/storeapp/data/soup/33_ZIP_P_1004_D1.jpg", false, 1)
        ));
        images.put(6L, List.of(
                new ProductImageResponse(1L, "http://public.codesquad.kr/jk/storeapp/data/soup/842_ZIP_P_1035_T.jpg", true, 1),
                new ProductImageResponse(2L, "http://public.codesquad.kr/jk/storeapp/data/soup/842_ZIP_P_1035_S.jpg", true, 2),
                new ProductImageResponse(3L, "http://public.codesquad.kr/jk/storeapp/data/soup/842_ZIP_P_1035_D1.jpg", false, 1)
        ));
        images.put(7L, List.of(
                new ProductImageResponse(1L, "http://public.codesquad.kr/jk/storeapp/data/side/48_ZIP_P_5008_T.jpg", true, 1),
                new ProductImageResponse(2L, "http://public.codesquad.kr/jk/storeapp/data/side/48_ZIP_P_5008_S.jpg", true, 2),
                new ProductImageResponse(3L, "http://public.codesquad.kr/jk/storeapp/data/side/48_ZIP_P_5008_D1.jpg", false, 1)
        ));
        images.put(8L, List.of(
                new ProductImageResponse(1L, "http://public.codesquad.kr/jk/storeapp/data/side/84_ZIP_P_6006_T.jpg", true, 1),
                new ProductImageResponse(2L, "http://public.codesquad.kr/jk/storeapp/data/side/84_ZIP_P_6006_S.jpg", true, 2),
                new ProductImageResponse(3L, "http://public.codesquad.kr/jk/storeapp/data/side/84_ZIP_P_6006_D1.jpg", false, 1)
        ));
        images.put(9L, List.of(
                new ProductImageResponse(1L, "http://public.codesquad.kr/jk/storeapp/data/side/268_ZIP_P_4023_T.jpg", true, 1),
                new ProductImageResponse(2L, "http://public.codesquad.kr/jk/storeapp/data/side/268_ZIP_P_4023_S.jpg", true, 2),
                new ProductImageResponse(3L, "http://public.codesquad.kr/jk/storeapp/data/side/268_ZIP_P_4023_D1.jpg", false, 1)
        ));
    }

    public List<ProductImageResponse> findProductImages(Long productId) {
        return images.getOrDefault(productId, Collections.EMPTY_LIST);
    }
}
