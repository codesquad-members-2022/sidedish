package sidedish.com.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sidedish.com.controller.DomainDtoMapper;
import sidedish.com.controller.model.OrderSaveResponse;
import sidedish.com.domain.Order;
import sidedish.com.domain.Product;
import sidedish.com.exception.NoSuchProductsException;
import sidedish.com.repository.DeliveryPolicyRepository;
import sidedish.com.repository.DiscountPolicyRepository;
import sidedish.com.repository.DomainEntityMapper;
import sidedish.com.repository.OrderRepository;
import sidedish.com.repository.ProductsRepository;
import sidedish.com.repository.entity.OrderEntity;
import sidedish.com.repository.entity.ProductEntity;

@RequiredArgsConstructor
@Service
public class OrderService {

	private final OrderRepository orderRepository;
	private final ProductsRepository productsRepository;
	private final DiscountPolicyRepository discountPolicyRepository;
	private final DeliveryPolicyRepository deliveryPolicyRepository;
	private final DomainEntityMapper domainEntityMapper;
	private final DomainDtoMapper domainDtoMapper;

	@Transactional
	public OrderSaveResponse save(Long productId, long count) {
		ProductEntity productEntity = productsRepository.findById(productId)
			.orElseThrow(NoSuchProductsException::new);
		Product product = domainEntityMapper.toDomainFromProductEntity(productEntity,
			discountPolicyRepository.findAll(), deliveryPolicyRepository.findAll());

		product.minusStockQuantity(count);
		Order order = new Order(product, count);
		OrderEntity orderEntity = domainEntityMapper.toOrderEntityFromDomain(order);

		productsRepository.save(domainEntityMapper.toProductEntityFromDomain(product));
		return domainDtoMapper.toOrderSaveResponseFromOrder(orderRepository.save(orderEntity));
	}
}
