package com.formento.search.pipeline.flowpipeline.simplestage;

import com.formento.search.pipeline.flowpipeline.InitialStage;
import com.formento.search.pipeline.flowpipeline.Product;
import com.formento.search.pipeline.flowpipeline.ProductRequest;
import com.formento.search.pipeline.flowpipeline.ProductResponse;
import com.google.common.collect.ImmutableList;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class SimpleInitialStage implements InitialStage {
    private final PaginationLimit paginationLimit;
    private final QuerySanitizerStage querySanitizerStage;
    private final SimpleRepository repository;

    public SimpleInitialStage(PaginationLimit paginationLimit, QuerySanitizerStage querySanitizerStage, SimpleRepository repository) {
        this.paginationLimit = paginationLimit;
        this.querySanitizerStage = querySanitizerStage;
        this.repository = repository;
    }

    @Override
    public Mono<ProductResponse> transform(final Mono<? extends ProductRequest> request) {
        return request.
                filter(paginationLimit::validate).
                transform(querySanitizerStage::sanitize).
                transform(repository::getByQuery).
                flux().
                reduce(ImmutableList.<Product>builder(), ImmutableList.Builder::add).
                map(list -> new SimpleProductResponse(list.build()));


        //transform(products::getBy).
        //                flux().reduce(ImmutableList.<Product>builder(), ImmutableList.Builder::add).
        //                map(list -> new ProductResponse(list.build(), metadataFactory.create()));
    }

}
