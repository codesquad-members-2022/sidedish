package team31.codesuqad.sidedish.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team31.codesuqad.sidedish.domain.Delivery;
import team31.codesuqad.sidedish.repository.DeliveryRepository;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class DeliveryService {

    private final DeliveryRepository deliveryRepository;

    public DeliveryService(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    public Optional<Delivery> findById(Integer deliveryId) {
        return deliveryRepository.findById(deliveryId);
    }

}
