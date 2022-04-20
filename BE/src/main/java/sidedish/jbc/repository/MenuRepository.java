package sidedish.jbc.repository;

import java.util.List;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sidedish.jbc.domain.Menu;
import sidedish.jbc.dto.ResponseMenu;

@Repository
public interface MenuRepository extends CrudRepository<Menu, Integer> {

	@Query(
		"select menu.id ,name, description, price, menu_type, sale_type, image_path from menu, image where menu"
			+ ".image_id=image.id and menu_type= :type")
	List<ResponseMenu> findAllByType(@Param("type") int type);

}
