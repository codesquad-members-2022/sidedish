package com.sidedish.api.categories;

import com.sidedish.domain.*;
import com.sidedish.repository.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import static org.springframework.restdocs.headers.HeaderDocumentation.*;
import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.linkWithRel;
import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.links;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.relaxedResponseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Transactional
@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureRestDocs
class CategoryIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CategoryRepository categoryRepository;

    @BeforeEach
    void init() {
        Category mainCategory = new Category(CategoryType.MAIN);
        Category sidedishCategory = new Category(CategoryType.SIDE);
        Category soupCategory = new Category(CategoryType.SOUP);

        createItem(mainCategory, "고기1", "풍성한고기반찬");
        createItem(mainCategory, "고기2", "풍성한고기반찬");
        createItem(mainCategory, "고기3", "풍성한고기반찬");
        createItem(mainCategory, "고기4", "풍성한고기반찬");
        createItem(mainCategory, "고기5", "풍성한고기반찬");
        createItem(mainCategory, "고기6", "풍성한고기반찬");

        createItem(soupCategory, "햄가득 부대찌개", "우리아이영양반찬");
        createItem(soupCategory, "햄가득 부대찌개", "우리아이영양반찬");
        createItem(soupCategory, "햄가득 부대찌개", "우리아이영양반찬");
        createItem(soupCategory, "햄가득 부대찌개", "우리아이영양반찬");

        createItem(sidedishCategory, "콩나물1", "편리한반찬세트");
        createItem(sidedishCategory, "콩나물2", "편리한반찬세트");
        createItem(sidedishCategory, "콩나물3", "편리한반찬세트");
        createItem(sidedishCategory, "콩나물4", "편리한반찬세트");
        createItem(sidedishCategory, "꼬막무침1", "맛있는제철요리");
        createItem(sidedishCategory, "꼬막무침2", "맛있는제철요리");
        createItem(sidedishCategory, "꼬막무침3", "맛있는제철요리");
        createItem(sidedishCategory, "꼬막무침4", "맛있는제철요리");


        categoryRepository.save(mainCategory);
        categoryRepository.save(soupCategory);
        categoryRepository.save(sidedishCategory);
    }

    private static void createItem(Category mainCategory, String name, String detailtype) {
        Item newItem = new Item(name, "반찬 설명", BigDecimal.valueOf(10000),
                10.0, Badge.EVENT, detailtype, 10, BigDecimal.valueOf(100), new Images("mainUrl", "one", "two"));
        mainCategory.saveItem(newItem);
    }

    @Test
    @DisplayName("1 페이지 요청시 4개의 아이템을 반환해야 한다.")
    void find_main_category_use_pageId_test() throws Exception {
        // given
        ResultActions requestThenResult = mockMvc.
                perform(get("/api/categories/main?pageId=1&pageCount=4")
                        .contentType(MediaType.APPLICATION_JSON)
                );

        // when
        requestThenResult.andDo(print())
                .andExpect(status().isOk())
                .andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaTypes.HAL_JSON_VALUE))
                .andExpect(jsonPath("itemResource[0]").exists())
                .andExpect(jsonPath("itemResource[1]").exists())
                .andExpect(jsonPath("itemResource[2]").exists())
                .andExpect(jsonPath("itemResource[3]").exists())
                .andExpect(jsonPath("itemResource.length()").value(4))
                .andExpect(jsonPath("_links.self").exists())
                .andExpect(jsonPath("_links.prev-page").exists())
                .andExpect(jsonPath("_links.next-page").exists())
                .andDo(document("search-main",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                        links(
                                linkWithRel("self").description("link to self"),
                                linkWithRel("prev-page").description("link to prev page"),
                                linkWithRel("next-page").description("link to next page")
                        ),
                        requestHeaders(
                                headerWithName(HttpHeaders.CONTENT_TYPE).description("accept headers")
                        ),
                        responseHeaders(
                                headerWithName(HttpHeaders.CONTENT_TYPE).description("Content type")
                        ),
                        relaxedResponseFields(
                                fieldWithPath("_links.self").description("link of main type item"),
                                fieldWithPath("itemResource[0].id").description("id of item"),
                                fieldWithPath("itemResource[0].title").description("title of item"),
                                fieldWithPath("itemResource[0].description").description("description of item"),
                                fieldWithPath("itemResource[0].price").description("price of item"),
                                fieldWithPath("itemResource[0].badge").description("Event name of item"),
                                fieldWithPath("itemResource[0].discountPrice").description("discountPrice of item"),
                                fieldWithPath("itemResource[0].rewardPoint").description("rewardPoint of item"),
                                fieldWithPath("itemResource[0].images").description("images of item")
                        )
                ));
    }

    @Test
    @DisplayName("단건의 아이템을 조회 해오는 테스트")
    public void find_single_item_test() throws Exception {
        //given
        Category mainCategory = new Category(CategoryType.MAIN);
        Item newItem = new Item("소불고기", "반찬 설명", BigDecimal.valueOf(10000),
                10.0, Badge.EVENT, "풍성한고기반찬", 10, BigDecimal.valueOf(100), new Images("mainUrl", "one", "two"));
        mainCategory.saveItem(newItem);
        categoryRepository.save(mainCategory);
        Long itemId = newItem.getId();

        // when & then
        ResultActions requestThenResult = mockMvc.perform(get("/api/categories/items/" + itemId)
                .accept(MediaTypes.HAL_JSON_VALUE));

        requestThenResult.andDo(print())
                .andExpect(status().isOk())
                .andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaTypes.HAL_JSON_VALUE))
                .andExpect(jsonPath("item.links[0].rel").value("self"))
                .andDo(document("search-single",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                        responseHeaders(
                                headerWithName(HttpHeaders.CONTENT_TYPE).description("Content type")
                        ),
                        relaxedResponseFields(
                                fieldWithPath("item.id").description("id of item"),
                                fieldWithPath("item.title").description("title of item"),
                                fieldWithPath("item.description").description("description of item"),
                                fieldWithPath("item.price").description("price of item"),
                                fieldWithPath("item.badge").description("badge of item"),
                                fieldWithPath("item.discountPrice").description("discountPrice of item"),
                                fieldWithPath("item.rewardPoint").description("rewardPoint of item"),
                                fieldWithPath("item.images").description("images of item")
                        )
                ));
    }
}
