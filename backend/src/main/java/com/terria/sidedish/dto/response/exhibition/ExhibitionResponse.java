package com.terria.sidedish.dto.response.exhibition;

import com.terria.sidedish.domain.entity.aggregate.Exhibition;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@ApiModel
@Getter
@Setter
@AllArgsConstructor
public class ExhibitionResponse {

    @ApiModelProperty(required = true, value = "기획전 아이디")
    private long exhibitionId;

    @ApiModelProperty(required = true, value = "기획전 타이틀")
    private String exhibitionTitle;

    @ApiModelProperty("카테고리 목록")
    private List<CategoryResponse> categoryResponses;

    public static ExhibitionResponse from(Exhibition exhibition, List<CategoryResponse> categoryResponses) {
        return new ExhibitionResponse(exhibition.getId(), exhibition.getTitle(), categoryResponses);
    }
}
