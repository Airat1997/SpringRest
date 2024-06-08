package org.wilmerbl.service;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.wilmerbl.model.Product;
import org.wilmerbl.repository.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    public  Iterable<Product> findAll(){
        return productRepository.findAll();
    }
    public  Iterable<Product> findAllByProductAvailability(Boolean productAvailability){
        return productRepository.findByProductAvailability(productAvailability);
    }
    public  Iterable<Product> findAllByOrderByPriceAsc(){
        return productRepository.findAllByOrderByPriceAsc();
    }
    public  Iterable<Product> findAllByOrderByPriceDesc(){
        return productRepository.findAllByOrderByPriceDesc();
    }
}
