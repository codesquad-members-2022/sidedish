package com.terria.sidedish.domain.entity.link;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CategoryHasSideDish {

    private long sideDishId;

    @Override
    public String toString() {
        return "CategoryHasSideDish{" +
                "sideDishId=" + sideDishId +
                '}';
    }
}
