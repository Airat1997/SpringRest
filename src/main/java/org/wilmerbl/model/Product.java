package org.wilmerbl.model;

import java.util.UUID;

public class Product {
    private UUID id;
    private String name;
    private String description;
    private Double price;
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
