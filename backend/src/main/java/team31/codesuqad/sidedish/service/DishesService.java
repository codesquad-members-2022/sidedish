package team31.codesuqad.sidedish.service;

import org.springframework.stereotype.Service;
import team31.codesuqad.sidedish.domain.Dishes;
import team31.codesuqad.sidedish.repository.DishesRepository;

import java.util.List;

@Service
public class DishesService {

    private final DishesRepository dishesRepository;

    public DishesService(DishesRepository dishesRepository) {
        this.dishesRepository = dishesRepository;
    }

    public List<Dishes> findAll() {
        return dishesRepository.findAll();
    }

}
