package com.formento.search.pipeline.core;

import java.util.List;

public class SequencialQueryTransformerPipeline implements QueryTransformerPipeline {

    private final List<Stage> stages;

    public SequencialQueryTransformerPipeline(final List<Stage> stages) {
        this.stages = stages;
    }

    @Override
    public QueryPipeline execute(final QueryPipeline queryPipeline) {
        QueryPipeline result = queryPipeline;

        for (final Stage stage : stages) {
            result = stage.transform(result);
        }

        return result;
    }

//    private QueryPipeline rec(final QueryPipeline queryPipeline) {
//
//    }
}
