package com.formento.search.pipeline.managedproductpipeline.product.api.v1;

import com.formento.search.pipeline.managedproductpipeline.ProductResponse;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class ProductResponseDTO implements Serializable {

    private final List<ProductDTO> products;
    private final Map<String, String> metadatas;

    ProductResponseDTO(ProductResponse productResponse) {
        this.products = productResponse.getProducts().stream().map(ProductDTO::new).collect(Collectors.toList());
        this.metadatas = productResponse.getMetadatas().orElse(null);
    }

    public List<ProductDTO> getProducts() {
        return products;
    }

    public Map<String, String> getMetadatas() {
        return metadatas;
    }
}
