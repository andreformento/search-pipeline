package com.formento.search.pipeline.simplepipeline.product;

import org.apache.commons.lang3.StringUtils;

public class SimpleQuery {

    private final String terms;
    private final Integer pageNumber;

    public SimpleQuery(final String terms, final Integer pageNumber) {
        this.terms = terms;
        this.pageNumber = pageNumber;
    }

    public String getTerms() {
        return StringUtils.isBlank(terms) ? "" : terms;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

}
