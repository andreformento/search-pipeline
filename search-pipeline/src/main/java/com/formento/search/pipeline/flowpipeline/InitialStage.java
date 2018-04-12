package com.formento.search.pipeline.flowpipeline;

import reactor.core.publisher.Mono;

public interface InitialStage {

    Mono<ProductResponse> transform(final Mono<? extends ProductRequest> request);

}
