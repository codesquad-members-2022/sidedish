package com.terria.sidedish.api;

import com.terria.sidedish.dto.response.CategoryResponses;
import com.terria.sidedish.dto.response.ExhibitionResponse;
import com.terria.sidedish.service.CategoryService;
import com.terria.sidedish.service.ExhibitionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Positive;

@Api(tags = "CategoryController")
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @ApiOperation(
            value = "특정 기획전에 속한 카테고리 조회",
            notes = "특정 기획전에 속한 카테고리를 조회한다.",
            produces = "application/json",
            response = CategoryResponses.class
    )
    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "exhibitionId",
                    value = "기획전 아이디",
                    paramType = "path",
                    dataType = "long"
            )
    })
    @GetMapping("/exhibition/{exhibitionId}")
    public CategoryResponses getAllByExhibitionId(
            @PathVariable
            @Positive(message = "기획전 아이디 입력값이 부적절합니다. (1. 일반 진열 상품, 2. 기획전: 한 번 주문하면 두 번 반하는 반찬)") long exhibitionId) {

        return categoryService.getAllByExhibitionId(exhibitionId);
    }
}
