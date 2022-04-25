package com.codesquad.sidedish.dish.dto;

import com.codesquad.sidedish.dish.domain.DishImage;
import java.util.Set;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ImageResponse {

    private final String imagePath;
    private final Integer sequence;

    public static ImageResponse from(DishImage dishImage) {
        return new ImageResponse(
            dishImage.getImagePath(),
            dishImage.getSequence()
        );
    }

    public static String getFirstPath(Set<DishImage> dishImage) {
        return dishImage.stream()
            .filter(image -> image.getSequence().equals(1))
            .map(DishImage::getImagePath)
            .findAny()
            .orElse("");
    }
}
