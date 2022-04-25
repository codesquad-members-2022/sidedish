package kr.codesquad.sidedish.controller;

import kr.codesquad.sidedish.service.DishService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.RequestParam;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(DishController.class)
class DishControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    private DishService dishService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void showOne() throws Exception {

        mvc.perform(get("/dishes/1")).
                andExpect(status().isOk());

    }

    @Test
    void showPagedDishes() throws Exception {

        mvc.perform(get("/dishes")
                .param("categoryId", "1")
                .param("lastDishId", "4"))
                .andExpect(status().isOk());
    }
}
