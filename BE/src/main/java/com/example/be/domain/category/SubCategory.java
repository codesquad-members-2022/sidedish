package com.example.be.domain.category;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("sub_category")
public class SubCategory {

    @Id
    private Long subCategoryId;
    private String descriptionDetail;
    private Country country;

    public SubCategory(String descriptionDetail, Country country) {
        this.descriptionDetail = descriptionDetail;
        this.country = country;
    }
}
