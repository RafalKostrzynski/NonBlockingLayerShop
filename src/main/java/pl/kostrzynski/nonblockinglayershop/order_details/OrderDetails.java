package pl.kostrzynski.nonblockinglayershop.order_details;

import lombok.Builder;
import lombok.Getter;
import pl.kostrzynski.nonblockinglayershop.shipment.courier.ShipmentCourier;
import pl.kostrzynski.nonblockinglayershop.shipment.shipment_region.ShipmentRegion;

import java.math.BigDecimal;

@Builder
@Getter
class OrderDetails {

    private ShipmentCourier shipmentCourier;

    private ShipmentRegion shipmentRegion;

    private BigDecimal totalPrice;

}
