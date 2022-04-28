package kr.codesquad.sidedish.repository;

import kr.codesquad.sidedish.domain.DeliveryPolicy;
import org.springframework.data.repository.CrudRepository;

public interface DeliveryPolicyRepository extends CrudRepository<DeliveryPolicy, Long> {
}
