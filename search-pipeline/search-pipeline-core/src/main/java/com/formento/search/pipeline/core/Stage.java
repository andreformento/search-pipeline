package com.formento.search.pipeline.core;

public interface Stage<T> {

    T transform(final T queryPipeline);

}
