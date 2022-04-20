package com.terria.sidedish.api;

import com.terria.sidedish.domain.OrderSheet;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "OrderController")
@RestController
@RequestMapping("/orders")
public class OrderController {

    @ApiOperation(
            value = "반찬 상세 정보(주문서) 조회",
            notes = "반찬 상세 정보(주문서)를 조회한다.",
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
    @GetMapping("/{sideDishId}")
    public ResponseEntity<List<OrderSheet>> getSheetBySideDishId(@PathVariable long sideDishId) {
        return ResponseEntity.ok().build();
    }

    @ApiOperation(
            value = "주문서를 참고하여 반찬 주문",
            notes = "주문서를 참고하여 반찬을 주문한다.",
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
    @PostMapping
    public ResponseEntity<OrderSheet> createOrderInfo(@ModelAttribute OrderSheet orderSheet) {
        return ResponseEntity.ok().build();
    }
}
