package pl.kostrzynski.nonblockinglayershop.order_details;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
interface OrderDetailsRequestMapper {

    OrderDetailsRequest toDomain(OrderDetailsRequestViewModel viewModel);

}
