package pl.kostrzynski.nonblockinglayershop.monitoring;

import org.springframework.boot.actuate.web.exchanges.HttpExchangeRepository;
import org.springframework.boot.actuate.web.exchanges.InMemoryHttpExchangeRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class HttpExchangeConfig {

    @Bean
    HttpExchangeRepository httpTraceRepository() {
        final var inMemoryHttpExchangeRepository = new InMemoryHttpExchangeRepository();
        inMemoryHttpExchangeRepository.setCapacity(9999);

        return inMemoryHttpExchangeRepository;
    }

}
