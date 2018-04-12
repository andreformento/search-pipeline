package com.formento.search.pipeline.flowpipeline.simplestage;

import com.formento.search.pipeline.flowpipeline.Product;
import com.formento.search.pipeline.flowpipeline.ProductResponse;

import java.util.List;

class SimpleProductResponse implements ProductResponse {
    private List<Product> products;

    SimpleProductResponse(List<Product> products) {
        this.products = products;
    }

    @Override
    public List<Product> getProducts() {
        return products;
    }
}
