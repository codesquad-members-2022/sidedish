package sidedish.com.repository;

import org.springframework.data.repository.CrudRepository;
import sidedish.com.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
