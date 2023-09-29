package ru.yakimov.example.nima;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import io.helidon.config.Config;
import io.helidon.health.HealthCheckResponse;
import io.helidon.health.HealthCheckType;
import io.helidon.logging.common.LogConfig;
import io.helidon.webserver.WebServer;
import io.helidon.webserver.http.HttpRouting;
import io.helidon.webserver.observe.ObserveFeature;
import io.helidon.webserver.observe.health.HealthFeature;
import io.helidon.webserver.observe.health.HealthObserveProvider;
import org.jdbi.v3.core.Jdbi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(final String[] args) {
        LogConfig.configureRuntime();

        /*
         * Конфигурация автоматически подтягивается из ENV и папки resources.
         * Поддерживаются YML, properties, json и других форматы.
         */
        Config config = Config.create();

        HikariConfig hikariConfig = new HikariConfig();
        HikariConfigProperties properties = HikariConfigProperties.create(config.get("db"));

        hikariConfig.setJdbcUrl(properties.jdbcUrl());
        hikariConfig.setUsername(properties.username());
        hikariConfig.setMaximumPoolSize(properties.maximumPoolSize());
        hikariConfig.setMinimumIdle(properties.minimumIdle());

        HikariDataSource dataSource = new HikariDataSource(hikariConfig);

        Jdbi jdbi = Jdbi.create(dataSource);

        OrdersService ordersService = new OrdersService(jdbi);

        WebServer server = WebServer.builder()
                .config(config.get("server"))
                .routing(routing -> {
                    routing.get("/greeting", (req, res) -> res.send("Hello World!"));
                    routing.post("/greeting/{name}", (req, res) -> {
                        String name = req.path().pathParameters().get("name");
                        res.send("Hello %s!".formatted(name));
                    });
                })
                .routing(r -> routing(r, config))
                .routing(r -> r.register("orders", ordersService))
                .build()
                .start();

        log.info("Webserver started");
    }

    /**
     * Updates HTTP Routing.
     */
    static void routing(HttpRouting.Builder routing, Config config) {

        ObserveFeature observeFeature = ObserveFeature.builder()
                .useSystemServices(false)
                .addProvider(HealthObserveProvider.create(HealthFeature.builder()
                        .details(true)
                        .useSystemServices(false)
                        .addCheck(() -> HealthCheckResponse.builder()
                                .status(HealthCheckResponse.Status.UP)
                                .detail("time", System.currentTimeMillis())
                                .build(), HealthCheckType.READINESS)
                        .addCheck(() -> HealthCheckResponse.builder()
                                .status(HealthCheckResponse.Status.UP)
                                .detail("time", System.currentTimeMillis())
                                .build(), HealthCheckType.STARTUP)
                        .build()))
                .build();

        routing.addFeature(observeFeature);
    }


}
