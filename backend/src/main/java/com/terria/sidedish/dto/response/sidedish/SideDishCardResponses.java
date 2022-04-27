package com.terria.sidedish.dto.response.sidedish;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@ApiModel
@Getter
@Setter
@AllArgsConstructor
public class SideDishCardResponses {

    @ApiModelProperty(required = true, value = "총 개수")
    private int totalCount;

    @ApiModelProperty(required = true, value = "반찬 카드 목록")
    private List<SideDishCardResponse> sideDishCardResponses;
}
