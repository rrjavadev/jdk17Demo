package com.example.demo.functioncomposition;

import java.util.Arrays;
import java.util.function.Function;

public class Orchestrate {
    final Function<FoodItem, FoodItem> foodItemFunction;

    public Orchestrate(Function<FoodItem, FoodItem>... foodItems) {
        foodItemFunction = Arrays.stream(foodItems)
                .reduce(Function.identity(), Function::andThen);
    }

    public void startTasting(FoodItem foodItem) {
        foodItemFunction.apply(foodItem);
    }

    public static void main(String[] args) {

        Function<FoodItem, FoodItem> tasteCurry = e -> new Curry().tasteIt(e);
        Function<FoodItem, FoodItem> tasteRice = e -> new Rice().tasteIt(e);
        Function<FoodItem, FoodItem> tasteFries = e -> new Fries().tasteIt(e);

//        curryItem
//                .andThen(riceItem)
//                .andThen(friesItem)
//                .apply(new FoodItem("Fish", 5, "Indian"));
//         or

        new Orchestrate(tasteCurry, tasteRice, tasteFries)
                .startTasting(new FoodItem("Fish", 5, "Indian"));
    }
}
