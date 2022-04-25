package com.sidedish.domain;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@AllArgsConstructor
@Table("image_file")
public class ImageFile {

    private static final String MAIN_IMAGE_TYPE = "main";

    @Id
    private Integer id;
    private Integer sidedishId;
    private String fileName;
    private String saveFileName;
    private String contentType;
    private String imageType;
    @Column("delete_flag")
    private boolean deleteFlag;
    @Column("created_datetime")
    private LocalDateTime createdDateTime;
    @Column("modified_datetime")
    private LocalDateTime modifiedDateTime;

    public boolean isMainImageType() {
        return imageType.equals(MAIN_IMAGE_TYPE);
    }

    public String getSaveFileName() {
        return saveFileName;
    }
}
