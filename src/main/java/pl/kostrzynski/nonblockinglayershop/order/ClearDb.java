package pl.kostrzynski.nonblockinglayershop.order;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Log4j2
class ClearDb {

    private final OrderRepository repository;

    @EventListener(ApplicationReadyEvent.class)
    public void execute() {

        this.repository.deleteAll()
                .then(Mono.just("The database has been cleared of all Orders."))
                .subscribe(log::info);
    }

}
