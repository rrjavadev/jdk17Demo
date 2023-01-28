package com.example.demo.functioncomposition;

public class Rice implements Food {
    @Override
    public FoodItem tasteIt(FoodItem foodItem) {
        System.out.println("Inside--" + "Rice");
        System.out.println("received food--" + foodItem.name());
        return new FoodItem("Rice", 5, "Indian");
    }
}
