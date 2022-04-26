package kr.codesquad.sidedish.service;

import java.util.List;
import java.util.stream.Collectors;

import kr.codesquad.sidedish.domain.Dish;
import kr.codesquad.sidedish.domain.Product;
import kr.codesquad.sidedish.controller.RequestProduct;
import kr.codesquad.sidedish.domain.SideDish;
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
			.map(Product::createDTO)
			.collect(Collectors.toList());
	}

	public List<ProductDTO> loadDishListByType(Dish dish) {
		return productRepository.loadDishListByType(dish.getType()).stream()
			.map(Product::createDTO)
			.collect(Collectors.toList());
	}

	public List<ProductDTO> loadSideDishListByType(Dish dish, SideDish sideDish) {
		checkDishTypeIsSide(dish);
		return productRepository.loadSideDishListByType(dish.getType(), sideDish.getType()).stream()
				.map(Product::createDTO)
				.collect(Collectors.toList());
	}

	private void checkDishTypeIsSide(Dish dish) {
		if (Dish.SIDE != dish) {
			throw new CustomException(ErrorCode.SIDE_DISH_ONLY_ALLOWED);
		}
	}

	public ProductDTO findById(Integer id) {
		return productRepository.findById(id).get().createDTO();
	}

	public Product order(RequestProduct requestProduct) {
		//Product originProduct = productRepository.findById(requestProduct.getId()).get();
		//Product updateProduct = Product.updateQuantity(originProduct, requestProduct.getQuantity());
		//productRepository.updateQuantity(requestProduct.getId(), updateProduct);

		return productRepository.updateQuantity(requestProduct.getId(),
			requestProduct.getQuantity());
	}
}
