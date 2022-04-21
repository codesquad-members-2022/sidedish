package sidedish.jbc.repository;

import java.util.List;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import sidedish.jbc.domain.Menu;
import sidedish.jbc.dto.MenuResponse;

public interface MenuRepository extends CrudRepository<Menu, Integer> {

	@Query(
		"select menu.id ,name, description, price, menu_type, sale_type, image_path from menu, image where menu"
			+ ".image_id=image.id and menu_type= :type")
	List<MenuResponse> findAllByType(@Param("type") int type);

}
