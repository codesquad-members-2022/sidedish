package kr.codesquad.sidedish.service;

import java.util.List;
import java.util.stream.Collectors;

import kr.codesquad.sidedish.domain.DishType;
import kr.codesquad.sidedish.domain.Product;
import kr.codesquad.sidedish.controller.RequestProduct;
import kr.codesquad.sidedish.domain.SideDishType;
import kr.codesquad.sidedish.exception.CustomException;
import kr.codesquad.sidedish.repository.ProductRepository;
import kr.codesquad.sidedish.response.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

	private final ProductRepository productRepository;

	public List<ProductDTO> findAll() {
		return productRepository.findAll()
			.stream()
			.map(p -> ProductDTO.from(p))
			.collect(Collectors.toList());
	}

	public List<ProductDTO> loadDishListByType(DishType dishType) {
		return productRepository.loadDishListByType(dishType.getType()).stream()
			.map(p -> ProductDTO.from(p))
			.collect(Collectors.toList());
	}

	public List<ProductDTO> loadSideDishListByType(DishType dishType, SideDishType sideDishType) {
		ServiceValidator.checkDishTypeIsSide(dishType);
		return productRepository.loadSideDishListByType(dishType.getType(), sideDishType.getType())
			.stream()
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
