package com.example.be.business.dish.repository;

import com.example.be.business.dish.domain.Image;
import org.springframework.data.repository.CrudRepository;

/**
 * 애그리게잇 삭제 테스트를 위해 존재하는 레포지토리
 * 각 애그리게잇 당 하나의 레포지토리만 가지기 때문에
 * 개발 환경에서는 사용하지 않습니다.
 */
public interface ImageRepository extends CrudRepository<Image, Long> {
}
