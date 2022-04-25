package kr.codesquad.sidedish.domain;

import lombok.Getter;
import org.springframework.data.annotation.Id;

@Getter
public class Theme {

	@Id
	private Long id;
	private String name;

}
