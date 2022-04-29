package team31.codesuqad.sidedish.repository;

import org.springframework.data.repository.CrudRepository;
import team31.codesuqad.sidedish.domain.Dishes;

import java.util.List;

public interface DishesRepository extends CrudRepository<Dishes, Integer> {

    @Override
    List<Dishes> findAll();

}
