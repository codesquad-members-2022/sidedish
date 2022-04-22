package com.sidedish.domain;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Table("sidedish")
public class SideDish {

    @Id
    private Integer id;
    private Integer eventCategoryId;
    private Integer menuCategoryId;
    private String name;
    private String description;
    private boolean dawnDeliveryFlag;
    private boolean wholeNationDeliveryFlag;
    private Integer price;
    private Integer discountRate;
    private String discountType;
    private LocalDateTime createdDateTime;
    private LocalDateTime modifiedDateTime;

    @MappedCollection(idColumn = "sidedish_id", keyColumn = "id")
    private List<ImageFile> imageFiles;

    public String getMainImage() {
        String saveFileName = null;
        for (ImageFile imageFile : imageFiles) {
            if (imageFile.hasMainImageType()) {
                saveFileName = imageFile.getSaveFileName();
            }
        }

        return saveFileName;
    }
}
