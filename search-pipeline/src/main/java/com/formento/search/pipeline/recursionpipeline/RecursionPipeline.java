package com.formento.search.pipeline.recursionpipeline;

import reactor.core.publisher.Mono;

public class RecursionPipeline {

    public Mono<SearchResult> transform(final Mono<SearchRequest> searchRequest) {
        final Mono<SearchRequest> transform = searchRequest.transform(a -> a);
        transform.subscribe();
        return null;
    }

}


// build a component in that have a transformer for SearchRequest and return next Stage
// build stages to transform and returning next stage
// build "final stage" (???) to return SearchResult
