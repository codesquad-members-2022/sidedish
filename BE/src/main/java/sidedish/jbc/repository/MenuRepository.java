package sidedish.jbc.repository;

import java.util.List;
import org.springframework.stereotype.Repository;
import sidedish.jbc.domain.Menu;
import sidedish.jbc.domain.MenuType;

@Repository
public class MenuRepository {

	public List<Menu> findAll() {
		return null;
	}

	public List<Menu> findMenu(MenuType menuType) {
		int typeValue = menuType.getTypeValue();
		return null;
	}

}
