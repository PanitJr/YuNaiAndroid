package com.example.asus.yunaiandroid.entity;

import java.io.Serializable;

/**
 * Created by Asus on 1/8/2559.
 */
public class User implements Serializable {
    Long id;
    String name;

    public User() {
    }

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public User(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
