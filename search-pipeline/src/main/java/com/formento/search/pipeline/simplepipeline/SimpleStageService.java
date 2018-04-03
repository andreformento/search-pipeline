package com.formento.search.pipeline.simplepipeline;

import com.formento.search.pipeline.stage.StageList;

public interface SimpleStageService {

    StageList<SimpleQuery.Builder> getStageList();

}
