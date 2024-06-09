package org.wilmerbl.model;

import lombok.Getter;
import lombok.Setter;

//@Getter
//@Setter
public class SearchRequest {
    private String name;
    private Double price;

    public Double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
