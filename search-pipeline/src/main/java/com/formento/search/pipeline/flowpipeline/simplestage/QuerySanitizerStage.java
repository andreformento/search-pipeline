package com.formento.search.pipeline.flowpipeline.simplestage;

import com.formento.search.pipeline.flowpipeline.ProductRequest;
import org.apache.solr.client.solrj.util.ClientUtils;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Component
class QuerySanitizerStage {

    private static class SanitizedProductRequest implements ProductRequest {

        private final ProductRequest origin;

        private SanitizedProductRequest(ProductRequest origin) {
            this.origin = origin;
        }

        public String getQuery() {
            return ClientUtils.escapeQueryChars(origin.getQuery());
        }

        public Integer getPageNumber() {
            return Optional.
                    ofNullable(origin.getPageNumber()).
                    filter(pageNumber -> pageNumber > 0).
                    orElse(1);
        }
    }

    Mono<? extends ProductRequest> sanitize(final Mono<? extends ProductRequest> request) {
        return request.map(SanitizedProductRequest::new);
    }
}
