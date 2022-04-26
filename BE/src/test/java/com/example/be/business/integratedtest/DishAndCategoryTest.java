package com.example.be.business.integratedtest;

import com.example.be.business.dish.domain.*;
import com.example.be.business.dish.repository.DishRepository;
import com.example.be.business.dish.repository.ImageRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

@SpringBootTest
@ActiveProfiles("dev")
@ExtendWith(SpringExtension.class)
@DisplayName("DishRepository 테스트")
public class DishAndCategoryTest {

    @Autowired
    DishRepository dishRepository;

    @Autowired
    ImageRepository imageRepository;

    @Test
    @Rollback
    @DisplayName("애그리게잇을 삭제하면 동일 바운드리 내부의 엔티티도 함께 삭제된다.")
    void deleteAggregate() throws Exception {
        Dish dish = getDishIncludedOnlyOneImage();
        Dish savedDish = dishRepository.save(dish);

        dishRepository.delete(savedDish);
        Assertions.assertThrows(NoSuchElementException.class, ()->imageRepository.findById(1L).orElseThrow());

    }

    private Dish getDishIncludedOnlyOneImage() {
        String imageUrl = "https://blog.kakaocdn.net/dn/cLbqUS/btq6CCzxZTy/2tHyApPUl0rbAkRPmXCLa1/img.png";
        List<Image> images = getOnlyOneImage();
        return new Dish("된장 찌개", "어머니의 손맛이 살아 숨쉬는 된장찌개", new BigDecimal(8000L), Badge.EVENT, DeliveryPriceOption.FREE, imageUrl, DishStatus.IN_STOCK, 80, 1L, images);
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
