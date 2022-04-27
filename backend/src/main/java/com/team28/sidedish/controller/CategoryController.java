package com.team28.sidedish.controller;

import com.team28.sidedish.controller.dto.CategoryResponse;
import com.team28.sidedish.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "categories", description = "카테고리 API")
@RestController
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @Operation(summary = "카테고리 목록 조회",
            description = "모든 카테고리 목록을 조회합니다.",
            responses = {
                @ApiResponse(responseCode = "200",
                        description = "카테고리 목록 조회 성공",
                        content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = CategoryResponse.class))
                            )
                        })
            }
    )
    @GetMapping("/categories")
    public ResponseEntity<List<CategoryResponse>> getCategories() {
        return ResponseEntity.ok().body(categoryService.findAll());
    }
}
