package com.formento.search.pipeline.managedproductpipeline.product;

import com.formento.search.pipeline.managedproductpipeline.ProductRequest;
import com.formento.search.pipeline.managedproductpipeline.ProductResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Component
class ResultCache {

    Optional<Mono<ProductResponse>> getResults(Mono<ProductRequest> productRequest) {
        return Optional.empty();
    }

}
