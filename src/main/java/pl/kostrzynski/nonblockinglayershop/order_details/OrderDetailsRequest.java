package pl.kostrzynski.nonblockinglayershop.order_details;

import pl.kostrzynski.nonblockinglayershop.shipment.courier.Courier;
import pl.kostrzynski.nonblockinglayershop.shipment.shipment_region.Region;

import java.util.List;

record OrderDetailsRequest(
        Courier courier,
        Region region,
        List<String> products
) {
}
