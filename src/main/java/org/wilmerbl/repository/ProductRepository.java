package org.wilmerbl.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.wilmerbl.model.Product;
@Repository
public interface ProductRepository extends CrudRepository<Product, UUID> {
    @Query("SELECT p FROM Product p WHERE p.productAvailability = :productAvailability")
    Iterable<Product> findByProductAvailability(@Param("productAvailability") Boolean productAvailability);
    Iterable<Product> findAllByOrderByPriceAsc();
    Iterable<Product> findAllByOrderByPriceDesc();
}