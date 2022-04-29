package team31.codesuqad.sidedish.domain;

import org.springframework.data.annotation.Id;

import java.util.Objects;

public class Images {

    @Id
    private Long imageId;
    private String type;
    private String url;

    public Images(Long imageId, String type, String url) {
        this.imageId = imageId;
        this.type = type;
        this.url = url;
    }

    public boolean isSameType(String type) {
        return Objects.equals(this.type, type);
    }

    public Long getImageId() {
        return imageId;
    }

    public String getType() {
        return type;
    }

    public String getUrl() {
        return url;
    }

}
