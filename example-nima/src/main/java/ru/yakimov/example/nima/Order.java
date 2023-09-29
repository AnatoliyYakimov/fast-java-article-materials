package ru.yakimov.example.nima;

import java.math.BigDecimal;
import java.time.LocalDate;

public record Order(
    Long userId,
    LocalDate orderDate,
    BigDecimal price,
    Long qty,
    String deliveryAddress,
    String clientFullName
) {
}
