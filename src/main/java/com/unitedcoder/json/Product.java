package com.unitedcoder.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {
    @JsonProperty("product-name")
    private String productName;
    @JsonProperty("product-code")
    private String productCode;
    @JsonProperty("category")
    private String productCategory;
    @JsonProperty("manufacturer")
    private String productManufacturer;
    public Product() {
    }

    public Product(String productName, String productCode, String productCategory, String productManufacturer) {
        this.productName = productName;
        this.productCode = productCode;
        this.productCategory = productCategory;
        this.productManufacturer = productManufacturer;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public String getProductManufacturer() {
        return productManufacturer;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", productCode='" + productCode + '\'' +
                ", productCategory='" + productCategory + '\'' +
                ", productManufacturer='" + productManufacturer + '\'' +
                '}';
    }
}
