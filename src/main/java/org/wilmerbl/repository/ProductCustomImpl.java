package org.wilmerbl.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.wilmerbl.model.Product;

public class ProductCustomImpl implements ProductCustom {
    @Autowired
    private EntityManager entityManager;
    @Override
    public List<Product> findByFirstName(String name, Double price) {
        CriteriaBuilder cb=entityManager.getCriteriaBuilder();
        CriteriaQuery cq=cb.createQuery();
        Root<Product> productRoot=cq.from(Product.class);
        Predicate firstNamePredicate=cb.equal(productRoot.get("name"), name);
        Predicate firstDoublePredicate=cb.equal(productRoot.get("price"), price);
        cq.where(firstNamePredicate);
        TypedQuery<Product> query=entityManager.createQuery(cq);
        return query.getResultList();
    }
}
