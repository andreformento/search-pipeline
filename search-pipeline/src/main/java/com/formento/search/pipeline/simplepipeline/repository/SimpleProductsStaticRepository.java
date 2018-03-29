package com.formento.search.pipeline.simplepipeline.repository;

import com.formento.search.pipeline.simplepipeline.SimpleProduct;
import com.formento.search.pipeline.simplepipeline.SimpleProducts;
import com.formento.search.pipeline.simplepipeline.SimpleQuery;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static java.util.UUID.randomUUID;

@Repository
public class SimpleProductsStaticRepository implements SimpleProducts {

    @Override
    public Flux<SimpleProduct> getBy(final Mono<SimpleQuery> simpleQuery) {
        return simpleQuery.flux().flatMap(this::fromQuery);
    }

    private Flux<SimpleProduct> fromQuery(final SimpleQuery simpleQuery) {
        // execute query in database (solr/non blocking)
        return Flux.just(new SimpleProduct(randomUUID().toString(), "Product 1"));
    }

}
