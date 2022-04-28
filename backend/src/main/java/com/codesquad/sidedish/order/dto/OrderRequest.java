package com.codesquad.sidedish.order.dto;

import javax.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class OrderRequest {

    @NotNull(message = "유저의 GitHub 아이디는 필수 입력값입니다.")
    private String githubId;

    @NotNull(message = "반찬 Id는 필수 입력값입니다.")
    private Integer dishId;

    @NotNull(message = "반찬 수량은 필수 입력값입니다.")
    private Integer quantity;

}
