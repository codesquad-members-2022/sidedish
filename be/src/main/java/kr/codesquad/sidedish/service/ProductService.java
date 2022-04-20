package kr.codesquad.sidedish.service;

import java.util.List;
import java.util.stream.Collectors;
import kr.codesquad.sidedish.domain.Product;
import kr.codesquad.sidedish.dto.RequestProduct;
import kr.codesquad.sidedish.dto.ResponseProduct;
import kr.codesquad.sidedish.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	private final ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public List<ResponseProduct> findAll() {
		return productRepository.findAll()
			.stream()
			.map(Product::createResponseProduct)
			.collect(Collectors.toList());
	}

	public List<ResponseProduct> loadListByType(String dishType, String sideDishType) {
		return productRepository.loadListByType(dishType, sideDishType).stream()
			.map(Product::createResponseProduct)
			.collect(Collectors.toList());
	}

	public ResponseProduct findById(int id) {
		return productRepository.findById(id).createResponseProduct();
	}

	public void ordered(int id, RequestProduct requestProduct) {
		Product originProduct = productRepository.findById(id);
		Product updateProduct = Product.updateQuantity(originProduct, requestProduct.getQuantity());
		productRepository.updateQuantity(id, updateProduct);
	}
}
