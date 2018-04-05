package com.formento.search.pipeline.managedproductpipeline.product;

import com.formento.search.pipeline.managedproductpipeline.ProductRequest;
import com.formento.search.pipeline.managedproductpipeline.ProductResponse;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class ProductService {

    private final List<ProductRequestValidator> validators;
    private final List<ProductResponseHandler> responseHandlers;
    private final ResultCache resultCache;
    private final ProductResponseFactory responseFactory;

    public ProductService(List<ProductRequestValidator> validators, List<ProductResponseHandler> responseHandlers, ResultCache resultCache, ProductResponseFactory responseFactory) {
        this.validators = validators;
        this.responseHandlers = responseHandlers;
        this.resultCache = resultCache;
        this.responseFactory = responseFactory;
    }

    public Mono<ProductResponse> getProducts(final Mono<ProductRequest> request) {
        validators.parallelStream().forEach(request::subscribe);

        final Mono<ProductResponse> productResponseMono = resultCache.
                getResults(request).
                orElseGet(() -> responseFactory.fromRepository(request));

        responseHandlers.parallelStream().forEach(productResponseMono::doOnSuccess);

        return productResponseMono;
    }

}
