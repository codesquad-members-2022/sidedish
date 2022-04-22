package com.team25.sidedish.repository;

import static org.assertj.core.api.Assertions.*;

import com.team25.sidedish.domain.Image;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;

@DataJdbcTest
public class ImageRepositoryTest {
    private static final Long PRODUCT_ID = 1L;
    private static final int IMAGE_COUNT = 2;
    private static final String URL = "https://recipe1.ezmember.co.kr/cache/data/goods/19/10/43/1000003443/1000003443_detail_08.jpg";



    @Autowired ImageRepository imageRepository;

    @Test
    @DisplayName("프로덕트 ID를 통해 해당하는 이미지 목록을 조회할 수 있다")
    void 프로덕트ID로_이미지_조회_테스트() {

        Optional<List<Image>> result = imageRepository.findImagesByProductId(PRODUCT_ID);

        assertThat(result).isPresent();
        assertThat(result.get()).hasSize(IMAGE_COUNT);
        assertThat(result.get().get(0).getUrl()).isEqualTo(URL);

    }
}
