package sidedish.jbc.repository;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import sidedish.jbc.domain.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	@Modifying
	@Query("update user set point = point + :point where id = :id")
	boolean updatePoint(@Param("id") Integer id, @Param("point") int point);

}
