package com.sky.java.preparation.JavaBasicsTill4.Serialization.object;

import java.io.Serializable;

public class Person implements Serializable {
    transient Integer id;
    String name;
    String city;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
