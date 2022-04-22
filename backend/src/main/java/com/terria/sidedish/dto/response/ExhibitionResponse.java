package com.terria.sidedish.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ExhibitionResponse {

    private long exhibitionId;
    private String exhibitionTitle;
    private List<CategoryResponse> categoryResponses;

    public static ExhibitionResponse from(long exhibitionId, String exhibitionTitle, List<CategoryResponse> categoryResponses) {
        return new ExhibitionResponse(exhibitionId, exhibitionTitle, categoryResponses);
    }
}
