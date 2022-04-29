package com.codesquad.sidedish;

import static org.assertj.core.api.Assertions.assertThat;

import com.codesquad.sidedish.auth.JwtFactory;
import com.codesquad.sidedish.order.domain.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JwtTest {

	@Test
	@DisplayName("JWT 복호화 테스트")
	void jwtDecodeTest() {
		User user = new User("nathan29849", null);
		String jws = JwtFactory.create(user, 86400);
		Claims claims = Jwts.parserBuilder()
			.setSigningKey(JwtFactory.key)
			.build()
			.parseClaimsJws(jws)
			.getBody();

		String userId = (String) claims.get("userId");
		assertThat("nathan29849").isEqualTo(userId);
	}

}
