package com.formento.search.pipeline.simplepipeline;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SimpleProducts {
    Flux<SimpleProduct> getBy(final Mono<SimpleQuery> simpleQuery);
}
