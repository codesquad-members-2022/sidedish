package kr.codesquad.sidedish.domain;

import org.springframework.data.relational.core.mapping.Column;

public class Image {

    private final Long id;
    @Column("NAME")
    private final String path;

    public Image(Long id, String path) {
        this.id = id;
        this.path = path;
    }

    public Long getId() {
        return id;
    }

    public String getPath() {
        return path;
    }

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", path='" + path + '\'' +
                '}';
    }
}
