package com.example.demo.functionalcomposition;

public class Curry implements Food {
    @Override
    public FoodItem tasteIt(FoodItem foodItem) {
        System.out.println("Inside--" + "Curry");
        System.out.println("received food--" + foodItem.name());
        return new FoodItem("Curry", 5, "Indian");
    }
}
