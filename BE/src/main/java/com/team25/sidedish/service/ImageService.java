package com.team25.sidedish.service;

import com.team25.sidedish.domain.Image;
import com.team25.sidedish.exception.NotFoundException;
import com.team25.sidedish.repository.ImageRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ImageService {

    private final ImageRepository imageRepository;

    public List<Image> getImagesByProductId(Long productId) {
        return imageRepository.findImagesByProductId(productId)
            .orElseThrow(NotFoundException::new);
    }
}
