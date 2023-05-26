package com.example.demo.practice.streams.Transaction;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Currency;

@Data
@AllArgsConstructor
public class Transaction {
    private Currency currency;
    private double amount;
}
