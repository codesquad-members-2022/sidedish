package sidedish.jbc.repository;

import java.util.List;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import sidedish.jbc.domain.Image;
import sidedish.jbc.dto.DetailMenuImages;

public interface ImageRepository extends CrudRepository<Image, Integer> {

	@Query("select image_path, is_main_image from image where menu_id = :menuId")
	List<DetailMenuImages> findInfoByMenuId(@Param("menuId") int menuId);

}
