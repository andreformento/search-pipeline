package com.formento.search.pipeline.recursionpipeline;

public interface RecursionPipeline {

    SearchResult transform(final SearchRequest searchRequest);

}


// build a component in that have a transformer for SearchRequest and return next Stage
// build stages to transform and returning next stage
// build "final stage" (???) to return SearchResult
