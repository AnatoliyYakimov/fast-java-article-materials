package ru.yakimov.example.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("orders")
public class OrdersController {

    @Autowired
    private OrdersRepository ordersRepository;

    @GetMapping
    public Flux<Order> getOrders() {
        return ordersRepository.findAllBy(Pageable.ofSize(100));
    }
}
