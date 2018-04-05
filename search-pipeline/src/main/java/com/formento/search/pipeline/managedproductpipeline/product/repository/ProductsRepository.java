package com.formento.search.pipeline.managedproductpipeline.product.repository;

import com.formento.search.pipeline.managedproductpipeline.Product;
import com.formento.search.pipeline.managedproductpipeline.product.MetadataFactory;
import com.formento.search.pipeline.managedproductpipeline.product.ProductQuery;
import com.formento.search.pipeline.managedproductpipeline.product.Products;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static java.util.UUID.randomUUID;

@Repository
public class ProductsRepository implements Products {

    private final MetadataFactory.MetadataBuilder metadataBuilder;

    public ProductsRepository(MetadataFactory.MetadataBuilder metadataBuilder) {
        this.metadataBuilder = metadataBuilder;
    }

    @Override
    public Flux<Product> getBy(Mono<ProductQuery> query) {
        // execute query in database (solr/non blocking)
        query.subscribe(q -> metadataBuilder.put("query", q.buildQuery()));

        // use term in title
        query.map(q -> );

        return Flux.just(new Product(randomUUID().toString(), "Product 1"));
    }

}
