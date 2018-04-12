package com.formento.search.pipeline.flowpipeline.simplestage;

import com.formento.search.pipeline.flowpipeline.Product;
import com.formento.search.pipeline.flowpipeline.ProductRequest;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
class SimpleRepository {
    Flux<Product> getByQuery(Mono<? extends ProductRequest> mono) {
        return Flux.empty();
    }
}
