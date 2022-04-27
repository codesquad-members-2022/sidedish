package codesquad.sidedish.domain.item;

import codesquad.sidedish.domain.discount.DiscountPolicy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
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
public class ItemRepository {

    private NamedParameterJdbcTemplate jdbcTemplate;

    public ItemRepository(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public Optional<Item> findById(Long itemId) {
        String selectItemSql = "select i.item_id, i.name, i.description, i.price,\n" +
                "i.discount_policy_id, dp.name, dp.discount_rate,\n"  +
                "i.item_section_id, isec.item_section_name, \n" +
                "i.stock, i.support_dawn_delivery\n" +
                "from item as i\n" +
                "join discount_policy as dp\n" +
                "on i.discount_policy_id = dp.discount_policy_id\n " +
                "join item_section as isec\n" +
                "on i.item_section_id = isec.item_section_id\n" +
                "where i.item_id = :itemId";

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("itemId", itemId);

        return jdbcTemplate.query(selectItemSql, parameters, itemRowMapper()).stream().findFirst();
    }

    private RowMapper<Item> itemRowMapper() {
        return (rs, rowNumber) ->
                Item.builder()
                        .itemId(rs.getLong("i.item_id"))
                        .name(rs.getString("i.name"))
                        .description(rs.getString("i.description"))
                        .price(rs.getInt("i.price"))
                        .discountPolicy(buildDisCountPolicy(rs))
                        .itemSection(buildItemSection(rs))
                        .stock(rs.getInt("i.stock"))
                        .itemImages(findItemImages(rs.getLong("i.item_id")))
                        .supportDawnDelivery(rs.getBoolean("i.support_dawn_delivery"))
                        .build();
    }

    public List<Item> findByItemSectionName(String itemSectionName) {
        String sql = "select i.item_id, i.name, i.description, i.price,\n" +
                "i.discount_policy_id, dp.name, dp.discount_rate,\n"  +
                "i.item_section_id, isec.item_section_name, \n" +
                "i.stock, i.support_dawn_delivery\n" +
                "from item as i\n" +
                "join discount_policy as dp\n" +
                "on i.discount_policy_id = dp.discount_policy_id\n " +
                "join item_section as isec\n" +
                "on i.item_section_id = isec.item_section_id\n" +
                "where isec.item_section_name = :itemSectionName";
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("itemSectionName", itemSectionName);
        return jdbcTemplate.query(sql, parameters, itemRowMapper());
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
        Long itemSectionId = rs.getLong("i.item_section_id");
        String itemSectionName = rs.getString("isec.item_section_name");
        return new ItemSection(itemSectionId, itemSectionName);
    }

    private DiscountPolicy buildDisCountPolicy(ResultSet rs) throws SQLException {
        return DiscountPolicy.builder()
                .discountPolicyId(rs.getLong("i.discount_policy_id"))
                .name(rs.getString("dp.name"))
                .discountRate(rs.getDouble("dp.discount_rate"))
                .build();
    }
}
