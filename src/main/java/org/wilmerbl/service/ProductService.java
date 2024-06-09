package org.wilmerbl.service;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.wilmerbl.model.Product;
import org.wilmerbl.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Iterable<Product> findAll(Specification<Product> spec) {
        return productRepository.findAll(spec);
    }
}
