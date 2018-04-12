package com.formento.search.pipeline.flowpipeline.api.v1;

import com.formento.search.pipeline.flowpipeline.PipelineService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/search/flow")
class PipelineController {

    private final PipelineService pipelineService;

    PipelineController(PipelineService pipelineService) {
        this.pipelineService = pipelineService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Mono<ProductResponseDTO> searchForProduct(
            @RequestParam("query") final String query,
            @RequestParam("pg") final Integer pageNumber
    ) {
        // TODO
        final Mono<ProductRequestDTO> dto = Mono.just(new ProductRequestDTO(query, pageNumber));

        return pipelineService.searchForProduct(dto).map(ProductResponseDTO::new);
    }

}
