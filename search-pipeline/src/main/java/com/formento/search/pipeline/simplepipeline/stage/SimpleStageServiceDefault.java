package com.formento.search.pipeline.simplepipeline.stage;

import com.formento.search.pipeline.simplepipeline.SimpleQuery;
import com.formento.search.pipeline.simplepipeline.SimpleStage;
import com.formento.search.pipeline.simplepipeline.SimpleStageService;
import com.formento.search.pipeline.stage.StageList;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class SimpleStageServiceDefault implements SimpleStageService {

    private final StageList<SimpleQuery.Builder> stageList;

    SimpleStageServiceDefault(final List<SimpleStage> simpleStages) {
        this.stageList = new StageList<>(simpleStages);
    }

    @Override
    public StageList<SimpleQuery.Builder> getStageList() {
        return stageList;
    }

}
