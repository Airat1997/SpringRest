package org.wilmerbl;

import org.springframework.data.jpa.domain.Specification;
import org.wilmerbl.model.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.RequiredTypes;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.domain.Specification;

public class ProductSpecification implements Specification<Product> {

    private String name;
    private Double price;

    public ProductSpecification(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        if (name!= null) {
            predicates.add(criteriaBuilder.like(root.get("name"), "%" + name + "%"));
        }

        if (price!= null) {
            predicates.add(criteriaBuilder.gt(root.get("price"), price));
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }

    public static Specification<Product> hasName(String name) {
        return new ProductSpecification(name, null);
    }

    public static Specification<Product> hasPrice(Double price) {
        return new ProductSpecification(null, price);
    }
}
