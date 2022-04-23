package sidedish.jbc.repository;

import java.util.List;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import sidedish.jbc.domain.Menu;
import sidedish.jbc.domain.MenuType;
import sidedish.jbc.dto.DetailMenuInfo;
import sidedish.jbc.dto.MenuResponse;

public interface MenuRepository extends CrudRepository<Menu, Integer> {

	// 타입에 대한 홈페이지 뷰를 내리는 것
	@Query(
		"select menu.id, name, description, price, menu_type, sale_type, image_path from menu where menu_type = :type")
	List<MenuResponse> findAllByType(@Param("type") MenuType type);

	@Query("select name, description, price, sale_type, delivery_info, fee, free_shipping_min from menu where id = :menuId")
	DetailMenuInfo findDetailMenu(@Param("menuId") int menuId);

}
