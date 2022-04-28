package team31.codesuqad.sidedish.service;

import org.springframework.stereotype.Service;
import team31.codesuqad.sidedish.domain.Discount;
import team31.codesuqad.sidedish.domain.DiscountPolicies;
import team31.codesuqad.sidedish.domain.Dishes;
import team31.codesuqad.sidedish.repository.DiscountPoliciesRepository;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class DiscountPoliciesService {

    private final DiscountPoliciesRepository discountPoliciesRepository;

    public DiscountPoliciesService(DiscountPoliciesRepository discountPoliciesRepository) {
        this.discountPoliciesRepository = discountPoliciesRepository;
    }

    public List<DiscountPolicies> findAll() {
        return discountPoliciesRepository.findAll();
    }

    public void mappingDiscountPolicies(List<Dishes> dishes) {
        Map<Integer, DiscountPolicies> discountPoliciesMap = findAll().stream()
                .collect(Collectors.toMap(DiscountPolicies::getId, Function.identity()));

        for (Dishes dish : dishes) {
            List<DiscountPolicies> discountPolicies = dish.getDiscounts().stream()
                    .map(Discount::getDiscountPolicyId)
                    .map(discountPoliciesMap::get)
                    .collect(Collectors.toList());
            dish.setEventBadge(discountPolicies);
        }
    }

    public void mappingDishToDiscountPolicies(Dishes dish) {
        Map<Integer, DiscountPolicies> discountPoliciesMap = findAll().stream()
                .collect(Collectors.toMap(DiscountPolicies::getId, Function.identity()));

        List<DiscountPolicies> discountPolicies = dish.getDiscounts().stream()
                .map(Discount::getDiscountPolicyId)
                .map(discountPoliciesMap::get)
                .collect(Collectors.toList());
        dish.setEventBadge(discountPolicies);

    }

}
