package com.sidedish.api.categories;

import com.sidedish.domain.Badge;
import com.sidedish.domain.Category;
import com.sidedish.domain.CategoryType;
import com.sidedish.domain.Item;
import com.sidedish.repository.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.restdocs.headers.HeaderDocumentation.headerWithName;
import static org.springframework.restdocs.headers.HeaderDocumentation.requestHeaders;
import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.linkWithRel;
import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.links;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Transactional
@ActiveProfiles("local")
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureRestDocs
class CategoryControllerTest {
//
//    @Autowired
//    MockMvc mockMvc;
//
//    @Autowired
//    CategoryRepository categoryRepository;
//
//    @BeforeEach
//    void init() {
//        Category mainCategory = new Category(CategoryType.MAIN);
//
//        Item newItem1 = new Item("고기1", "맛있는 고기1", BigDecimal.valueOf(10000),
//                10.0, Badge.EVENT, "풍성한 고기 반찬", 10, BigDecimal.valueOf(100), "html");
//
//        Item newItem2 = new Item("고기2", "맛있는 고기2", BigDecimal.valueOf(10000),
//                10.0, Badge.EVENT, "풍성한 고기 반찬", 10, BigDecimal.valueOf(100), "html");
//
//        Item newItem3 = new Item("고기3", "맛있는 고기3", BigDecimal.valueOf(10000),
//                10.0, Badge.EVENT, "풍성한 고기 반찬", 10, BigDecimal.valueOf(100), "html");
//
//        mainCategory.saveItem(newItem1);
//        mainCategory.saveItem(newItem2);
//        mainCategory.saveItem(newItem3);
//
//        categoryRepository.save(mainCategory);
//    }
//
//    @Test
//    public void findMainCategoryTest() throws Exception {
//        // given
//        ResultActions requestThenResult = mockMvc.
//                perform(get("/api/categories/1")
//                        .contentType(MediaType.APPLICATION_JSON)
//        );
//
//        // when
//        requestThenResult.andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaTypes.HAL_JSON_VALUE))
//                .andExpect(jsonPath("_embedded.itemList[0]").exists())
//                .andExpect(jsonPath("_embedded.itemList.[1]").exists())
//                .andExpect(jsonPath("_embedded.itemList.[2]").exists())
//                .andExpect(jsonPath("_links.self").exists())
//                .andExpect(jsonPath("_links.prev-page").exists())
//                .andExpect(jsonPath("_links.next-page").exists())
//                .andDo(document("search-main",
//                        links(
//                              linkWithRel("self").description("link to self"),
//                              linkWithRel("prev-page").description("link to prev page"),
//                              linkWithRel("next-page").description("link to next page")
//                        ),
//                        requestHeaders(
//                                headerWithName(HttpHeaders.CONTENT_TYPE).description("accept headers")
//                        ),
//                        requestFields(
//                                fieldWithPath("itemList").description("list of target menu")
//                                fieldWithPath("itemList").description("list of target menu")
//                        )
//                ));
//    }
}
