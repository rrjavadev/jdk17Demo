package com.example.demo.model;

import java.util.Set;

public record Order(String customerName, Set<LineItem> lineItems) {
}
