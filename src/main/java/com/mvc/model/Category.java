package com.mvc.model;


import java.util.Set;

public class Category {
      private int id;
    private String name;


    private Set<Product> products;

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Category() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
