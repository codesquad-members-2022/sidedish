package com.team25.sidedish.service;

import com.team25.sidedish.domain.Event;
import com.team25.sidedish.exception.NotFoundException;
import com.team25.sidedish.repository.ProductEventRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductEventService {

    private final ProductEventRepository productEventRepository;

    public List<Event> getEventsByProductId(Long productId) {
        return productEventRepository.findEventsByProductId(productId)
            .orElseThrow(NotFoundException::new);
    }
}
