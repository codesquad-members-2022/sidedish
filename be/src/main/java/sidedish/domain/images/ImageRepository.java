package sidedish.domain.images;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends CrudRepository<Image, Long> {

    @Query("select * from images where id= :itemId")
    List<Image> findImagesById(Long itemId);
}
