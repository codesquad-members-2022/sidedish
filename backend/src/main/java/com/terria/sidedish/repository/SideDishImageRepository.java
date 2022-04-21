package com.terria.sidedish.repository;

import com.terria.sidedish.domain.Category;
import com.terria.sidedish.domain.SideDishImage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SideDishImageRepository extends CrudRepository<SideDishImage, Long>  {

    Optional<SideDishImage> findByIdAndImageSeq(Long sideDishId, int imageSeq);
}
