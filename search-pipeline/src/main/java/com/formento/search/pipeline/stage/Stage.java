package com.formento.search.pipeline.stage;

import reactor.core.publisher.Mono;

public interface Stage<T> {

    Either<Mono<T>, Mono<Stage<T>>> transform(final Mono<T> value);

}
