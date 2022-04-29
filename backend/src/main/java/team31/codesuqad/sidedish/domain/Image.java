package team31.codesuqad.sidedish.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import team31.codesuqad.sidedish.type.ImageType;

import java.util.Objects;

@Table("images")
public class Image {

    @Id
    private Long imageId;

    private final ImageType type;
    private final String url;

    public Image(ImageType type, String url) {
        this.type = type;
        this.url = url;
    }

    public boolean isSameType(ImageType type) {
        return Objects.equals(this.type, type);
    }

    public Long getImageId() {
        return imageId;
    }

    public ImageType getType() {
        return type;
    }

    public String getUrl() {
        return url;
    }

}
