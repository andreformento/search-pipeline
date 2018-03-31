package com.formento.search.pipeline.simplepipeline;

import com.formento.search.pipeline.simplepipeline.product.SimpleQuery;
import com.formento.search.pipeline.stage.Stage;
import com.formento.search.pipeline.stage.StageList;
import org.springframework.cache.annotation.Cacheable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SimpleQueryStageRepository {

    Mono<StageList<SimpleQuery>> getStageList();

    void updateStages(final Flux<Stage<SimpleQuery>> stages);
}
