package com.formento.search.pipeline.managedproductpipeline.product.responsehandler;

import com.formento.search.pipeline.managedproductpipeline.ProductResponse;
import com.formento.search.pipeline.managedproductpipeline.product.ProductResponseHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
// TODO conditional
public class ProductResponseInfoLogHandler implements ProductResponseHandler {

    private static final Logger logger = LogManager.getLogger(ProductResponseInfoLogHandler.class);

    @Override
    public void accept(ProductResponse productResponse) {
        logger.info("Executed search with {} result", productResponse.getProducts().size());
    }

}
