package com.formento.search.pipeline.simplepipeline;

import org.apache.commons.lang3.StringUtils;

class SimpleQuery {

    private final String terms;
    private final Integer pageNumber;

    SimpleQuery(final String terms, final Integer pageNumber) {
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
