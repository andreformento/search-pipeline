package com.formento.search.pipeline.core;

public interface QueryTransformerPipeline {

    QueryPipeline execute(final QueryPipeline queryPipeline);

}
