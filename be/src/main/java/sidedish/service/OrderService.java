package sidedish.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import sidedish.domain.item.Item;
import sidedish.domain.item.ItemRepository;
import sidedish.domain.order.Order;
import sidedish.domain.order.OrderRepository;
import sidedish.web.dto.ResponseDto;
import sidedish.web.dto.order.RequestOrderDto;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ItemRepository itemRepository;


    public ResponseDto addOrder(RequestOrderDto requestOrderDto) {
        Item item = itemRepository.findById(requestOrderDto.getId()).orElseThrow();

        if (item.hasNotEnoughQuantity(requestOrderDto.getQuantity())) {
            return new ResponseDto(HttpStatus.BAD_REQUEST, null);
        }

        orderRepository.save(new Order(item, requestOrderDto.getQuantity()));
        item.reduceQuantity(requestOrderDto.getQuantity());
        itemRepository.save(item);

        return new ResponseDto(HttpStatus.OK, null);
    }
}
