package team31.codesuqad.sidedish.service;

import org.springframework.stereotype.Service;
import team31.codesuqad.sidedish.domain.DiscountPolicies;
import team31.codesuqad.sidedish.repository.DiscountPoliciesRepository;

import java.util.List;

@Service
public class DiscountPoliciesService {

    private final DiscountPoliciesRepository discountPoliciesRepository;

    public DiscountPoliciesService(DiscountPoliciesRepository discountPoliciesRepository) {
        this.discountPoliciesRepository = discountPoliciesRepository;
    }

    public List<DiscountPolicies> findAll() {
        return discountPoliciesRepository.findAll();
    }

}
