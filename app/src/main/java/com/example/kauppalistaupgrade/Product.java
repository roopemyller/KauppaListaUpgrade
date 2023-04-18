package com.example.kauppalistaupgrade;

import java.io.Serializable;
import java.util.Comparator;

public class Product implements Serializable {
    private String productName;
    private String productId;
    private int isImportant;

    public Product(String name, int isImportant){
        this.productName = name;
        this.isImportant = isImportant;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getIsImportant() {
        return isImportant;
    }

}
