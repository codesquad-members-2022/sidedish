package sidedish.com.domain;

import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Table("PRODUCT_IMAGE")
@ToString
public class Image {

	@Id
	private Long id;
	private String imageUrl;

	public Image(String imageUrl) {
		this.imageUrl = imageUrl;
	}
}
