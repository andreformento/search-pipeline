package com.formento.search.pipeline.simplepipeline.management.api.v1;

import com.formento.search.pipeline.simplepipeline.SimpleQueryStageRepository;
import com.formento.search.pipeline.simplepipeline.product.SimpleQuery;
import com.formento.search.pipeline.stage.StageList;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/simple/management")
public class SimplepipelineManagementController {

    private final SimpleQueryStageRepository simpleQueryStageRepository;

    public SimplepipelineManagementController(final SimpleQueryStageRepository simpleQueryStageRepository) {
        this.simpleQueryStageRepository = simpleQueryStageRepository;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Mono<StageList<SimpleQuery>> getStageList() {
        // TODO needs some refactor to use a converter
        return simpleQueryStageRepository.getStageList();
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateStages() {
        // TODO needs some refactor to use a converter
        simpleQueryStageRepository.updateStages(Flux.just());
    }

}
