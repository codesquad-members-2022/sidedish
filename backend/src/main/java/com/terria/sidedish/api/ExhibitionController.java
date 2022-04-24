package com.terria.sidedish.api;

import com.terria.sidedish.dto.response.ExhibitionResponse;
import com.terria.sidedish.error.ErrorCode;
import com.terria.sidedish.error.ErrorResponse;
import com.terria.sidedish.error.ExhibitionException;
import com.terria.sidedish.service.ExhibitionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.stream.Collectors;

@Api(tags = "ExhibitionController")
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/exhibitions")
public class ExhibitionController {

    private final ExhibitionService exhibitionService;

    @ApiOperation(
            value = "특정 기획전에 속한 데이터(카테고리, 반찬 카드) 조회",
            notes = "특정 기획전에 속한 데이터(카테고리, 반찬 카드)를 조회한다.",
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
