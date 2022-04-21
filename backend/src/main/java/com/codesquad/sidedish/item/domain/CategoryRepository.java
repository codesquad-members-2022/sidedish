package com.codesquad.sidedish.item.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
    @Override
    List<Category> findAll();
}
