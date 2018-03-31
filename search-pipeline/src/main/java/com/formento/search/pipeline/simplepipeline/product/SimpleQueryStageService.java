package com.formento.search.pipeline.simplepipeline.product;

import com.formento.search.pipeline.simplepipeline.SimpleManagementService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class SimpleQueryStageService {

    private final SimpleManagementService simpleManagementService;
    private final SimpleProducts simpleProducts;

    public SimpleQueryStageService(SimpleManagementService simpleManagementService, SimpleProducts simpleProducts) {
        this.simpleManagementService = simpleManagementService;
        this.simpleProducts = simpleProducts;
    }

    public Flux<SimpleProduct> byQuery(final Mono<SimpleQuery> simpleQuery) {
        final Mono<SimpleQuery> transformedSimpleQuery = simpleManagementService.
                getStageList().
                flatMap(sl -> sl.consume(simpleQuery));

        return simpleProducts.getBy(transformedSimpleQuery);
    }
}
