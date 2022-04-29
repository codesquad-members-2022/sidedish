package team14.sidedish.menu;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MenuRepository extends CrudRepository<Menu, Long> {
	List<Menu> findByCategory(Menu.Category category, PageRequest pageable);

	@Modifying
	@Query("UPDATE SIDEDISH_MENUS SET INVENTORY_QUANTITY = :quantity WHERE MENU_ID = :menuId")
	boolean updateByInventoryQuantity(@Param("quantity") int quantity, @Param("menuId") Long menuId);
}
