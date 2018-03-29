package com.formento.search.pipeline.simplepipeline;

import reactor.core.publisher.Flux;

public interface SimpleProducts {
    Flux<SimpleProduct> getBy(final SimpleQuery simpleQuery);
}
