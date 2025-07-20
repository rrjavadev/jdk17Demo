package com.example.demo.model;

public record LineItem(
        String productName,
        int quantity,
        double pricePerUnit
) {

}
