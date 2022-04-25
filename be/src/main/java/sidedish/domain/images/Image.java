package sidedish.domain.images;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Image {

	@Id
	private Long id;
	private String url;
	private boolean mainStatus;
}
