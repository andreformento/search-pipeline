package com.formento.search.pipeline.flowpipeline.simplestage;

import com.formento.search.pipeline.flowpipeline.ProductRequest;
import org.springframework.stereotype.Component;

@Component
class PaginationLimit {
    boolean validate(ProductRequest productRequest) {
        return productRequest.getPageNumber() <= 100;
    }
}
