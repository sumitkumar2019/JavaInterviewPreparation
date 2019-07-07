package com.sky.java.preparation.Java8Features.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Product{
    int id;
    String name;
    float price;
    public Product(int id, String name, float price){
        this.id = id;
        this.name = name;
        this.price = price;
    }
}


public class LambdaExpressionComparator {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Phillips1", 2300.0f));
        products.add(new Product(2, "Phillips2", 2400.0f));
        products.add(new Product(3, "CatPhillips", 2500.0f));
        products.add(new Product(4, "RatPhillips", 2100.0f));

        Collections.sort(products,(p1,p2)->p1.name.compareTo(p2.name));

        products.forEach(product -> System.out.println(product.name + " " + product.price));
    }
}
