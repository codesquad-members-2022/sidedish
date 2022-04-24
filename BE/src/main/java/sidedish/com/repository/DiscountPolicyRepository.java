package sidedish.com.repository;

import java.util.List;
import java.util.Map;
import org.springframework.data.repository.CrudRepository;
import sidedish.com.repository.entity.DiscountPolicyEntity;

public interface DiscountPolicyRepository extends CrudRepository<DiscountPolicyEntity, Long> {

	@Override
	List<DiscountPolicyEntity> findAll();
}
