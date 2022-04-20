package com.terria.sidedish.api;

import com.terria.sidedish.domain.Category;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "CategoryController")
@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {

    @ApiOperation(
            value = "특정 기획전에 속한 카테고리 조회",
            notes = "특정 기획전에 속한 카테고리를 조회한다.",
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
    @GetMapping("/exhibitions/{exhibitionId}")
    public ResponseEntity<List<Category>> getGroupByDivisionId(@PathVariable long exhibitionId) {
        return ResponseEntity.ok().build();
    }
}
