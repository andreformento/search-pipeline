package com.formento.search.pipeline.managedproductpipeline.product.validator;

import com.formento.search.pipeline.managedproductpipeline.ProductRequest;
import com.formento.search.pipeline.managedproductpipeline.product.ProductRequestValidator;
import com.formento.search.pipeline.managedproductpipeline.product.exception.PageOutOfRangeException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
// TODO conditional
public class ProductRequestPaginationValidator implements ProductRequestValidator {

    // TODO create a configuration to set this like an option
    private static final Optional<Integer> MAX_PAGE_SIZE = Optional.of(200);

    @Override
    public void accept(final ProductRequest productRequest) {
        MAX_PAGE_SIZE.
                filter(maxPage -> productRequest.getPageNumber() > maxPage).
                ifPresent(maxPage -> {
                    throw new PageOutOfRangeException(maxPage, productRequest.getPageNumber());
                });
    }

}
