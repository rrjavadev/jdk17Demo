package com.example.demo.decorator;

import java.awt.*;

public class SampleDecoratorUsingLambda {
    public static void printIt(Camera camera){
        System.out.println(camera.snap(new Color(125, 125, 125)));
    }

    public static void main(String... args){
        printIt(new Camera());
        printIt(new Camera(Color::brighter));
        printIt(new Camera(Color::brighter, Color::darker, Color::brighter));
    }
}
