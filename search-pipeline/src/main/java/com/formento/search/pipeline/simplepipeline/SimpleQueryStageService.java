package com.formento.search.pipeline.simplepipeline;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class SimpleQueryStageService {

    private final SimpleQueryStageFactory simpleQueryStageFactory;
    private final SimpleProducts simpleProducts;

    public SimpleQueryStageService(SimpleQueryStageFactory simpleQueryStageFactory, SimpleProducts simpleProducts) {
        this.simpleQueryStageFactory = simpleQueryStageFactory;
        this.simpleProducts = simpleProducts;
    }

    public Flux<SimpleProduct> byQuery(final Mono<SimpleQuery> simpleQuery) {
        final Mono<SimpleQuery> transformedSimpleQuery = simpleQueryStageFactory.create().consume(simpleQuery);

        return simpleProducts.getBy(transformedSimpleQuery);
    }
}
