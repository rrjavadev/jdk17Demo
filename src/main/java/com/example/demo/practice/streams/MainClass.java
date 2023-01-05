package com.example.demo.practice.streams;

import com.example.demo.model.Person;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.toList;

public class MainClass {
    public static void main(String[] args) {

        System.out.println(getOddAge());
        //[Person[name=Cathy, age=23], Person[name=Chinnu, age=1], Person[name=Batman, age=9], Person[name=Nancy, age=25]]

        System.out.println(getEvenAge());
        //[Person[name=Sara, age=20], Person[name=Nancy, age=22], Person[name=Kitty, age=4], Person[name=Cinderella, age=10]]

        System.out.println(getByUsingPartitioningByForEvenAndOddAges());
        /*
         * {false=[Person[name=Cathy, age=23], Person[name=Chinnu, age=1], Person[name=Batman, age=9], Person[name=Nancy, age=25]],
         * true=[Person[name=Sara, age=20], Person[name=Nancy, age=22], Person[name=Kitty, age=4], Person[name=Cinderella, age=10]]}
         */

        System.out.println(groupPeopleBasedOnTheirNames());
        /*
         * {Batman=[Person[name=Batman, age=9]], Kitty=[Person[name=Kitty, age=4]],
         * Nancy=[Person[name=Nancy, age=22], Person[name=Nancy, age=25]], Cathy=[Person[name=Cathy, age=23]],
         * Sara=[Person[name=Sara, age=20]],
         * Chinnu=[Person[name=Chinnu, age=1]], Cinderella=[Person[name=Cinderella, age=10]]}
         */

        System.out.println(groupPeopleByNameAndReturnAListOfAges());
        //{Batman=[9], Kitty=[4], Nancy=[22, 25], Cathy=[23], Sara=[20], Chinnu=[1], Cinderella=[10]}

        System.out.println(groupPeopleByNameAndReturnCountOfNames());
        //{Batman=1, Kitty=1, Nancy=2, Cathy=1, Sara=1, Chinnu=1, Cinderella=1}
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

    public static Map<String, List<Person>> groupPeopleBasedOnTheirNames() {
        return getPeople().stream()
                .collect(groupingBy(Person::name));
    }

    public static Map<String, List<Integer>> groupPeopleByNameAndReturnAListOfAges() {
        return getPeople().stream()
                .collect(groupingBy(Person::name, mapping(Person::age, toList())));
    }

    public static Map<String, Long> groupPeopleByNameAndReturnCountOfNames() {
        return getPeople().stream()
                .collect(groupingBy(Person::name, counting()));
    }
}
