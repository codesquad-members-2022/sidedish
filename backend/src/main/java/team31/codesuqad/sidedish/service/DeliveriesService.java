package team31.codesuqad.sidedish.service;

import org.springframework.stereotype.Service;
import team31.codesuqad.sidedish.domain.Deliveries;
import team31.codesuqad.sidedish.repository.DeliveriesRepository;

import java.util.Optional;

@Service
public class DeliveriesService {

    private final DeliveriesRepository deliveriesRepository;

    public DeliveriesService(DeliveriesRepository deliveriesRepository) {
        this.deliveriesRepository = deliveriesRepository;
    }

    public Optional<Deliveries> findById(Integer deliveryId) {
        return deliveriesRepository.findById(deliveryId);
    }

}
