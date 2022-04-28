package sidedish.domain.member;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Embedded;
import sidedish.web.dto.AccessToken;
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Member {
	@Id
	private Long id;
	private String email;
	@Embedded.Nullable
	private AccessToken accessToken;

	public Member(String email, AccessToken accessToken) {
		this.email = email;
		this.accessToken = accessToken;
	}

	@Override
	public String toString() {
		return "Member{" +
				"id=" + id +
				", email='" + email + '\'' +
				", accessToken=" + accessToken +
				'}';
	}
}
