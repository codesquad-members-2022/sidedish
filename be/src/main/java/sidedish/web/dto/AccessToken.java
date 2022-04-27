package sidedish.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AccessToken {

	private String access_token;
	private String scope;
	private String token_type;

	@Override
	public String toString() {
		return "AccessToken{" +
			"access_token='" + access_token + '\'' +
			", scope='" + scope + '\'' +
			", token_type='" + token_type + '\'' +
			'}';
	}
}
