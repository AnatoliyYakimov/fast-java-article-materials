package ru.yakimov.example.spring;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.mapper.reflect.ConstructorMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("orders")
public class OrdersController {

    private final Jdbi jdbi;
    private final OrdersRepository ordersRepository;

    public OrdersController(Jdbi jdbi, OrdersRepository ordersRepository) {
        this.jdbi = jdbi;
        this.ordersRepository = ordersRepository;
    }

    @GetMapping
    public List<Order> getOrders() {
        return ordersRepository.findAllBy(Pageable.ofSize(100));
    }

    @GetMapping("/jdbi")
    public List<Order> getOrdersJdbi() {
        try (Handle handle = jdbi.open()) {
            return handle.createQuery("SELECT * FROM orders LIMIT 100")
                    .map(ConstructorMapper.of(Order.class))
                    .list();
        }
    }
}
