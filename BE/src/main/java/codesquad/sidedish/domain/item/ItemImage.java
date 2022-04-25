package codesquad.sidedish.domain.item;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class ItemImage {
    private Long itemImageId;
    private int itemImageSequence;
    private ItemImageType itemImageType;

    public ItemImage(int itemImageSequence, ItemImageType itemImageType) {
        this.itemImageSequence = itemImageSequence;
        this.itemImageType = itemImageType;
    }

    @Builder
    public ItemImage(Long itemImageId, int itemImageSequence, ItemImageType itemImageType) {
        this.itemImageId = itemImageId;
        this.itemImageSequence = itemImageSequence;
        this.itemImageType = itemImageType;
    }

    public void initItemImageId(Long itemImageId) {
        this.itemImageId = itemImageId;
    }
}
