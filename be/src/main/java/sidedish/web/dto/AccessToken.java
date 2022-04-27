package sidedish.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AccessToken {

	private String accessToken;
	private String scope;
	private String tokenType;
}
