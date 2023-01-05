package com.example.demo.practice.streams;

import com.example.demo.model.Person;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.partitioningBy;

public class MainClass {
    public static void main(String[] args) {

        System.out.println(getOddAge());
        System.out.println(getEvenAge());
        System.out.println(getByUsingPartitioningByForEvenAndOddAges());
        System.out.println(groupPeopleBasedOnTheirNames());
    }

    public static List<Person> getPeople() {
        return List.of(new Person("Sara", 20),
                new Person("Nancy", 22),
                new Person("Cathy", 23),
                new Person("Chinnu", 1),
                new Person("Kitty", 4),
                new Person("Batman", 9),
                new Person("Nancy", 25),
                new Person("Cinderella", 10));
    }

    public static List<Person> getOddAge() {
        return getPeople().stream()
                .filter(e -> e.age() % 2 != 0)
                .collect(Collectors.toList());
    }

    public static List<Person> getEvenAge() {
        return getPeople().stream()
                .filter(e -> e.age() % 2 == 0)
                .collect(Collectors.toList());
    }

    public static Map<Boolean, List<Person>> getByUsingPartitioningByForEvenAndOddAges() {
        return getPeople().stream()
                .collect(partitioningBy(person -> person.age() % 2 == 0));
    }

    public static Map<String, List<Person>> groupPeopleBasedOnTheirNames(){
        return getPeople().stream()
                .collect(groupingBy(Person::name));
    }
}
