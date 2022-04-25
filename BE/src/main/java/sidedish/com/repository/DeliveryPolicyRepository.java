package sidedish.com.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import sidedish.com.repository.entity.DeliveryPolicyEntity;

public interface DeliveryPolicyRepository extends CrudRepository<DeliveryPolicyEntity, Long> {

	@Override
	List<DeliveryPolicyEntity> findAll();
}
