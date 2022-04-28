package com.terria.sidedish.api;

import com.terria.sidedish.dto.response.exhibition.ExhibitionResponse;
import com.terria.sidedish.service.ExhibitionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;

@Api(tags = "ExhibitionController")
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/exhibitions")
public class ExhibitionController {

    private final ExhibitionService exhibitionService;

    @ApiOperation(
            value = "특정 기획전에 속한 카테고리 목록 조회",
            notes = "특정 기획전속한 카테고리 목록을 조회한다.",
            produces = "application/json",
            response = ExhibitionResponse.class
    )
    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "exhibitionId",
                    value = "기획전 아이디",
                    paramType = "path",
                    dataType = "long"
            )
    })
    @GetMapping("/{exhibitionId}")
    public ExhibitionResponse getByExhibitionId(
            @PathVariable
            @Positive(message = "기획전 아이디 입력값이 부적절합니다. (1. 일반 진열 상품, 2. 기획전: 한 번 주문하면 두 번 반하는 반찬)") long exhibitionId) {

        return exhibitionService.getByExhibitionId(exhibitionId);
    }
}
