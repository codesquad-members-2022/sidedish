package codesquad.sidedish.web.dto;

import lombok.Getter;

@Getter
public class ItemListElement {
    private Long itemId = 1L;
    private String name = "sampleItem";
    private String description = "샘플 아이템입니다.";
    private int originalPrice = 10000;
    private int discountedPrice = 9000;
    private String discountPolicy = "이벤트특가";
    private String mainImage = "https://i.imgur.com/A14QwVW.jpeg";

    public ItemListElement () {
    }
}
