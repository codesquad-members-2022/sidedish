package com.terria.sidedish.domain.entity.aggregate;

import lombok.*;
import org.springframework.data.annotation.Id;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Exhibition {

    @Id
    private long id;
    private String title;

    @Override
    public String toString() {
        return "Exhibition{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
