package com.terria.sidedish.dto.response;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@ApiModel
@Getter
@Setter
@AllArgsConstructor
public class CategoryResponses {

    private List<CategoryResponse> categoryResponses;
}
