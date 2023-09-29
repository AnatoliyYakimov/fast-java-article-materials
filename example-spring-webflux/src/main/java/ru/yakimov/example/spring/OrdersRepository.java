package ru.yakimov.example.spring;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface OrdersRepository extends ReactiveCrudRepository<Order, Long> {

    Flux<Order> findAllBy(Pageable pageable);
}
