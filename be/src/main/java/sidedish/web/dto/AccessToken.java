package sidedish.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
public class AccessToken {

	@JsonProperty("access_token")
	private String accessToken;
	@JsonProperty("token_type")
	private String tokenType;
	@JsonProperty("scope")
	private String scope;

	@Override
	public String toString() {
		return "AccessToken{" +
				"accessToken='" + accessToken + '\'' +
				", scope='" + scope + '\'' +
				", tokenType='" + tokenType + '\'' +
				'}';
	}
}
