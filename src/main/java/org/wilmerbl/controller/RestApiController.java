package org.wilmerbl.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.wilmerbl.ProductSpecification;
import org.wilmerbl.model.Product;
import org.wilmerbl.service.ProductService;

@RestController
@RequestMapping(path = "/product")
public class RestApiController {

    @Autowired
    private final ProductService productService;

    public RestApiController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<Iterable<Product>> getProducts(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Double price) {
        Specification<Product> spec = Specification.where(null);
        if (name!= null) {
            spec = spec.and(ProductSpecification.hasName(name));
        }
        return new ResponseEntity<>(productService.findAll(spec), HttpStatus.OK);
    }


}
