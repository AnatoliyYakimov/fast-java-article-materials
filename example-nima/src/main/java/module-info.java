module ru.yakimov.example.nima {
    requires io.helidon.webserver;
    requires io.helidon.http;
    requires io.helidon.config;
    requires com.fasterxml.jackson.annotation;
    requires jakarta.json;
    requires io.helidon.webclient;
    requires io.helidon.integrations.micrometer;
    requires micrometer.core;
    requires io.helidon.webserver.observe.health;
    requires io.helidon.health.checks;
    requires io.helidon.webserver.observe;
    requires io.helidon.metrics.api;
    requires io.helidon.logging.common;
    requires org.jdbi.v3.core;
    requires com.zaxxer.hikari;
    requires java.sql;
    requires org.postgresql.jdbc;
    requires org.slf4j;
    exports ru.yakimov.example.nima;
}