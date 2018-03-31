package com.formento.search.pipeline.simplepipeline.product;

import com.formento.search.pipeline.simplepipeline.SimpleQueryStageRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class SimpleQueryStageService {

    private final SimpleQueryStageRepository simpleQueryStageRepository;
    private final SimpleProducts simpleProducts;

    public SimpleQueryStageService(SimpleQueryStageRepository simpleQueryStageRepository, SimpleProducts simpleProducts) {
        this.simpleQueryStageRepository = simpleQueryStageRepository;
        this.simpleProducts = simpleProducts;
    }

    public Flux<SimpleProduct> byQuery(final Mono<SimpleQuery> simpleQuery) {
        final Mono<SimpleQuery> transformedSimpleQuery = simpleQueryStageRepository.
                getStageList().
                flatMap(sl -> sl.consume(simpleQuery));

        return simpleProducts.getBy(transformedSimpleQuery);
    }
}
