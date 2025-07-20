package com.example.demo.practice.streams.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {
    String title;
    String author;
    double rating;
}
