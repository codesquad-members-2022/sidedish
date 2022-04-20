package com.terria.sidedish.api;

import com.terria.sidedish.domain.SideDish;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "SideDishController")
@RestController
@RequestMapping("/sidedishes")
class SideDishController {

    @ApiOperation(
            value = "모든 반찬 목록 조회",
            notes = "모든 반찬 목록을 조회한다.",
            produces = "application/json",
            response = ResponseEntity.class
    )
    @ApiResponses({
            @ApiResponse(
                    code = 200,
                    message = "조회 성공"
            ),
            @ApiResponse(
                    code = 500,
                    message = "서버 에러"
            )
    })
    @GetMapping
    public ResponseEntity<List<SideDish>> getAll() {
        return ResponseEntity.ok().build();
    }

    @ApiOperation(
            value = "특정 기획전에 속한 반찬 목록 조회",
            notes = "특정 기획전 반찬 목록을 조회한다.",
            produces = "application/json",
            response = ResponseEntity.class
    )
    @ApiResponses({
            @ApiResponse(
                    code = 200,
                    message = "조회 성공"
            ),
            @ApiResponse(
                    code = 500,
                    message = "서버 에러"
            )
    })
    @GetMapping("/divisions/{divisionId}/categories/{categoryId}")
    public ResponseEntity<List<SideDish>> getGroupByDivisionIdAndCategoryId(
            @PathVariable long divisionId,
            @PathVariable long categoryId) {

        return ResponseEntity.ok().build();
    }

    @ApiOperation(
            value = "해당 카테고리에 속한 반찬의 일정 개수만큼 조회",
            notes = "해당 카테고리에 속한 반찬의 일정 개수만큼 조회한다.",
            produces = "application/json",
            response = ResponseEntity.class
    )
    @ApiResponses({
            @ApiResponse(
                    code = 200,
                    message = "조회 성공"
            ),
            @ApiResponse(
                    code = 500,
                    message = "서버 에러"
            )
    })
    @GetMapping("/categories/{categoryId}/{startPage}")
    public ResponseEntity<List<SideDish>> getGroupByCategoryId(
            @PathVariable long categoryId,
            @PathVariable int startPage) {

        return ResponseEntity.ok().build();
    }
}
