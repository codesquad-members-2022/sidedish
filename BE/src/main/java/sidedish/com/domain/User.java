package sidedish.com.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Embedded;

@Getter
@ToString
public class User {

	@Id
	@JsonIgnore
	private Long id;

	@JsonProperty("login")
	private String userName;

	@JsonProperty("avatar_url")
	private String avatarImageURL;

	@JsonProperty("email")
	private String email;

	@Embedded.Nullable
	private GitHubAccessToken accessToken;

	public void setAccessToken(GitHubAccessToken accessToken) {
		this.accessToken = accessToken;
	}
}
