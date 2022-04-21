package codesquad.sidedish.domain.member;

import codesquad.sidedish.domain.address.District;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class MemberRepository {
    private SimpleJdbcInsert jdbcInsert;
    private NamedParameterJdbcTemplate jdbcTemplate;

    public MemberRepository(DataSource dataSource) {
        this.jdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("member")
                .usingGeneratedKeyColumns("member_id");
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public Long save(Member member) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("member_name", member.getMemberName());
        parameters.put("district", member.getDistrict().name());
        parameters.put("mileage", member.getMileage());
        Long memberId = jdbcInsert.executeAndReturnKey(parameters).longValue();
        member.initMemberId(memberId);

        return memberId;
    }

    public Optional<Member> findById(Long memberId) {
        String sql = "select member_id, member_name, district, mileage\n" +
                "from member\n" +
                "where member_id = :memberId";
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("memberId", memberId);

        return jdbcTemplate.query(sql, parameters, memberRowMapper()).stream().findFirst();
    }

    private RowMapper<Member> memberRowMapper() {
        return (rs, rowNumber) ->
                Member.builder()
                    .memberId(rs.getLong("member_id"))
                    .memberName(rs.getString("member_name"))
                    .district(District.valueOf(rs.getString("district")))
                    .mileage(rs.getInt("mileage"))
                    .build();
    }
}
