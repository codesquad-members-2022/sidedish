package kr.codesquad.sidedish.controller.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Map;

@Data
public class ProductListRequest {

    private static final Map<String, String> SORTING_RULES = Map.of(
            "recommended", "RAND()",
            "random", "RAND()"
    );

    private Long categoryId;
    private Long specialCategoryId;
    private Long page = 1L;
    private Integer pageSize = 30;
    private String sort = "";

    @JsonIgnore
    public Long getOffset() {
        return (page - 1) * pageSize;
    }

    @JsonIgnore
    public String getSortRule() {
        return SORTING_RULES.getOrDefault(sort, null);
    }
}
