package org.wilmerbl.repository;

import java.util.UUID;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wilmerbl.model.Product;
@Repository
public interface ProductRepository extends CrudRepository<Product, UUID> {

    Iterable<Product> findAll(Specification<Product> spec);
}