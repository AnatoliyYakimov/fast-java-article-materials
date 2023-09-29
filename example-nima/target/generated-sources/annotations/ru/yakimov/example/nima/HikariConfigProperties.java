// This is a generated file (powered by Helidon). Do not edit or extend from this artifact as it is subject to change at any time!

package ru.yakimov.example.nima;

import java.util.Objects;
import java.util.Optional;

import io.helidon.builder.api.Prototype;
import io.helidon.common.Errors;
import io.helidon.common.Generated;
import io.helidon.common.config.Config;

/**
 * Interface generated from definition. Please add javadoc to the definition interface.
 *
 * @see #builder()
 * @see #create()
 */
@Generated(value = "io.helidon.builder.processor.BlueprintProcessor", trigger = "me.anatoliy.example.nima.HikariConfigPropertiesBlueprint")
public interface HikariConfigProperties extends HikariConfigPropertiesBlueprint, Prototype.Api {

    /**
     * Create a new fluent API builder to customize configuration.
     *
     * @return a new builder
     */
    static HikariConfigProperties.Builder builder() {
        return new HikariConfigProperties.Builder();
    }

    /**
     * Create a new fluent API builder from an existing instance.
     *
     * @param instance an existing instance used as a base for the builder
     * @return a builder based on an instance
     */
    static HikariConfigProperties.Builder builder(HikariConfigProperties instance) {
        return HikariConfigProperties.builder().from(instance);
    }

    /**
     * Create a new instance from configuration.
     *
     * @param config used to configure the new instance
     * @return a new instance configured from configuration
     */
    static HikariConfigProperties create(Config config) {
        return HikariConfigProperties.builder().config(config).buildPrototype();
    }

    /**
     * Create a new instance with default values.
     *
     * @return a new instance
     */
    static HikariConfigProperties create() {
        return HikariConfigProperties.builder().buildPrototype();
    }

    /**
     * Fluent API builder base for {@link HikariConfigProperties}.
     *
     * @param <BUILDER> type of the builder extending this abstract builder
     * @param <PROTOTYPE> type of the prototype interface that would be built by {@link #buildPrototype()}
     */
    abstract class BuilderBase<BUILDER extends HikariConfigProperties.BuilderBase<BUILDER, PROTOTYPE>, PROTOTYPE extends HikariConfigProperties> implements Prototype.ConfiguredBuilder<BUILDER, PROTOTYPE> {

        private Config config;
        private int maximumPoolSize;
        private int minimumIdle;
        private String jdbcUrl;
        private String password;
        private String username;

        /**
         * Protected to support extensibility.
         */
        protected BuilderBase() {
        }

        /**
         * Update this builder from an existing prototype instance.
         *
         * @param prototype existing prototype to update this builder from
         * @return updated builder instance
         */
        public BUILDER from(HikariConfigProperties prototype) {
            jdbcUrl(prototype.jdbcUrl());
            username(prototype.username());
            password(prototype.password());
            maximumPoolSize(prototype.maximumPoolSize());
            minimumIdle(prototype.minimumIdle());
            return self();
        }

        /**
         * Update this builder from an existing prototype builder instance.
         *
         * @param builder existing builder prototype to update this builder from
         * @return updated builder instance
         */
        public BUILDER from(HikariConfigProperties.BuilderBase<?, ?> builder) {
            builder.jdbcUrl().ifPresent(this::jdbcUrl);
            builder.username().ifPresent(this::username);
            builder.password().ifPresent(this::password);
            maximumPoolSize(builder.maximumPoolSize());
            minimumIdle(builder.minimumIdle());
            return self();
        }

        /**
         * Update builder from configuration (node of this type).
         * If a value is present in configuration, it would override currently configured values.
         *
         * @param config configuration instance used to obtain values to update this builder
         * @return updated builder instance
         */
        @Override
        public BUILDER config(Config config) {
            Objects.requireNonNull(config);
            this.config = config;
            config.get("jdbc-url").as(String.class).ifPresent(this::jdbcUrl);
            config.get("username").as(String.class).ifPresent(this::username);
            config.get("password").as(String.class).ifPresent(this::password);
            config.get("maximum-pool-size").as(Integer.class).ifPresent(this::maximumPoolSize);
            config.get("minimum-idle").as(Integer.class).ifPresent(this::minimumIdle);
            return self();
        }

        /**
         *
         *
         * @param jdbcUrl
         * @return updated builder instance
         * @see #jdbcUrl()
         */
        public BUILDER jdbcUrl(String jdbcUrl) {
            Objects.requireNonNull(jdbcUrl);
            this.jdbcUrl = jdbcUrl;
            return self();
        }

        /**
         *
         *
         * @param username
         * @return updated builder instance
         * @see #username()
         */
        public BUILDER username(String username) {
            Objects.requireNonNull(username);
            this.username = username;
            return self();
        }

        /**
         *
         *
         * @param password
         * @return updated builder instance
         * @see #password()
         */
        public BUILDER password(String password) {
            Objects.requireNonNull(password);
            this.password = password;
            return self();
        }

        /**
         *
         *
         * @param maximumPoolSize
         * @return updated builder instance
         * @see #maximumPoolSize()
         */
        public BUILDER maximumPoolSize(int maximumPoolSize) {
            this.maximumPoolSize = maximumPoolSize;
            return self();
        }

        /**
         *
         *
         * @param minimumIdle
         * @return updated builder instance
         * @see #minimumIdle()
         */
        public BUILDER minimumIdle(int minimumIdle) {
            this.minimumIdle = minimumIdle;
            return self();
        }

        /**
         *
         *
         * @return the jdbc url
         */
        public Optional<String> jdbcUrl() {
            return Optional.ofNullable(jdbcUrl);
        }

        /**
         *
         *
         * @return the username
         */
        public Optional<String> username() {
            return Optional.ofNullable(username);
        }

        /**
         *
         *
         * @return the password
         */
        public Optional<String> password() {
            return Optional.ofNullable(password);
        }

        /**
         *
         *
         * @return the maximum pool size
         */
        public int maximumPoolSize() {
            return maximumPoolSize;
        }

        /**
         *
         *
         * @return the minimum idle
         */
        public int minimumIdle() {
            return minimumIdle;
        }

        /**
         * If this instance was configured, this would be the config instance used.
         *
         * @return config node used to configure this builder, or empty if not configured
         */
        public Optional<Config> config() {
            return Optional.ofNullable(config);
        }

        @Override
        public String toString() {
            return "HikariConfigPropertiesBuilder{"
                    + "jdbcUrl=" + jdbcUrl + ","
                    + "username=" + username + ","
                    + "password=" + password + ","
                    + "maximumPoolSize=" + maximumPoolSize + ","
                    + "minimumIdle=" + minimumIdle
                    + "}";
        }

        /**
         * Handles providers and decorators.
         */
        protected void preBuildPrototype() {
        }

        /**
         * Validates required properties.
         */
        protected void validatePrototype() {
            Errors.Collector collector = Errors.collector();
            if (jdbcUrl == null) {
                collector.fatal(getClass(), "Property \"jdbc-url\" must not be null, but not set");
            }
            if (username == null) {
                collector.fatal(getClass(), "Property \"username\" must not be null, but not set");
            }
            if (password == null) {
                collector.fatal(getClass(), "Property \"password\" must not be null, but not set");
            }
            collector.collect().checkValid();
        }

        /**
         * Generated implementation of the prototype, can be extended by descendant prototype implementations.
         */
        protected static class HikariConfigPropertiesImpl implements HikariConfigProperties {

            private final int maximumPoolSize;
            private final int minimumIdle;
            private final String jdbcUrl;
            private final String password;
            private final String username;

            /**
             * Create an instance providing a builder.
             *
             * @param builder extending builder base of this prototype
             */
            protected HikariConfigPropertiesImpl(HikariConfigProperties.BuilderBase<?, ?> builder) {
                this.jdbcUrl = builder.jdbcUrl().get();
                this.username = builder.username().get();
                this.password = builder.password().get();
                this.maximumPoolSize = builder.maximumPoolSize();
                this.minimumIdle = builder.minimumIdle();
            }

            @Override
            public String jdbcUrl() {
                return jdbcUrl;
            }

            @Override
            public String username() {
                return username;
            }

            @Override
            public String password() {
                return password;
            }

            @Override
            public int maximumPoolSize() {
                return maximumPoolSize;
            }

            @Override
            public int minimumIdle() {
                return minimumIdle;
            }

            @Override
            public String toString() {
                return "HikariConfigProperties{"
                        + "jdbcUrl=" + jdbcUrl + ","
                        + "username=" + username + ","
                        + "password=" + password + ","
                        + "maximumPoolSize=" + maximumPoolSize + ","
                        + "minimumIdle=" + minimumIdle
                        + "}";
            }

            @Override
            public boolean equals(Object o) {
                if (o == this) {
                    return true;
                }
                if (!(o instanceof HikariConfigProperties other)) {
                    return false;
                }
                return Objects.equals(jdbcUrl, other.jdbcUrl())
                        && Objects.equals(username, other.username())
                        && Objects.equals(password, other.password())
                        && maximumPoolSize == other.maximumPoolSize()
                        && minimumIdle == other.minimumIdle();
            }

            @Override
            public int hashCode() {
                return Objects.hash(jdbcUrl, username, password, maximumPoolSize, minimumIdle);
            }

        }

    }

    /**
     * Fluent API builder for {@link HikariConfigProperties}.
     */
    class Builder extends HikariConfigProperties.BuilderBase<HikariConfigProperties.Builder, HikariConfigProperties> implements io.helidon.common.Builder<HikariConfigProperties.Builder, HikariConfigProperties> {

        private Builder() {
        }

        @Override
        public HikariConfigProperties buildPrototype() {
            preBuildPrototype();
            validatePrototype();
            return new HikariConfigPropertiesImpl(this);
        }

        @Override
        public HikariConfigProperties build() {
            return buildPrototype();
        }

    }

}
