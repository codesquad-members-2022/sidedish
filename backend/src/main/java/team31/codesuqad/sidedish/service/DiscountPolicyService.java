package team31.codesuqad.sidedish.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team31.codesuqad.sidedish.domain.DiscountPolicy;
import team31.codesuqad.sidedish.domain.Dish;
import team31.codesuqad.sidedish.repository.DiscountPolicyRepository;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class DiscountPolicyService {

    private final DiscountPolicyRepository discountPolicyRepository;
    private Map<Integer, DiscountPolicy> discountPolicyMap;

    public DiscountPolicyService(DiscountPolicyRepository discountPolicyRepository) {
        this.discountPolicyRepository = discountPolicyRepository;
        this.discountPolicyMap = makeDiscountPolicyMap();
    }

    @Transactional(readOnly = true)
    public List<DiscountPolicy> findAll() {
        return discountPolicyRepository.findAll();
    }

    public Map<Integer, DiscountPolicy> makeDiscountPolicyMap() {
        return findAll().stream()
                .collect(Collectors.toMap(DiscountPolicy::getId, Function.identity()));
    }

    public Map<Integer, DiscountPolicy> getDiscountPolicyMap() {
        return discountPolicyMap;
    }

    public void mappingDiscountPolicies(List<Dish> dishes) {
        for (Dish dish : dishes) {
            dish.mappingDiscountPolicies(discountPolicyMap);
        }
    }

}
