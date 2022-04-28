package team31.codesuqad.sidedish.controller.dto;

import java.util.List;

public class RecommandDto {

    private List<DishDto> dishes;
    private Integer totalPages;

    public RecommandDto(List<DishDto> dishes, Integer totalPages) {
        this.dishes = dishes;
        this.totalPages = totalPages;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public List<DishDto> getDishes() {
        return dishes;
    }

}
