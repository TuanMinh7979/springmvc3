package com.mvc.service;

import com.mvc.model.Category;
import com.mvc.model.Product;

import java.util.ArrayList;


public class ProductService {
 ArrayList<Product> list = new ArrayList<Product>();

    public ArrayList<Product> getList() {
        return list;
    }

    public void setList(ArrayList<Product> list) {
        this.list = list;
    }

    public ProductService() {
        list.add(new Product(1, "p1", "/img1", 123, new Category(1, "phone")));
        list.add(new Product(2, "p2", "/img1", 123, new Category(2, "phone")));
        list.add(new Product(3, "p3", "/img1", 123, new Category(1, "phone")));

    }

    public void save(Product product) {
        list.add(product);
    }

    public void edit(int index, Product product) {
        list.set(index, product);
    }

    public void delete(int index) {
        list.remove(index);
    }

    public Product findByName(String name) {

        for (Product p : list) {
            if (p.getName().equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }

}
