package ru.yakimov.example.spring;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDate;

@Table("orders")
public record Order(
        @Id
        Long id,
        Long userId,
        LocalDate orderDate,
        BigDecimal price,
        Long qty,
        String deliveryAddress,
        String clientFullName
) {
}
