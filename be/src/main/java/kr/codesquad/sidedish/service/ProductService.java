package kr.codesquad.sidedish.service;

import kr.codesquad.sidedish.controller.RequestProduct;
import kr.codesquad.sidedish.domain.DishType;
import kr.codesquad.sidedish.domain.Product;
import kr.codesquad.sidedish.domain.SideDishType;
import kr.codesquad.sidedish.exception.CustomException;
import kr.codesquad.sidedish.repository.ProductRepository;
import kr.codesquad.sidedish.response.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    public static final int NEED_PRODUCT_QUANTITY = 3;

    private final ProductRepository productRepository;

    public List<ProductDTO> findAll() {
        return productRepository.findAll()
                .stream()
                .map(p -> ProductDTO.from(p))
                .collect(Collectors.toList());
    }

    public List<ProductDTO> loadDishListByType(DishType dishType) {
        return productRepository.loadDishListByType(dishType.getName()).stream()
                .map(p -> ProductDTO.from(p))
                .collect(Collectors.toList());
    }

    public List<ProductDTO> loadSideDishListByType(DishType dishType, SideDishType sideDishType) {
        ServiceValidator.checkDishTypeIsSide(dishType);
        List<Product> sideDishProducts = productRepository.loadSideDishListByType(dishType.getName(), sideDishType.getName());
        Collections.shuffle(sideDishProducts);

        return sideDishProducts.stream()
                .limit(NEED_PRODUCT_QUANTITY)
                .map(p -> ProductDTO.from(p))
                .collect(Collectors.toList());
    }

    public ProductDTO findById(Integer id) {
        return ProductDTO.from(productRepository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorCode.PRODUCT_ID_NOT_ALLOWED)));
    }

    public void order(RequestProduct requestProduct) {

        Product product = productRepository.findById(requestProduct.getId()).get();
        ServiceValidator.checkRemainingProductQuantity(product.getQuantity(),
                requestProduct.getQuantity());

        productRepository.updateQuantity(requestProduct.getId(),
                requestProduct.getQuantity());
    }
}
