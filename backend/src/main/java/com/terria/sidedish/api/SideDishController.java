package com.terria.sidedish.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "SideDishController")
@RestController
@RequestMapping("/sidedish")
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
    public ResponseEntity<?> getSideDishes() {
        return ResponseEntity.ok().build();
    }
}
