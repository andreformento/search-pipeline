package com.formento.search.pipeline.simplepipeline.repository;

import com.formento.search.pipeline.simplepipeline.SimpleProduct;
import com.formento.search.pipeline.simplepipeline.SimpleProducts;
import com.formento.search.pipeline.simplepipeline.SimpleQuery;
import reactor.core.publisher.Flux;

import static java.util.UUID.randomUUID;

public class SimpleProductsRepository implements SimpleProducts {

    @Override
    public Flux<SimpleProduct> getBy(final SimpleQuery simpleQuery) {
        // execute query in database (solr)
        return Flux.just(
                new SimpleProduct(randomUUID().toString(), "Product 1"),
                new SimpleProduct(randomUUID().toString(), "Product 2")
        );
    }

}
