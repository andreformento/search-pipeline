package com.formento.search.pipeline.simplepipeline.api.v1;

import com.formento.search.pipeline.simplepipeline.SimpleProduct;
import com.formento.search.pipeline.simplepipeline.SimpleQueryStageService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

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
        return simpleQueryStageService.byQuery(query,pageNumber);
    }

}
