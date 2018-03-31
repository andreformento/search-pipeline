package com.formento.search.pipeline.simplepipeline.management;

import com.formento.search.pipeline.simplepipeline.SimpleManagementService;
import com.formento.search.pipeline.simplepipeline.product.SimpleQuery;
import com.formento.search.pipeline.stage.Stage;
import com.formento.search.pipeline.stage.StageList;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
class SimpleManagementServiceDefault implements SimpleManagementService {

    private final SimpleQueryStageRepository repository;

    SimpleManagementServiceDefault(SimpleQueryStageRepository repository) {
        this.repository = repository;
    }

    @Override
    public Mono<StageList<SimpleQuery>> getStageList() {
        return repository.getStageList();
    }

    @Override
    public void updateStages(Flux<Stage<SimpleQuery>> stages) {
        repository.updateStages(stages);
    }
    
}
