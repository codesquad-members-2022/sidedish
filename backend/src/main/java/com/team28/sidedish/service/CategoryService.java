package com.team28.sidedish.service;

import com.team28.sidedish.controller.dto.CategoryResponse;

import java.util.List;

public interface CategoryService {

    List<CategoryResponse> findAll();
}
