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
@Generated(value = "io.helidon.builder.processor.BlueprintProcessor", trigger = "me.anatoliy.example.nima.MyConfigBlueprint")
public interface MyConfig extends HikariConfigPropertiesBlueprint, Prototype.Api {

    /**
     * Create a new fluent API builder to customize configuration.
     *
     * @return a new builder
     */
    static MyConfig.Builder builder() {
        return new MyConfig.Builder();
    }

    /**
     * Create a new fluent API builder from an existing instance.
     *
     * @param instance an existing instance used as a base for the builder
     * @return a builder based on an instance
     */
    static MyConfig.Builder builder(MyConfig instance) {
        return MyConfig.builder().from(instance);
    }

    /**
     * Create a new instance from configuration.
     *
     * @param config used to configure the new instance
     * @return a new instance configured from configuration
     */
    static MyConfig create(Config config) {
        return MyConfig.builder().config(config).buildPrototype();
    }

    /**
     * Create a new instance with default values.
     *
     * @return a new instance
     */
    static MyConfig create() {
        return MyConfig.builder().buildPrototype();
    }

    /**
     * Fluent API builder base for {@link MyConfig}.
     *
     * @param <BUILDER> type of the builder extending this abstract builder
     * @param <PROTOTYPE> type of the prototype interface that would be built by {@link #buildPrototype()}
     */
    abstract class BuilderBase<BUILDER extends MyConfig.BuilderBase<BUILDER, PROTOTYPE>, PROTOTYPE extends MyConfig> implements Prototype.ConfiguredBuilder<BUILDER, PROTOTYPE> {

        private boolean isEnabled;
        private Config config;
        private int getPort;
        private String getName;

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
        public BUILDER from(MyConfig prototype) {
            getName(prototype.getName());
            isEnabled(prototype.isEnabled());
            getPort(prototype.getPort());
            return self();
        }

        /**
         * Update this builder from an existing prototype builder instance.
         *
         * @param builder existing builder prototype to update this builder from
         * @return updated builder instance
         */
        public BUILDER from(MyConfig.BuilderBase<?, ?> builder) {
            builder.getName().ifPresent(this::getName);
            isEnabled(builder.isEnabled());
            getPort(builder.getPort());
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
            return self();
        }

        /**
         *
         *
         * @param getName
         * @return updated builder instance
         * @see #getName()
         */
        public BUILDER getName(String getName) {
            Objects.requireNonNull(getName);
            this.getName = getName;
            return self();
        }

        /**
         *
         *
         * @param isEnabled
         * @return updated builder instance
         * @see #isEnabled()
         */
        public BUILDER isEnabled(boolean isEnabled) {
            this.isEnabled = isEnabled;
            return self();
        }

        /**
         *
         *
         * @param getPort
         * @return updated builder instance
         * @see #getPort()
         */
        public BUILDER getPort(int getPort) {
            this.getPort = getPort;
            return self();
        }

        /**
         *
         *
         * @return the get name
         */
        public Optional<String> getName() {
            return Optional.ofNullable(getName);
        }

        /**
         *
         *
         * @return the is enabled
         */
        public boolean isEnabled() {
            return isEnabled;
        }

        /**
         *
         *
         * @return the get port
         */
        public int getPort() {
            return getPort;
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
            return "MyConfigBuilder{"
                    + "getName=" + getName + ","
                    + "isEnabled=" + isEnabled + ","
                    + "getPort=" + getPort
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
            if (getName == null) {
                collector.fatal(getClass(), "Property \"getName\" must not be null, but not set");
            }
            collector.collect().checkValid();
        }

        /**
         * Generated implementation of the prototype, can be extended by descendant prototype implementations.
         */
        protected static class MyConfigImpl implements MyConfig {

            private final boolean isEnabled;
            private final int getPort;
            private final String getName;

            /**
             * Create an instance providing a builder.
             *
             * @param builder extending builder base of this prototype
             */
            protected MyConfigImpl(MyConfig.BuilderBase<?, ?> builder) {
                this.getName = builder.getName().get();
                this.isEnabled = builder.isEnabled();
                this.getPort = builder.getPort();
            }

            @Override
            public String getName() {
                return getName;
            }

            @Override
            public boolean isEnabled() {
                return isEnabled;
            }

            @Override
            public int getPort() {
                return getPort;
            }

            @Override
            public String toString() {
                return "MyConfig{"
                        + "getName=" + getName + ","
                        + "isEnabled=" + isEnabled + ","
                        + "getPort=" + getPort
                        + "}";
            }

            @Override
            public boolean equals(Object o) {
                if (o == this) {
                    return true;
                }
                if (!(o instanceof MyConfig other)) {
                    return false;
                }
                return Objects.equals(getName, other.getName())
                        && isEnabled == other.isEnabled()
                        && getPort == other.getPort();
            }

            @Override
            public int hashCode() {
                return Objects.hash(getName, isEnabled, getPort);
            }

        }

    }

    /**
     * Fluent API builder for {@link MyConfig}.
     */
    class Builder extends MyConfig.BuilderBase<MyConfig.Builder, MyConfig> implements io.helidon.common.Builder<MyConfig.Builder, MyConfig> {

        private Builder() {
        }

        @Override
        public MyConfig buildPrototype() {
            preBuildPrototype();
            validatePrototype();
            return new MyConfigImpl(this);
        }

        @Override
        public MyConfig build() {
            return buildPrototype();
        }

    }

}
