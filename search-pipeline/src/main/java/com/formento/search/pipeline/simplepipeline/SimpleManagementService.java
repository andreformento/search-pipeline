package com.formento.search.pipeline.simplepipeline;

import com.formento.search.pipeline.simplepipeline.product.SimpleQuery;
import com.formento.search.pipeline.stage.Stage;
import com.formento.search.pipeline.stage.StageList;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SimpleManagementService {

    Mono<StageList<SimpleQuery>> getStageList();

    void updateStages(final Flux<Stage<SimpleQuery>> stages);

}
