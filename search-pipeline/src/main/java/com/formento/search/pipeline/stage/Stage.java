package com.formento.search.pipeline.stage;

import reactor.core.publisher.Mono;

public interface Stage<T> {

    Mono<T> transform(final Mono<T> queryPipeline);

}
