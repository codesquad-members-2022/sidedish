package com.terria.sidedish.domain.entity.aggregate;

import lombok.*;
import org.springframework.data.annotation.Id;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Category {

    @Id
    private long id;
    private String title;
    private long exhibitionId;

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", exhibitionId=" + exhibitionId +
                '}';
    }
}
