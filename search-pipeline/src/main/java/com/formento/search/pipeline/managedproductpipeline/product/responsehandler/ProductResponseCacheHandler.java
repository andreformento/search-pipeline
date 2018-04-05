package com.formento.search.pipeline.managedproductpipeline.product.responsehandler;

import com.formento.search.pipeline.managedproductpipeline.ProductResponse;
import com.formento.search.pipeline.managedproductpipeline.product.ProductResponseHandler;
import org.springframework.stereotype.Component;

@Component
// TODO conditional
public class ProductResponseCacheHandler implements ProductResponseHandler {

    @Override
    public void accept(ProductResponse productResponse) {
        // TODO put result in cache
    }

}
