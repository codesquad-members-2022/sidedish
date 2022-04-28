package team31.codesuqad.sidedish.repository;

import org.springframework.data.repository.CrudRepository;
import team31.codesuqad.sidedish.domain.Dishes;

import java.util.List;
import java.util.Optional;

public interface DishesRepository extends CrudRepository<Dishes, Integer> {

    @Override
    List<Dishes> findAll();

    Dishes findById(Long dishId);
}
