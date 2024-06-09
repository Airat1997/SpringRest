package org.wilmerbl.service;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.wilmerbl.filter.ProductSpecification;
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

    public Product save(Product product){
        return productRepository.save(product);
    }
    public Iterable<Product> findAllFiltered(String name,String description, Double price, Boolean productAvailability) {
        Specification<Product> spec = Specification.where(null);
        if (name!= null) {
            spec = spec.and(ProductSpecification.hasName(name));
        }
        if (description!= null) {
            spec = spec.and(ProductSpecification.hasDescription(description));
        }
        if (price!= null) {
            spec = spec.and(ProductSpecification.hasPrice(price));
        }
        if (productAvailability!= null) {
            spec = spec.and(ProductSpecification.hasProductAvailability(productAvailability));
        }
        return productRepository.findAll(spec);
    }
}
