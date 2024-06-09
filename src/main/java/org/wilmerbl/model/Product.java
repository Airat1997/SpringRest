package org.wilmerbl.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.util.UUID;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Product {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "UUID")
    private UUID id;
    @Column(name = "name", length = 256)
    private String name;
    @Column(name = "description", length = 4096)
    private String description;
    @Column(name = "price")
    private Double price;
    @Column(name = "product_availability")
    private Boolean productAvailability;
    public Product(){};
    public Product(UUID id, String name, String description, Double price, Boolean productAvailability){
        this.name = name;
        this.description = description;
        this.price = price;
        this.productAvailability = productAvailability;
        this.id = id;
    };
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getProductAvailability() {
        return productAvailability;
    }

    public void setProductAvailability(Boolean productAvailability) {
        this.productAvailability = productAvailability;
    }
}
