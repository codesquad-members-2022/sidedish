package com.team25.sidedish.service.aggregate;

import com.team25.sidedish.domain.Delivery;
import com.team25.sidedish.domain.Event;
import com.team25.sidedish.domain.Image;
import com.team25.sidedish.domain.Product;
import com.team25.sidedish.dto.request.ProductStockChangeRequest;
import com.team25.sidedish.dto.response.ProductDetailResponse;
import com.team25.sidedish.dto.response.ProductResponse;
import com.team25.sidedish.dto.response.ProductStockChangeResponse;
import com.team25.sidedish.service.ImageService;
import com.team25.sidedish.service.ProductDeliveryService;
import com.team25.sidedish.service.ProductEventService;
import com.team25.sidedish.service.ProductService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AggregateProductService {

    private final ProductService productService;
    private final ProductEventService productEventService;
    private final ProductDeliveryService productDeliveryService;
    private final ImageService imageService;

    @Transactional
    public List<ProductResponse> getProductList(Long categoryId) {
        return productService.getProductsByCategoryId(categoryId)
            .stream()
            .map(product -> {
                Long id = product.getId();

                List<Event> eventList = productEventService.getEventsByProductId(id);
                List<String> eventNameList = getEventNameList(eventList);
                double discountRate = getEventDiscountRate(eventList);

                return ProductResponse.from(product, eventNameList, discountRate);
            })
            .collect(Collectors.toUnmodifiableList());
    }

    @Transactional
    public ProductDetailResponse getProductDetailList(Long productId) {
        Product product = productService.getProductByProductId(productId);

        List<Event> eventList = productEventService.getEventsByProductId(productId);
        List<String> eventNameList = getEventNameList(eventList);
        double discountRate = getEventDiscountRate(eventList);

        List<Delivery> deliveryList = productDeliveryService.getDeliveriesByProductId(
            productId);
        List<String> deliveryInfoList = getDeliveryInfoList(deliveryList);

        List<Image> imageList = imageService.getImagesByProductId(productId);
        List<String> imageUrlList = getImageUrlList(imageList);

        return ProductDetailResponse.from(product, eventNameList, discountRate, deliveryInfoList,
            imageUrlList);
    }

    @Transactional
    public ProductStockChangeResponse updateProductStock(ProductStockChangeRequest request) {
        Product product = productService.getProductByProductId(request.getId());
        product.updateStock(request.getAmount());
        productService.updateProduct(product);
        return ProductStockChangeResponse.from(product);
    }


    private List<String> getEventNameList(List<Event> eventList) {
        return eventList
            .stream()
            .map(Event::getName)
            .collect(Collectors.toUnmodifiableList());
    }

    private double getEventDiscountRate(List<Event> eventList) {
        return eventList
            .stream()
            .map(Event::getDiscountRate)
            .reduce(0D, Double::sum);
    }

    private static List<String> getDeliveryInfoList(List<Delivery> deliveryList) {
        return deliveryList
            .stream()
            .map(delivery -> {
                return delivery.getRegion() + " " + delivery.getType().getName();
            })
            .collect(Collectors.toUnmodifiableList());
    }

    private List<String> getImageUrlList(List<Image> imageList) {
        return imageList
            .stream()
            .map(Image::getUrl)
            .collect(Collectors.toUnmodifiableList());
    }
}
