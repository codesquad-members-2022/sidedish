package com.example.be.business.dish.repository;

import com.example.be.business.dish.domain.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.relational.core.conversion.DbActionExecutionException;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("dev")
@ExtendWith(SpringExtension.class)
@DisplayName("DishRepository 테스트")
class DishRepositoryTest {

    @Autowired
    DishRepository dishRepository;

    @Test
    @Rollback
    @DisplayName("이미지를 한 장 저장하면 PK값이 1 증가한다.")
    void saveOnlyOneImage() throws Exception {
        Dish dish = getDishIncludedOnlyOneImage();
        Dish savedDish = dishRepository.save(dish);
        assertThat(savedDish.getDishId()).isNotNull();
    }

    @Test
    @Rollback
    @DisplayName("이미지를 여러장 저장하면 DbActionExecutionException이 발생한다.")
    void saveWithManyImages() {
        Dish dish = getDishIncludedManyImages();
        Assertions.assertThrows(DbActionExecutionException.class, () -> dishRepository.save(dish));
    }

    private Dish getDishIncludedOnlyOneImage() {
        String imageUrl = "https://blog.kakaocdn.net/dn/cLbqUS/btq6CCzxZTy/2tHyApPUl0rbAkRPmXCLa1/img.png";
        List<Image> images = getOnlyOneImage();
        return new Dish("된장 찌개", "어머니의 손맛이 살아  숨쉬는 된장찌개", new BigDecimal(8000L), Badge.EVENT, DeliveryPriceOption.FREE, imageUrl, DishStatus.IN_STOCK, 80, 1L, images);
    }

    private Dish getDishIncludedManyImages() {
        String imageUrl = "https://blog.kakaocdn.net/dn/cLbqUS/btq6CCzxZTy/2tHyApPUl0rbAkRPmXCLa1/img.png";
        List<Image> images = getTwoImages();
        return new Dish("된장 찌개", "어머니의 손맛이 살아 숨쉬는 된장찌개", new BigDecimal(8000L), Badge.EVENT, DeliveryPriceOption.FREE, imageUrl, DishStatus.IN_STOCK, 80, 1L, images);
    }

    private List<Image> getOnlyOneImage(){
        String imageUrl = "https://blog.kakaocdn.net/dn/cLbqUS/btq6CCzxZTy/2tHyApPUl0rbAkRPmXCLa1/img.png";
        Image image = new Image(imageUrl);

        List<Image> images = new LinkedList<>();
        images.add(image);
        return images;
    }

    public List<Image> getTwoImages(){
        String imageUrl = "https://blog.kakaocdn.net/dn/cLbqUS/btq6CCzxZTy/2tHyApPUl0rbAkRPmXCLa1/img.png";
        String imageUrl2 = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQmg86TZQa7UM1Hh87pAsY-3XOffhczElrfyFB2xJAyCBblm7fWW5u9ma5VRUJD1GLZ_qU&usqp=CAU";
        Image image = new Image(imageUrl);
        Image image2 = new Image(imageUrl2);

        List<Image> images = new LinkedList<>();
        images.add(image);
        images.add(image2);
        return images;
    }

}

