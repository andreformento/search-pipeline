package com.formento.search.pipeline.managedproductpipeline.product;

public final class ProductQuery {

    private final String term;

    ProductQuery(String term) {
        this.term = term;
    }

    public String buildQuery() {
        return "title:" + term;
    }

}
