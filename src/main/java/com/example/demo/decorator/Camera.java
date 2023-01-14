package com.example.demo.decorator;

import java.awt.*;
import java.util.function.Function;
import java.util.stream.Stream;

public class Camera {
    private Function<Color, Color> filter;

    public Camera(Function<Color, Color>... filters){

//        filter = input -> input;
//        for(Function<Color, Color> aFilter: filters){
//            filter = filter.andThen(aFilter);
//        }

        //Can be rewritten as ...
//        filter = Stream.of(filters)
//                .reduce(input -> input, (aFilter, result) -> result.andThen(aFilter));

        //Can be rewritten as ...
        filter = Stream.of(filters)
                .reduce(Function.identity(), Function::andThen);
    }

    public Color snap(Color input){
        return filter.apply(input);
    }
}
/**
 java.awt.Color[r=125,g=125,b=125]
 java.awt.Color[r=178,g=178,b=178]
 java.awt.Color[r=177,g=177,b=177]
 */