package com.terria.sidedish.service;

import com.terria.sidedish.dto.response.SideDishDetailResponse;
import com.terria.sidedish.repository.SideDishRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class SideDishService {

    private final SideDishRepository sideDishRepository;

    public SideDishDetailResponse getById(long id) {

        // TODO
        return null;
    }
}
