package com.terria.sidedish.api;

import com.terria.sidedish.dto.response.SideDishDetailResponse;
import com.terria.sidedish.service.SideDishService;
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

@Api(tags = "SideDishController")
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/sidedishes")
public class SideDishController {

    private final SideDishService sideDishService;

    @ApiOperation(
            value = "반찬 상세 정보 조회",
            notes = "반찬 상세 정보를 조회한다.",
            produces = "application/json",
            response = SideDishDetailResponse.class
    )
    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "sideDishId",
                    value = "반찬 아이디",
                    paramType = "path",
                    dataType = "long"
            )
    })
    @GetMapping("/{sideDishId}")
    public SideDishDetailResponse getByCategoryId(
            @PathVariable
            @Positive(message = "반찬 아이디 입력값이 부적절합니다.") long sideDishId) {

        // TODO
        return null;
    }
}
