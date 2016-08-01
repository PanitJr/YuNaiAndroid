package com.example.asus.yunaiandroid.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by CAMT on 1/8/2559.
 */
public class Team {
    Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<User> getMembers() {
        return members;
    }

    public void setMembers(Set<User> members) {
        this.members = members;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    String name;
    String password;
    Set<User> members = new HashSet<>();
}
