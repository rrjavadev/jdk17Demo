package com.example.demo.functioncomposition;

import java.util.function.Function;

public class Orchestrate {
    public static void main(String[] args) {

        Function<FoodItem, FoodItem> curryItem = e -> new Curry().tasteIt(e);
        Function<FoodItem, FoodItem> riceItem = e -> new Rice().tasteIt(e);
        Function<FoodItem, FoodItem> friesItem = e -> new Fries().tasteIt(e);

        curryItem
                .andThen(riceItem)
                .andThen(friesItem)
                .apply(new FoodItem("Fish", 5, "Indian"));
    }
}
