package com.formento.search.pipeline.simplepipeline;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class SimpleQueryStageService {

    private final SimpleQueryStageFactory simpleQueryStageFactory;
    private final SimpleProducts simpleProducts;

    public SimpleQueryStageService(SimpleQueryStageFactory simpleQueryStageFactory, SimpleProducts simpleProducts) {
        this.simpleQueryStageFactory = simpleQueryStageFactory;
        this.simpleProducts = simpleProducts;
    }

    public Flux<SimpleProduct> byQuery(final String query, Integer pageNumber) {
        final SimpleQuery simpleQuery = simpleQueryStageFactory.
                create().
                consume(new SimpleQuery(query, pageNumber));

        return simpleProducts.getBy(simpleQuery);
    }
}
