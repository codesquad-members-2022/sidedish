package codesquad.sidedish.domain.order;

import codesquad.sidedish.domain.address.Address;
import codesquad.sidedish.domain.delivery.Delivery;
import codesquad.sidedish.domain.delivery.DeliveryType;
import codesquad.sidedish.domain.discount.DiscountPolicy;
import codesquad.sidedish.domain.item.Item;
import codesquad.sidedish.domain.item.ItemImage;
import codesquad.sidedish.domain.item.ItemImageType;
import codesquad.sidedish.domain.item.ItemSection;
import codesquad.sidedish.domain.member.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Repository
public class OrderRepository {

    private SimpleJdbcInsert jdbcInsert;
    private NamedParameterJdbcTemplate jdbcTemplate;

    public OrderRepository(DataSource dataSource) {
        this.jdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("orders")
                .usingGeneratedKeyColumns("order_id");
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public Long save(Order order) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("item_id", order.getItem().getItemId());
        parameters.put("member_id", order.getMember().getMemberId());
        parameters.put("delivery_id", order.getDelivery().getDeliveryId());
        parameters.put("discount_policy_id", order.getDiscountPolicy().getDiscountPolicyId());
        parameters.put("order_item_price", order.getItem().getPrice());
        parameters.put("item_count", order.getItemCount());
        Long orderId = jdbcInsert.executeAndReturnKey(parameters).longValue();
        order.initOrderId(orderId);
        log.info("Order Saved = {}", order);
        return orderId;
    }

    public Optional<Order> findById(Long orderId) {
        String sql = "SELECT o.order_id, o.item_id, o.member_id, o.delivery_id,\n" +
                "o.discount_policy_id, o.order_item_price, o.item_count,\n" +
                "i.name, i.description, i.price, i.discount_policy_id, i.item_section_id, i.stock, i.support_dawn_delivery,\n" +
                "idp.name, idp.discount_rate,\n" +
                "isec.item_section_name,\n" +
                "m.member_name, m.district, m.city, m.mileage,\n" +
                "dl.fee, dl.district, dl.city, dl.delivery_type,\n" +
                "dp.name, dp.discount_rate\n" +
                "FROM orders as o\n" +
                "JOIN item as i\n" +
                "ON o.item_id = i.item_id\n" +
                "JOIN discount_policy as idp\n" +
                "ON i.discount_policy_id = idp.discount_policy_id\n" +
                "JOIN item_section as isec\n" +
                "ON i.item_section_id = isec.item_section_id\n" +
                "JOIN member as m\n" +
                "ON o.member_id = m.member_id\n" +
                "JOIN delivery as dl\n" +
                "ON o.delivery_id = dl.delivery_id\n" +
                "JOIN discount_policy as dp\n" +
                "ON o.discount_policy_id = dp.discount_policy_id\n" +
                "WHERE o.order_id = :orderId";
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("orderId", orderId);

        return jdbcTemplate.query(sql, parameters, orderRowMapper()).stream().findFirst();
    }


    private RowMapper<Order> orderRowMapper() {
        return (rs, rowNum) ->
                Order.builder()
                        .orderId(rs.getLong("o.order_id"))
                        .item(buildItem(rs))
                        .member(buildMember(rs))
                        .delivery(buildDelivery(rs))
                        .discountPolicy(buildDiscountPolicy(rs))
                        .orderItemPrice(rs.getInt("o.order_item_price"))
                        .itemCount(rs.getInt("o.item_count"))
                        .build();
    }

    private Item buildItem(ResultSet rs) throws SQLException {
        return Item.builder()
                .itemId(rs.getLong("o.item_id"))
                .name(rs.getString("i.name"))
                .description(rs.getString("i.description"))
                .price(rs.getInt("i.price"))
                .discountPolicy(buildItemDiscountPolicy(rs))
                .itemSection(buildItemSection(rs))
                .stock(rs.getInt("i.stock"))
                .supportDawnDelivery(rs.getBoolean("i.support_dawn_delivery"))
                .itemImages(findItemImages(rs.getLong("o.item_id")))
                .build();
    }

    private DiscountPolicy buildItemDiscountPolicy(ResultSet rs) throws SQLException {
        return DiscountPolicy.builder()
                .discountPolicyId(rs.getLong("i.discount_policy_id"))
                .name(rs.getString("idp.name"))
                .discountRate(rs.getDouble("idp.discount_rate"))
                .build();
    }

    private List<ItemImage> findItemImages(Long itemId) {
        String sql = "select item_image_id, item_image_url, item_image_sequence, item_image_type\n" +
                "from item_image\n" +
                "where item_id = :itemId";
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("itemId", itemId);
        return jdbcTemplate.query(sql, parameters, itemImageMapper());
    }

    private RowMapper<ItemImage> itemImageMapper() {
        return (rs, rowNumber) -> ItemImage.builder()
                .itemImageId(rs.getLong("item_image_id"))
                .itemImageUrl(rs.getString("item_image_url"))
                .itemImageSequence(rs.getInt("item_image_sequence"))
                .itemImageType(ItemImageType.valueOf(rs.getString("item_image_type")))
                .build();
    }

    private ItemSection buildItemSection(ResultSet rs) throws SQLException {
        return new ItemSection(rs.getLong("i.item_section_id"), rs.getString("isec.item_section_name"));
    }

    private Member buildMember(ResultSet rs) throws SQLException {
        return Member.builder()
                .memberId(rs.getLong("o.member_id"))
                .memberName(rs.getString("m.member_name"))
                .address(new Address(rs.getString("m.district"), rs.getString("m.city")))
                .mileage(rs.getInt("m.mileage"))
                .build();
    }

    private Delivery buildDelivery(ResultSet rs) throws SQLException {
        return Delivery.builder()
                .deliveryId(rs.getLong("o.delivery_id"))
                .deliveryFee(rs.getInt("dl.fee"))
                .deliveryType(DeliveryType.valueOf(rs.getString("dl.delivery_type")))
                .address(new Address(rs.getString("dl.district"), rs.getString("dl.city")))
                .build();
    }

    private DiscountPolicy buildDiscountPolicy(ResultSet rs) throws SQLException {
        return DiscountPolicy.builder()
                .discountPolicyId(rs.getLong("o.discount_policy_id"))
                .name(rs.getString("dp.name"))
                .discountRate(rs.getDouble("dp.discount_rate"))
                .build();
    }

}
