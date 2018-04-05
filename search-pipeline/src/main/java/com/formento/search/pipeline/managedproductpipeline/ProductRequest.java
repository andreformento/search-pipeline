package com.formento.search.pipeline.managedproductpipeline;

public final class ProductRequest {

    private final String term;
    private final Integer pageNumber;

    public ProductRequest(String term, Integer pageNumber) {
        this.term = term;
        this.pageNumber = pageNumber;
    }

    public String getTerm() {
        return term;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

}
