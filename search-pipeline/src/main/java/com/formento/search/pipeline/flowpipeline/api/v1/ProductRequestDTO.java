package com.formento.search.pipeline.flowpipeline.api.v1;

import com.formento.search.pipeline.flowpipeline.ProductRequest;

import java.io.Serializable;

class ProductRequestDTO implements ProductRequest, Serializable {

    private final String query;
    private final Integer pageNumber;

    ProductRequestDTO(String query, Integer pageNumber) {
        this.query = query;
        this.pageNumber = pageNumber;
    }

    @Override
    public String getQuery() {
        return query;
    }

    @Override
    public Integer getPageNumber() {
        return pageNumber;
    }
}
