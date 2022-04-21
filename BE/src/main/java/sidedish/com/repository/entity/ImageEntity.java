package sidedish.com.repository.entity;

import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Table("PRODUCT_IMAGE")
@ToString
public class ImageEntity {

	@Id
	private Long id;
	private String imageUrl;

	public ImageEntity(String imageUrl) {
		this.imageUrl = imageUrl;
	}
}
