package pl.kostrzynski.nonblockinglayershop.order;

import jakarta.validation.constraints.NotBlank;

record OrderViewModel(
        @NotBlank String shipmentCourierName,
        @NotBlank String shipmentRegion,
        @NotBlank String totalPrice) {
}
