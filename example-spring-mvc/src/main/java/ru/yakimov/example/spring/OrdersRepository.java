package ru.yakimov.example.spring;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrdersRepository extends CrudRepository<Order, Long> {

    List<Order> findAllBy(Pageable pageable);
}
