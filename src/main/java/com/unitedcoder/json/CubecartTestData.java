package com.unitedcoder.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class CubecartTestData {
    @JsonProperty("loginuser")
    private LoginUser loginUser;
    @JsonProperty("product")
    private Product product;
    @JsonProperty("customer")
    private Customer customer;

    public CubecartTestData() {
    }

    public CubecartTestData(LoginUser loginUser, Product product, Customer customer) {
        this.loginUser = loginUser;
        this.product = product;
        this.customer = customer;
    }

    public LoginUser getLoginUser() {
        return loginUser;
    }

    public Product getProduct() {
        return product;
    }

    public Customer getCustomer() {
        return customer;
    }
}
