package com.formento.search.pipeline.managedproductpipeline.product;

import com.formento.search.pipeline.managedproductpipeline.Product;
import com.formento.search.pipeline.managedproductpipeline.ProductRequest;
import com.formento.search.pipeline.managedproductpipeline.ProductResponse;
import com.google.common.collect.ImmutableList;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
class ProductResponseFactory {
    private final ProductQueryFactory productQueryFactory;
    private final Products products;
    private final MetadataFactory metadataFactory;

    ProductResponseFactory(ProductQueryFactory productQueryFactory, Products products, MetadataFactory metadataFactory) {
        this.productQueryFactory = productQueryFactory;
        this.products = products;
        this.metadataFactory = metadataFactory;
    }

    Mono<ProductResponse> fromRepository(Mono<ProductRequest> productRequest) {
        return productQueryFactory.
                create(productRequest).
                transform(products::getBy).
                flux().reduce(ImmutableList.<Product>builder(), ImmutableList.Builder::add).
                map(list -> new ProductResponse(list.build(), metadataFactory.create()));
    }

}
