package pl.kostrzynski.nonblockinglayershop.order_details;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kostrzynski.nonblockinglayershop.product.ProductService;
import pl.kostrzynski.nonblockinglayershop.shipment.courier.ShipmentCourierService;
import pl.kostrzynski.nonblockinglayershop.shipment.shipment_region.ShipmentRegionService;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
class OrderDetailsService {

    private final ShipmentCourierService shipmentCourierService;

    private final ShipmentRegionService shipmentRegionService;

    private final ProductService productService;

    Mono<OrderDetails> createOrderDetails(final OrderDetailsRequest orderDetailsRequest) {

        return Mono.zip(
                this.shipmentCourierService.getShipmentCourierByCourier(orderDetailsRequest.courier()),
                this.shipmentRegionService.getShipmentRegionByRegion(orderDetailsRequest.region()),
                this.productService.getPurchasePriceByNames(orderDetailsRequest.products())
        ).map(e -> OrderDetails.builder()
                .shipmentCourier(e.getT1())
                .shipmentRegion(e.getT2())
                .totalPrice(
                        e.getT3()
                                .add(e.getT1().getCourierMargin())
                                .add(e.getT2().getShipmentMargin())
                ).build()
        );
    }
}
