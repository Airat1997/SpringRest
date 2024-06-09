package org.wilmerbl.service;

import org.springframework.stereotype.Service;
import org.wilmerbl.model.Product;
import org.wilmerbl.repository.ProductCustomImpl;
import org.wilmerbl.repository.ProductRepository;

@Service
public class ProductService extends ProductCustomImpl {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }
}
