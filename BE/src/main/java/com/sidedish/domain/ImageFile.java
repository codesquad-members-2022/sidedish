package com.sidedish.domain;

import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("image_file")
public class ImageFile {

    @Id
    private Long id;
    private Long sidedishId;
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

    public ImageFile(Long id, Long sidedishId, String fileName, String saveFileName,
        String contentType, String imageType, boolean deleteFlag,
        LocalDateTime createdDateTime, LocalDateTime modifiedDateTime) {
        this.id = id;
        this.sidedishId = sidedishId;
        this.fileName = fileName;
        this.saveFileName = saveFileName;
        this.contentType = contentType;
        this.imageType = imageType;
        this.deleteFlag = deleteFlag;
        this.createdDateTime = createdDateTime;
        this.modifiedDateTime = modifiedDateTime;
    }

    public boolean hasMainImageType() {
        return imageType.equals("main");
    }

    public String getSaveFileName() {
        return saveFileName;
    }
}
