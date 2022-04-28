package sidedish.com.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class User {

	@JsonProperty("login")
	private String userName;

	@JsonProperty("avatar_url")
	private String avatarImageURL;

	@JsonProperty("email")
	private String email;

}
