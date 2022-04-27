package codesquad.sidedish.domain.delivery;

import codesquad.sidedish.domain.address.Address;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Repository
public class DeliveryRepository {
    private SimpleJdbcInsert jdbcInsert;
    private NamedParameterJdbcTemplate jdbcTemplate;

    public DeliveryRepository(DataSource dataSource) {
        this.jdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("delivery")
                .usingGeneratedKeyColumns("delivery_id");
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public Long save(Delivery delivery) {
        Map<String, Object> parameters = new HashMap<>();
        Address deliveryAddress = delivery.getAddress();
        parameters.put("fee", delivery.getDeliveryFee());
        parameters.put("district", deliveryAddress.getDistrict());
        parameters.put("city", deliveryAddress.getCity());
        parameters.put("delivery_type", delivery.getDeliveryType().name());

        Long deliveryId = jdbcInsert.executeAndReturnKey(parameters).longValue();
        delivery.initDeliveryId(deliveryId);

        return deliveryId;
    }

    public Optional<Delivery> findById(Long deliveryId) {
        String selectDeliverySql = "select delivery_id, fee, delivery_type, city, district \n" +
                "from delivery\n" +
                "where delivery_id = :deliveryId";

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("deliveryId", deliveryId);
        return jdbcTemplate.query(selectDeliverySql, parameters, deliveryRowMapper()).stream().findFirst();

    }

    private RowMapper<Delivery> deliveryRowMapper() {
        return (rs, rowNumber) -> Delivery.builder()
                .deliveryId(rs.getLong("delivery_id"))
                .deliveryFee(rs.getInt("fee"))
                .address(new Address(rs.getString("district"), rs.getString("city")))
                .deliveryType(DeliveryType.valueOf(rs.getString("delivery_type")))
                .build();
    }
}
