package com.formento.search.pipeline.simplepipeline.product;

import com.formento.search.pipeline.simplepipeline.SimpleQuery;
import com.formento.search.pipeline.simplepipeline.SimpleStageService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class SimpleQueryStageService {

    private final SimpleStageService simpleStageService;
    private final SimpleProducts simpleProducts;

    public SimpleQueryStageService(SimpleStageService simpleStageService, SimpleProducts simpleProducts) {
        this.simpleStageService = simpleStageService;
        this.simpleProducts = simpleProducts;
    }

    public Flux<SimpleProduct> byQuery(final Mono<SimpleQuery> simpleQuery) {
        final Mono<SimpleQuery> transformedSimpleQuery = simpleStageService.
                getStageList().
                flatMap(sl -> sl.consume(simpleQuery));

        return simpleProducts.getBy(transformedSimpleQuery);
    }
}
