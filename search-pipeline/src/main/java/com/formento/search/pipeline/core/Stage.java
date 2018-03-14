package com.formento.search.pipeline.core;

public interface Stage {

    QueryPipeline transform(final QueryPipeline queryPipeline);

}
