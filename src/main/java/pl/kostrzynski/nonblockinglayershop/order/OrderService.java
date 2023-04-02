package pl.kostrzynski.nonblockinglayershop.order;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
class OrderService {

    private final OrderRepository repository;

    private final OrderMapper mapper;

    Mono<Long> addOrder(final Order order) {

        order.setUsername(SecurityContextHolder.getContext().getAuthentication().getName());

        final var orderJpaEntity = this.mapper.toEntity(order);

        return this.repository.save(orderJpaEntity)
                .map(OrderJpaEntity::getId);
    }

}
