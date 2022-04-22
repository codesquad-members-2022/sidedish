package kr.codesquad.sidedish.controller.dto;

import kr.codesquad.sidedish.domain.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class CategoryListResponse {

    private List<Category> categories;

}
