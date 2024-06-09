package org.wilmerbl.repository;

import java.util.List;
import org.wilmerbl.model.Product;

public interface ProductCustom {
    List<Product> findByFirstName(String name, Double price);
}
