package team14.sidedish.menu;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MenuRepository extends CrudRepository<Menu, Long> {
	List<Menu> findByCategory(Menu.Category category, PageRequest pageable);
}
