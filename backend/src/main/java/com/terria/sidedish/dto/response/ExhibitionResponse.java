package com.terria.sidedish.dto.response;

import com.terria.sidedish.domain.entity.aggregate.Exhibition;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@ApiModel
@Getter
@Setter
@AllArgsConstructor
public class ExhibitionResponse {

    @ApiModelProperty(required = true, value = "기획전 아이디")
    private long exhibitionId;

    @ApiModelProperty(required = true, value = "기획전 타이틀")
    private String exhibitionTitle;

    public static ExhibitionResponse from(Exhibition exhibition) {
        return new ExhibitionResponse(exhibition.getId(), exhibition.getTitle());
    }
}
