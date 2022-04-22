package com.sidedish.domain;

import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("image_file")
public class ImageFile {

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

    public boolean hasMainImageType() {
        return imageType.equals("main");
    }

    public String getSaveFileName() {
        return saveFileName;
    }
}
