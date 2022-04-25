package kr.codesquad.sidedish.service;

import java.util.List;
import java.util.stream.Collectors;
import kr.codesquad.sidedish.domain.Product;
import kr.codesquad.sidedish.controller.RequestProduct;
import kr.codesquad.sidedish.repository.ProductRepository;
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

	public List<ProductDTO> loadListByType(String dishType, String sideDishType) {
		return productRepository.loadListByType(dishType, sideDishType).stream()
			.map(Product::createDTO)
			.collect(Collectors.toList());
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
