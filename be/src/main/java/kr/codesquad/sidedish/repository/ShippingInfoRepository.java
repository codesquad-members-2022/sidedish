package kr.codesquad.sidedish.repository;

import java.util.Optional;
import kr.codesquad.sidedish.domain.ShippingInfo;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingInfoRepository extends CrudRepository<ShippingInfo, Integer> {

	@Query("SELECT * FROM SHIPPING_INFO WHERE delivery_type = :delivery_type")
	Optional<ShippingInfo> findByDeliveryType(@Param("delivery_type") Integer deliveryType);
}
