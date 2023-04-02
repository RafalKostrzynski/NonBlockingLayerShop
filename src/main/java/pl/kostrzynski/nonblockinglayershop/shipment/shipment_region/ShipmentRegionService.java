package pl.kostrzynski.nonblockinglayershop.shipment.shipment_region;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ShipmentRegionService {

    private final ShipmentRegionRepository repository;

    private final ShipmentRegionMapper mapper;

    public Mono<ShipmentRegion> getShipmentRegionByRegion(final Region region) {

        return this.repository.findShipmentRegionJpaEntitiesByRegion(region)
                .map(this.mapper::toDomain)
                .switchIfEmpty(Mono.error(new RuntimeException()));
    }

}
