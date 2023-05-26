package com.example.demo.practice.streams.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;

@Data
@AllArgsConstructor
public class Order {
    double amount;
    Instant date;
}
