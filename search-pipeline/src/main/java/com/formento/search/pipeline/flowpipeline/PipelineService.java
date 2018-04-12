package com.formento.search.pipeline.flowpipeline;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class PipelineService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PipelineService.class);

    private final InitialStage initialStage;

    public PipelineService(InitialStage initialStage) {
        this.initialStage = initialStage;
    }

    public Mono<ProductResponse> searchForProduct(Mono<? extends ProductRequest> request) {
        request.subscribe(r -> LOGGER.info("initial request q={}, page={}", r.getQuery(), r.getPageNumber()));

        return request.
                transform(initialStage::transform).
                doOnSuccess(result -> LOGGER.info("result size = ", result.getProducts().size()));
    }

}
