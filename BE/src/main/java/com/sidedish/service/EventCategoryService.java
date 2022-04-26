package com.sidedish.service;

import com.sidedish.domain.Event;
import com.sidedish.domain.SideDish;
import com.sidedish.dto.EventCategoryDto;
import com.sidedish.dto.EventCategoryListDto;
import com.sidedish.dto.SideDishDto;
import com.sidedish.dto.SideDishListDto;
import com.sidedish.mapper.EventCategoryMapper;
import com.sidedish.mapper.SideDishMapper;
import com.sidedish.repository.EventCategoryRepository;
import com.sidedish.repository.EventRepository;
import com.sidedish.repository.SideDishRepository;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventCategoryService {

    private final EventRepository eventRepository;
    private final EventCategoryRepository eventCategoryRepository;
    private final SideDishRepository sideDishRepository;

    public EventCategoryListDto getEventCategories() {
        EventCategoryMapper mapper = new EventCategoryMapper();
        for (Event event : eventRepository.findAll()) {
            if (event.isProgressFlag()) {
                String eventName = event.getName();
                List<EventCategoryDto> eventCategories = eventCategoryRepository.findAllByEventId(event.getId())
                    .stream().map(mapper::convertToDto).collect(Collectors.toList());

                return new EventCategoryListDto(eventName, eventCategories);
            }
        }

        return null;
    }

    public SideDishListDto getSideDishList(Integer eventCategoryId) {
        List<SideDish> sideDishes = sideDishRepository.findAllByEventCategoryId(eventCategoryId);

        return new SideDishListDto(shuffleSideDishes(sideDishes));
    }

    private List<SideDishDto> shuffleSideDishes(List<SideDish> sideDishes) {
        Collections.shuffle(sideDishes);
        SideDishMapper mapper = new SideDishMapper();

        return sideDishes.stream()
            .limit(3)
            .map(mapper::convertToDto)
            .collect(Collectors.toList());
    }

}
