package team14.sidedish.exhibition;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface ExhibitionRepository extends CrudRepository<Exhibition, Long> {
	@Query("select EXHIBITION_ID, EXHIBITION_TITLE from SIDEDISH_EXHIBITIONS where EXHIBITION_START = (select max(EXHIBITION_START) as LATEST_DATE from SIDEDISH_EXHIBITIONS);")
	Exhibition findByLatestStartAt();
}
