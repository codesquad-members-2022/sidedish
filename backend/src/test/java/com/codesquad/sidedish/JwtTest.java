package com.codesquad.sidedish;

import com.codesquad.sidedish.auth.JwtFactory;
import com.codesquad.sidedish.order.domain.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class JwtTest {

	@Test
	void JWT_복호화_테스트(){
		User user = new User("nathan29849", null);
		String jws = JwtFactory.create(user, 86400);
		Claims claims = Jwts.parserBuilder().setSigningKey(JwtFactory.key).build().parseClaimsJws(jws)
			.getBody();
		System.out.println(jws);
		System.out.println(claims);
		String userId = (String) claims.get("userId");
		System.out.println(userId);
		Assertions.assertThat("nathan29849").isEqualTo(userId);
	}

}
