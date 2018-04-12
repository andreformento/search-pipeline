package com.formento.search.pipeline.flowpipeline.api.v1;

import com.formento.search.pipeline.flowpipeline.Product;

import java.io.Serializable;

class ProductDTO implements Serializable {

    private final String id;
    private final String title;

    ProductDTO(Product product) {
        this.id = product.getId();
        this.title = product.getTitle();
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

}
