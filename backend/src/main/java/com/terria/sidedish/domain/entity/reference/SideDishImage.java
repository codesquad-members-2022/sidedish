package com.terria.sidedish.domain.entity.reference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;

@Getter
@AllArgsConstructor
public class SideDishImage {

    @Id
    private long id;
    private String imageUrl;
    private int imageSeq;
    private long sideDishId;

    @Override
    public String toString() {
        return "SideDishImage{" +
                "id=" + id +
                ", imageUrl='" + imageUrl + '\'' +
                ", imageSeq=" + imageSeq +
                ", sideDishId=" + sideDishId +
                '}';
    }
}
