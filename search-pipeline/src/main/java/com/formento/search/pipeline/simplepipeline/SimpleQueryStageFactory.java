package com.formento.search.pipeline.simplepipeline;

import com.formento.search.pipeline.simplepipeline.product.SimpleQuery;
import com.formento.search.pipeline.stage.Stage;
import com.formento.search.pipeline.stage.StageList;

import java.util.List;

public interface SimpleQueryStageFactory {

    StageList<SimpleQuery> create();

    void updateStages(List<Stage<SimpleQuery>> stages);
}
