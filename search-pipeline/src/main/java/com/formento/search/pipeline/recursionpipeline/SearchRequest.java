package com.formento.search.pipeline.recursionpipeline;

public class SearchRequest {

    private final String term;
    private final Integer pageNumber;

    public SearchRequest(String term, Integer pageNumber) {
        this.term = term;
        this.pageNumber = pageNumber;
    }

}
