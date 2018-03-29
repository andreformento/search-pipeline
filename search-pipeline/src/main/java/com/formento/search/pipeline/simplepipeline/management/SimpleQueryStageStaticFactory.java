package com.formento.search.pipeline.simplepipeline.management;

import com.formento.search.pipeline.simplepipeline.product.SimpleQuery;
import com.formento.search.pipeline.stage.Stage;
import com.formento.search.pipeline.simplepipeline.SimpleQueryStageFactory;
import com.formento.search.pipeline.stage.StageList;
import com.google.common.collect.ImmutableList;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.google.common.collect.ImmutableList.copyOf;

@Component
@CacheConfig(cacheNames = "simpleQueryStageCache")
class SimpleQueryStageStaticFactory implements SimpleQueryStageFactory{

    private List<Stage<SimpleQuery>> stages;

    SimpleQueryStageStaticFactory() {
        this.stages = ImmutableList.<Stage<SimpleQuery>>builder().
                add(mono -> mono.map(qp -> new SimpleQuery(qp.getTerms().trim(), qp.getPageNumber()))).
                build();
    }

    @Override
    @Cacheable
    public StageList<SimpleQuery> create() {
        return new StageList<>(stages);
    }

    @Override
    @CacheEvict(allEntries = true)
    public void updateStages(final List<Stage<SimpleQuery>> stages) {
        this.stages = copyOf(stages);
    }

}
