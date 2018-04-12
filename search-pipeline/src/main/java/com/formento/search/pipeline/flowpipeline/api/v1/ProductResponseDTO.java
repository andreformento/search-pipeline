package com.formento.search.pipeline.flowpipeline.api.v1;

import com.formento.search.pipeline.flowpipeline.ProductResponse;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

class ProductResponseDTO implements Serializable {

    private final List<ProductDTO> products;

    ProductResponseDTO(ProductResponse response) {
        this.products = response.getProducts().stream().map(ProductDTO::new).collect(Collectors.toList());
    }

    public List<ProductDTO> getProducts() {
        return products;
    }

}
