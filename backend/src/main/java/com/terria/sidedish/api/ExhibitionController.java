package com.terria.sidedish.api;

import com.terria.sidedish.dto.response.ExhibitionResponse;
import com.terria.sidedish.error.ErrorCode;
import com.terria.sidedish.error.ErrorResponse;
import com.terria.sidedish.error.ExhibitionException;
import com.terria.sidedish.service.ExhibitionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

@Api(tags = "ExhibitionController")
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
    @GetMapping("/{exhibitionId}")
    public ResponseEntity<ExhibitionResponse> getByExhibitionId(
            @PathVariable @Validated @Positive @Min(1) long exhibitionId) {

        return ResponseEntity.ok(exhibitionService.getByExhibitionId(exhibitionId));
    }

    @ExceptionHandler(ExhibitionException.class)
    private ResponseEntity<ErrorResponse> handleCardRuntimeException(ExhibitionException e) {
        ErrorCode errorCode = e.getErrorCode();
        return new ResponseEntity<>(ErrorResponse.of(errorCode), errorCode.getStatus());
    }
}
