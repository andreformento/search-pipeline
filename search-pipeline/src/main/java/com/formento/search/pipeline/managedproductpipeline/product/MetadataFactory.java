package com.formento.search.pipeline.managedproductpipeline.product;

import com.google.common.collect.ImmutableMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

import static java.lang.Boolean.TRUE;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

@Component
public class MetadataFactory {

    private final MetadataBuilder metadataBuilder;

    MetadataFactory(MetadataBuilder metadataBuilder) {
        this.metadataBuilder = metadataBuilder;
    }

    Optional<Map<String, String>> create() {
        return metadataBuilder.metadatas();
    }

    @Configuration
    public class MetadataConfiguration {
        @Bean
        @Scope(scopeName = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
        MetadataBuilder metadataBuilder(final ServerHttpRequest request) {
            if (request.getQueryParams().containsKey("debug")) {
                final String value = request.getQueryParams().getFirst("debug");
                if (isNotBlank(value) && TRUE.toString().equalsIgnoreCase(value)) {
                    return new MetadataBuilder(Optional.of(ImmutableMap.<String, String>builder().put("debug", TRUE.toString())));
                }
            }
            return new MetadataBuilder(Optional.empty());
        }
    }

    public class MetadataBuilder {

        private final Optional<ImmutableMap.Builder<String, String>> metadatas;

        private MetadataBuilder(Optional<ImmutableMap.Builder<String, String>> metadatas) {
            this.metadatas = metadatas;
        }

        public MetadataBuilder put(String key, String value) {
            metadatas.ifPresent(m -> m.put(key, value));
            return this;
        }

        private Optional<Map<String, String>> metadatas() {
            return metadatas.map(ImmutableMap.Builder::build);
        }
    }

}
