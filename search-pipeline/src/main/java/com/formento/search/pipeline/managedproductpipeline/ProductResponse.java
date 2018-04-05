package com.formento.search.pipeline.managedproductpipeline;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public final class ProductResponse {

    private final List<Product> products;
    private final Optional<Map<String, String>> metadatas;

    public ProductResponse(List<Product> products, Optional<Map<String, String>> metadatas) {
        this.products = products;
        this.metadatas = metadatas;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Optional<Map<String, String>> getMetadatas() {
        return metadatas;
    }
}
