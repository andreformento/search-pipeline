package com.formento.search.pipeline.simplepipeline;

import com.google.common.collect.ImmutableList;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public final class SimpleQuery {

    private final String terms;
    private final String queryField;
    private final List<String> sortOrder;
    private final Integer pageNumber;

    private SimpleQuery(final String terms, String queryField, List<String> sortOrder, final Integer pageNumber) {
        this.terms = terms;
        this.queryField = queryField;
        this.sortOrder = sortOrder;
        this.pageNumber = pageNumber;
    }

    public String getTerms() {
        return StringUtils.isBlank(terms) ? "" : terms;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public List<String> getSortOrder() {
        return sortOrder;
    }

    public final class Builder {
        private String terms;
        private String queryField;
        private ImmutableList.Builder<String> sortOrder;
        private Integer pageNumber;

        public Builder(String terms) {
            this.terms = terms;
        }

        public Builder setTerms(String terms) {
            this.terms = terms;
            return this;
        }

        public Builder setQueryField(String queryField) {
            this.queryField = queryField;
            return this;
        }

        public Builder addSortOrder(List<String> sortOrder) {
            this.sortOrder.addAll(sortOrder);
            return this;
        }

        public Builder setPageNumber(Integer pageNumber) {
            this.pageNumber = pageNumber;
            return this;
        }

        public SimpleQuery build() {
            return new SimpleQuery(terms, queryField, sortOrder.build(), pageNumber);
        }
    }

}
