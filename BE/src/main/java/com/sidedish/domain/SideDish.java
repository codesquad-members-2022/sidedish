package com.sidedish.domain;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Embedded;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Table("sidedish")
public class SideDish {

    @Id
    private Long id;
    private Long eventCategoryId;
    private String name;
    private String description;
    private boolean dawnDeliveryFlag;
    private boolean wholeNationDeliveryFlag;
    private LocalDateTime createdDateTime;
    private LocalDateTime modifiedDateTime;

    @Embedded.Nullable
    private SideDishPrice sideDishPrice;

    @MappedCollection(idColumn = "sidedish_id", keyColumn = "id")
    private List<ImageFile> imageFiles;

    public SideDish(Long id, Long eventCategoryId, String name, String description,
        boolean dawnDeliveryFlag, boolean wholeNationDeliveryFlag,
        LocalDateTime createdDateTime, LocalDateTime modifiedDateTime) {
        this.id = id;
        this.eventCategoryId = eventCategoryId;
        this.name = name;
        this.description = description;
        this.dawnDeliveryFlag = dawnDeliveryFlag;
        this.wholeNationDeliveryFlag = wholeNationDeliveryFlag;
        this.createdDateTime = createdDateTime;
        this.modifiedDateTime = modifiedDateTime;
    }

    public String getMainImage() {
        String saveFileName = null;
        for (ImageFile imageFile : imageFiles) {
            if (imageFile.hasMainImageType()) {
                saveFileName = imageFile.getSaveFileName();
            }
        }

        return saveFileName;
    }

    public Integer getPriceOfSideDish() {
        return sideDishPrice.getPrice();
    }

    public Integer getDiscountRateOfSideDish() {
        return sideDishPrice.getDiscountRate();
    }

    public String getDiscountTypeOfSideDish() {
        return sideDishPrice.getDiscountType();
    }
}
