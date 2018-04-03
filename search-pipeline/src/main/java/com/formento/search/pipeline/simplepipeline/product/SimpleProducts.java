package com.formento.search.pipeline.simplepipeline.product;

import com.formento.search.pipeline.simplepipeline.SimpleQuery;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SimpleProducts {
    Flux<SimpleProduct> getBy(final Mono<SimpleQuery> simpleQuery);
}
