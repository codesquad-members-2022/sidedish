package team31.codesuqad.sidedish.repository;

import org.springframework.data.repository.CrudRepository;
import team31.codesuqad.sidedish.domain.DiscountPolicies;

import java.util.List;

public interface DiscountPoliciesRepository extends CrudRepository<DiscountPolicies, Integer> {

    @Override
    List<DiscountPolicies> findAll();

}
