package com.example.demo.practice.streams.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Currency;

@Data
@AllArgsConstructor
public class Transaction {

    private Long customerId;
    private Currency currency;
    private double amount;
}
