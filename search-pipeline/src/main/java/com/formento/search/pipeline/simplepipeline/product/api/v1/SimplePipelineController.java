package com.formento.search.pipeline.simplepipeline.product.api.v1;

import com.formento.search.pipeline.simplepipeline.product.SimpleProduct;
import com.formento.search.pipeline.simplepipeline.product.SimpleQuery;
import com.formento.search.pipeline.simplepipeline.product.SimpleQueryStageService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/search/simple")
class SimplePipelineController {

    private final SimpleQueryStageService simpleQueryStageService;

    SimplePipelineController(final SimpleQueryStageService simpleQueryStageService) {
        this.simpleQueryStageService = simpleQueryStageService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<SimpleProduct> byQuery(
            @RequestParam("query") final String query,
            @RequestParam("pg") final Integer pageNumber
    ) {
        // TODO needs some refactor to use a converter
        final Mono<SimpleQuery> simpleQuery = Mono.just(new SimpleQuery(query, pageNumber));
        return simpleQueryStageService.byQuery(simpleQuery);
    }

}
