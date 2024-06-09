package org.wilmerbl.controller;


import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
            @RequestParam(required = false) String description,
            @RequestParam(required = false) Double price,
            @RequestParam(required = false) Boolean productAvailability) {
        Iterable<Product> products = productService.findAllFiltered(name, description, price, productAvailability);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Product product){
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<Product> postProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Product> putProduct(@PathVariable UUID id, @RequestBody Product product) {
        return !productService.existsById(id) ? new ResponseEntity<>(
                productService.save(product), HttpStatus.CREATED)
                : new ResponseEntity<>(productService.save(product), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    ResponseEntity<Void> deleteProduct(@PathVariable UUID id){
        return productService.deleteById(id);
    }






}
