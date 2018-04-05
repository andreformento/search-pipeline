package com.formento.search.pipeline.managedproductpipeline.product.exception;


// TODO handlerException
public class PageOutOfRangeException extends RuntimeException {

    private final Integer maxPage;
    private final Integer pageNumber;

    public PageOutOfRangeException(Integer maxPage, Integer pageNumber) {
        this.maxPage = maxPage;
        this.pageNumber = pageNumber;
    }

}
