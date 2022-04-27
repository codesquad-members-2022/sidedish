package com.codesquad.sidedish.item.controller;

import com.codesquad.sidedish.item.dto.CategoryItemDto;
import com.codesquad.sidedish.item.dto.CategoryItemsDto;
import com.codesquad.sidedish.item.dto.DetailItemDto;
import com.codesquad.sidedish.item.service.ItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "items", description = "반찬 조회 API")
@RequestMapping("/items")
@RestController
public class ItemController {
    private static final Logger log = LoggerFactory.getLogger(ItemController.class);

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "반찬 목록 조회 성공", content = @Content(schema = @Schema(implementation = CategoryItemsDto.class))),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 카테고리 접근", content = @Content)
    })
    @Operation(summary = "반찬 목록 조회", description = "특정 카테고리의 판매하는 반찬의 목록을 조회합니다.", parameters = @Parameter(name = "categoryId", description = "카테고리의 id (메인=1,국물=2,밑반찬=3)"))
    @GetMapping("/{categoryId}")
    public CategoryItemDto itemList(@PathVariable int categoryId) {
        return itemService.findByCategory(categoryId);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "반찬 조회 성공", content = @Content(schema = @Schema(implementation = DetailItemDto.class))),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 리소스 접근", content = @Content)
    })
    @Operation(summary = "반찬 상세정보 조회", description = "판매하는 반찬의 상세 정보를 확인합니다.", parameters = @Parameter(name = "id", description = "반찬의 id"))
    @GetMapping("/detail/{id}")
    public DetailItemDto detail(@PathVariable int id) {
        return itemService.findById(id);
    }
}
