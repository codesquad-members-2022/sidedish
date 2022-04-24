package sidedish.com.repository.entity;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Table("PRODUCT_IMAGE")
public class ImageEntity {

	@Id
	private final Long id;
	private final String imageUrl;

	@PersistenceConstructor
	public ImageEntity(Long id, String imageUrl) {
		this.id = id;
		this.imageUrl = imageUrl;
	}
}
