package com.formento.search.pipeline.simplepipeline.management.api.v1;

import com.formento.search.pipeline.simplepipeline.SimpleManagementService;
import com.formento.search.pipeline.simplepipeline.product.SimpleQuery;
import com.formento.search.pipeline.stage.StageList;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/simple/management")
public class SimplepipelineManagementController {

    private final SimpleManagementService simpleManagementService;

    public SimplepipelineManagementController(final SimpleManagementService simpleManagementService) {
        this.simpleManagementService = simpleManagementService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Mono<StageList<SimpleQuery>> getStageList() {
        // TODO needs some refactor to use a converter
        return simpleManagementService.getStageList();
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateStages() {
        // TODO needs some refactor to use a converter
        simpleManagementService.updateStages(Flux.just());
    }

}
