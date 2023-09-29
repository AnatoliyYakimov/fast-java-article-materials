package ru.yakimov.example.nima;

import io.helidon.webserver.http.*;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.mapper.reflect.ConstructorMapper;

import java.util.List;

public class OrdersService implements HttpService {

    public OrdersService(Jdbi jdbi) {
        this.jdbi = jdbi;
    }
    private final Jdbi jdbi;

    @Override
    public void routing(HttpRules httpRules) {
        httpRules.get(this::getOrders);
    }

    private void getOrders(ServerRequest serverRequest, ServerResponse serverResponse) {
        try (Handle handle = jdbi.open()) {
            List<Order> orders = handle.createQuery(
                    "SELECT * FROM orders LIMIT 100")
                    .map(ConstructorMapper.of(Order.class))
                    .list();
            serverResponse.send(orders);
        }
    }


}
