package com.formento.search.pipeline.managedproductpipeline.product;

import com.formento.search.pipeline.managedproductpipeline.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface Products {

    Flux<Product> getBy(final Mono<ProductQuery> query);

}
