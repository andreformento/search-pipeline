package com.formento.search.pipeline.stage;

public interface Stage<T> {

    T transform(final T queryPipeline);

}
