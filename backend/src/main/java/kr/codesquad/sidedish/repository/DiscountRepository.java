package kr.codesquad.sidedish.repository;

import kr.codesquad.sidedish.domain.Discount;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DiscountRepository extends CrudRepository<Discount, Long> {

    @Override
    List<Discount> findAllById(Iterable<Long> ids);
}
