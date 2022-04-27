package codesquad.sidedish.web.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class ItemListResponse {
    private List<ItemListElement> items;

    public ItemListResponse (List<ItemListElement> items) {
        this.items = items;
    }
}
