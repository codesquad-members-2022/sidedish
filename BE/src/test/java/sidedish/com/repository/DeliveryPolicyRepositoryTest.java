package sidedish.com.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.test.context.jdbc.Sql;
import sidedish.com.repository.entity.DeliveryPolicyEntity;

@DisplayName("DeliveryPolicyRepository 클래스")
@DataJdbcTest
class DeliveryPolicyRepositoryTest {

	@Autowired
	DeliveryPolicyRepository deliveryPolicyRepository;

	@BeforeEach
	@Sql({"/testdb/schema.sql", "/testdb/data.sql"})
	void setUp() {

	}

	@Test
	void Delivery_findAll() {
		List<DeliveryPolicyEntity> deliveryPolicyEntities = deliveryPolicyRepository.findAll();

		assertThat(deliveryPolicyEntities.get(0).getId()).isEqualTo(1);
		assertThat(deliveryPolicyEntities.get(0).getDeliveryCharge()).isEqualTo(2500);
	}
}
