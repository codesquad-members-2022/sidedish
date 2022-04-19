package kr.codesquad.sidedish.domain;

public class Image {

    private final Long id;
    private final String name;
    private final Long dishId;

    public Image(Long id, String name, Long dishId) {
        this.id = id;
        this.name = name;
        this.dishId = dishId;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getDishId() {
        return dishId;
    }
}
