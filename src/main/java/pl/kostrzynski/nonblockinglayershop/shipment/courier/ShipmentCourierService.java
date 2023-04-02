package pl.kostrzynski.nonblockinglayershop.shipment.courier;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ShipmentCourierService {

    private final ShipmentCourierRepository repository;

    private final ShipmentCourierMapper mapper;

    public Mono<ShipmentCourier> getShipmentCourierByCourier(final Courier courier) {

        return this.repository.findByCourier(courier)
                .map(this.mapper::toDomain)
                .switchIfEmpty(Mono.error(new RuntimeException()));
    }

}
