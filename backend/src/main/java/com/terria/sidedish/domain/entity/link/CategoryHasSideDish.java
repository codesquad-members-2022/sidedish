package com.terria.sidedish.domain.entity.link;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
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
