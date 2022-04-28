package codesquad.sidedish.domain.item;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class ItemSection {
    private Long itemSectionId;
    private String itemSectionName;

    public ItemSection(String itemSectionName) {
        this.itemSectionName = itemSectionName;
    }

    public ItemSection(Long itemSectionId, String itemSectionName) {
        this.itemSectionId = itemSectionId;
        this.itemSectionName = itemSectionName;
    }

    public void initItemSectionId(Long itemSectionId) {
        this.itemSectionId = itemSectionId;
    }
}
