package ru.yakimov.example.nima;

import io.helidon.builder.api.Option;
import io.helidon.builder.api.Prototype;

@Prototype.BuilderMethod
@Prototype.Blueprint
@Prototype.Configured
interface HikariConfigPropertiesBlueprint {

    @Option.Configured
    String jdbcUrl();
    @Option.Configured
    String username();
    @Option.Configured
    String password();
    @Option.Configured
    int maximumPoolSize();
    @Option.Configured
    int minimumIdle();
}