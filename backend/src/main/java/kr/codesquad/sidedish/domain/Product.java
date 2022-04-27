package kr.codesquad.sidedish.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor
@ToString
public class Product {

    @Id
    private Long id;
    private final String name;
    private final String description;
    private final Integer price;
    private final Float mileageRate;
    private final Integer stock;
    private final String primaryImage;
    private final Long categoryId;
    private final Long subcategoryId;
    private final Long deliveryPolicyId;

    @MappedCollection(idColumn = "product_id")
    Set<VariantImage> variantImages = new HashSet<>();

    @MappedCollection(idColumn = "product_id", keyColumn = "discount_id")
    List<DiscountRef> discountRefs = new ArrayList<>();

    public Set<Long> getDiscountIds() {
        return discountRefs
                .stream()
                .map(DiscountRef::getDiscountId)
                .collect(Collectors.toSet());
    }

    public List<String> getVariantImageUrls() {
        return variantImages
                .stream()
                .map(VariantImage::getUrl)
                .collect(Collectors.toList());
    }
}
