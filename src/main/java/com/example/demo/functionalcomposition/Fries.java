package com.example.demo.functionalcomposition;

public class Fries implements Food{
    @Override
    public FoodItem tasteIt(FoodItem foodItem) {
        System.out.println("Inside--" + "Fries");
        System.out.println("received food--" + foodItem.name());
        return new FoodItem("Fries", 2, "American");
    }
}
