package org.wilmerbl.model;

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

@Repository
@RequiredArgsConstructor
public class SearchDao {

    private final EntityManager em;

    public List<Product> findAllSimpleQuery(
            String name,
            Double price
    ) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Product> criteriaQuery = criteriaBuilder.createQuery(Product.class);
        Root<Product> root = criteriaQuery.from(Product.class);

        Predicate namePredicate = criteriaBuilder.like(root.get("name"), "%" + name + "%");
        Predicate pricePredicate = criteriaBuilder.like(root.get("price"), "%" + price + "%");

        criteriaQuery.where(criteriaBuilder.and(namePredicate, pricePredicate));
        TypedQuery<Product> query = em.createQuery(criteriaQuery);
        return query.getResultList();
    }

    public List<Product> findAllByCriteria(
            SearchRequest request
    ){
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Product> criteriaQuery = criteriaBuilder.createQuery(Product.class);
        List<Predicate> predicates = new ArrayList<>();
        Root<Product> root = criteriaQuery.from(Product.class);
        if(request.getName() != null){
            Predicate namePredict = criteriaBuilder.like(root.get("name"), "%" + request.getName() + "%");
            predicates.add(namePredict);
        }
        criteriaQuery.where(criteriaBuilder.or(predicates.toArray(new Predicate[0])));
        TypedQuery<Product> query = em.createQuery(criteriaQuery);
        return query.getResultList();
    }

}
