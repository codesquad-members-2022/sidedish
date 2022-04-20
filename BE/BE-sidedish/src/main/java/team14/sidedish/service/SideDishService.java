package team14.sidedish.service;

import org.springframework.stereotype.Service;
import team14.sidedish.repository.SideDishRepository;

@Service
public class SideDishService {

    private final SideDishRepository sideDishRepository;

    public SideDishService(SideDishRepository sideDishRepository) {
        this.sideDishRepository = sideDishRepository;
    }
}
