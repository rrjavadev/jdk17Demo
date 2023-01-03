package com.example.demo;


import java.util.Arrays;
import java.util.List;

public class PracticeJava17 {

    public void testTestBlocks() {
        System.out.println("""
                At least this works as expected!    
                Hey, having new line is no problem!!
                """);
    }

    public void testNulls() {
        String nullString = null;
        String nonNullString = "A";
        String anotherNull = null;
        System.out.println(nullString.toLowerCase() + nonNullString.toLowerCase() + anotherNull.toUpperCase());
    }

    public int testSwitchExpressions(String day) {

        int j = switch (day) {
            case "MONDAY" -> 0;
            case "TUESDAY" -> 1;
            default -> {
                int k = day.length();
                yield k;
            }
        };

        System.out.println(j);
        return j;
    }

    public int testSwitchExpressions2(String day) {

        int j = switch (day) {
            case "MONDAY" -> 0;
            case "TUESDAY" -> 1;
            default -> 3;
        };

        System.out.println(j);
        return j;
    }

    public int testSwitchStatement(String day) {

        switch (day) {
            case "MONDAY":
                System.out.println("monday");
                break;
            case "TUESDAY":
                System.out.println("tuesday");
                break;
            default: {
                int k = day.length();
               break;
            }
        }
        return 0;

    }
}
