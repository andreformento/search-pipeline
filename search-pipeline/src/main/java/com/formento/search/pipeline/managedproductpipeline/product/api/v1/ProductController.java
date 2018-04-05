package com.formento.search.pipeline.managedproductpipeline.product.api.v1;

import com.formento.search.pipeline.managedproductpipeline.ProductRequest;
import com.formento.search.pipeline.managedproductpipeline.product.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/search/managed")
class ProductController {

    private final ProductService productService;

    ProductController(final ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Mono<ProductResponseDTO> search(
            @RequestParam("query") final String query,
            @RequestParam("pg") final Integer pageNumber
    ) {
        // TODO needs some refactor to use a converter
        final Mono<ProductRequest> productRequest = Mono.just(new ProductRequest(query, pageNumber));
        return productService.getProducts(productRequest).map(ProductResponseDTO::new);
    }

}
