package com.formento.search.pipeline.managedproductpipeline.product;

import com.formento.search.pipeline.managedproductpipeline.ProductRequest;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
class ProductQueryFactory {
    
    Mono<ProductQuery> create(Mono<ProductRequest> productRequest) {
        return productRequest.map(request -> new ProductQuery(request.getTerm()));
    }

}
