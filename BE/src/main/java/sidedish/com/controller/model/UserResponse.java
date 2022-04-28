package sidedish.com.controller.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserResponse {

	@JsonIgnore
	private Long id;
	private String userName;
	private String avatarImageURL;
}
