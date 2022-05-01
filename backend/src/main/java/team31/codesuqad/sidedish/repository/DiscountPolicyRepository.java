package team31.codesuqad.sidedish.repository;

import org.springframework.data.repository.CrudRepository;
import team31.codesuqad.sidedish.domain.DiscountPolicy;

import java.util.List;

public interface DiscountPolicyRepository extends CrudRepository<DiscountPolicy, Integer> {

    @Override
    List<DiscountPolicy> findAll();

}
