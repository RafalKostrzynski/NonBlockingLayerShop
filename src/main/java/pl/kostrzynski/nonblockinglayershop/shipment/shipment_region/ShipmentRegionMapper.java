package pl.kostrzynski.nonblockinglayershop.shipment.shipment_region;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
interface ShipmentRegionMapper {

    ShipmentRegion toDomain(ShipmentRegionJpaEntity entity);

}
