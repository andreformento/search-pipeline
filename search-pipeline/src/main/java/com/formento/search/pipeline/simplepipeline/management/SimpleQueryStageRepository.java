package com.formento.search.pipeline.simplepipeline.management;

import com.formento.search.pipeline.simplepipeline.product.SimpleQuery;
import com.formento.search.pipeline.stage.Stage;
import com.formento.search.pipeline.stage.StageList;
import com.google.common.collect.ImmutableList;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.stream.Stream;

@Component
@CacheConfig(cacheNames = "simpleQueryStageCache")
class SimpleQueryStageRepository {

    private Mono<StageList<SimpleQuery>> stageList;

    SimpleQueryStageRepository() {
        // TODO refactor, factory
        this.stageList = Flux.
                fromStream(Stream.<Stage<SimpleQuery>>builder().
                        add(mono -> mono.map(qp -> new SimpleQuery(qp.getTerms().trim(), qp.getPageNumber()))).build()
                ).
                reduce(ImmutableList.<Stage<SimpleQuery>>builder(), ImmutableList.Builder::add).
                map(ImmutableList.Builder::build).
                map(StageList::new);
    }

    @Cacheable
    Mono<StageList<SimpleQuery>> getStageList() {
        return stageList;
    }

    @CacheEvict(allEntries = true)
    void updateStages(final Flux<Stage<SimpleQuery>> stages) {
        // TODO refactor, factory
        this.stageList = stages.
                reduce(ImmutableList.<Stage<SimpleQuery>>builder(), ImmutableList.Builder::add).
                map(ImmutableList.Builder::build).
                map(StageList::new);
    }

}
