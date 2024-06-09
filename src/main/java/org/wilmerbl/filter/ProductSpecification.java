package org.wilmerbl.filter;

import jakarta.persistence.criteria.Path;
import org.springframework.data.jpa.domain.Specification;
import org.wilmerbl.model.Product;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ProductSpecification implements Specification<Product> {

    private String name;
    private String description;
    private Double price;
    private Boolean productAvailability;

    public ProductSpecification(String name, String description, Double price,
            Boolean productAvailability) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.productAvailability = productAvailability;
    }

    @Override
    public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query,
            CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        if (name != null) {
            predicates.add(criteriaBuilder.like(root.get("name"), "%" + name + "%"));
        }
        if (description != null) {
            predicates.add(criteriaBuilder.like(root.get("description"), "%" + description + "%"));
        }
        if (price != null) {
            predicates.add(criteriaBuilder.equal(root.get("price"), price));
        }
        if (productAvailability != null) {
            Path<Boolean> productAvailabilityPath = root.get("productAvailability");
            if (productAvailability) {
                predicates.add(criteriaBuilder.isTrue(productAvailabilityPath));
            } else {
                predicates.add(criteriaBuilder.isFalse(productAvailabilityPath));
            }
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }


    public static Specification<Product> hasName(String name) {
        return new ProductSpecification(name, null, null, null);
    }

    public static Specification<Product> hasDescription(String description) {
        return new ProductSpecification(null, description, null, null);
    }


    public static Specification<Product> hasPrice(Double price) {
        return new ProductSpecification(null, null, price, null);
    }

    public static Specification<Product> hasProductAvailability(Boolean productAvailability) {
        return new ProductSpecification(null, null, null, productAvailability);
    }
}
