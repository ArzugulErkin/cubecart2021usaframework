package com.unitedcoder.json;
//user pojo class

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    @JsonProperty("username")
    private String username;
    @JsonProperty("password")
    private String password;
    @JsonProperty("usertype")
    private String usertype;
    @JsonProperty("age")
    private int age;
    @JsonProperty("active")
    private boolean active;

    public User() {
    }
    public User(String username, String password, String usertype, int age, boolean active) {
        this.username = username;
        this.password = password;
        this.usertype = usertype;
        this.age = age;
        this.active = active;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getUsertype() {
        return usertype;
    }

    public int getAge() {
        return age;
    }

    public boolean isActive() {
        return active;
    }
}
