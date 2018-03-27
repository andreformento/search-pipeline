package com.formento.search.pipeline.core;

public class PipelineTransformer<T> {

    private final StageList<T> stages;

    public PipelineTransformer(final StageList<T> stages) {
        this.stages = stages;
    }

    public T transform(final T queryPipeline) {
        return stages.consume(queryPipeline);
    }

}
