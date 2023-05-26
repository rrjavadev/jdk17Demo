package com.example.demo.practice.streams;

import com.example.demo.model.Person;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Objects.nonNull;
import static java.util.stream.Collectors.collectingAndThen;
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

        System.out.println(groupPeopleByNameAndReturnCountOfNamesInLong());
        //{Batman=1, Kitty=1, Nancy=2, Cathy=1, Sara=1, Chinnu=1, Cinderella=1}

        System.out.println(groupPeopleByNameAndReturnCountOfNamesInInt());
        //{Batman=1, Kitty=1, Nancy=2, Cathy=1, Sara=1, Chinnu=1, Cinderella=1}

        System.out.println(getSumOfSqrts(500000));

        System.out.println(firstEvenNumber());

        System.out.println(getCountOfAllNumbers(Arrays.asList(1, 3, 5)));

        System.out.println(getAverageAge(getPeople()));
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

    /**
     * Find the average age of all people in a list of Person objects.
     *
     * @return
     */
    public static double getAverageAge(List<Person> people) {

        return people.stream()
                .mapToDouble(Person::age)
                .peek(e -> System.out.println(e))
                .average()
                .orElse(0);
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

    public static Map<String, Long> groupPeopleByNameAndReturnCountOfNamesInLong() {
        return getPeople().stream()
                .collect(groupingBy(Person::name, counting()));
    }

    public static Map<String, Integer> groupPeopleByNameAndReturnCountOfNamesInInt() {
        return getPeople().stream()
                .collect(groupingBy(Person::name, collectingAndThen(counting(), Long::intValue)));
    }

    private static boolean isPrime(int number) {
        return number > 1 && IntStream.range(2, number)
                .noneMatch(e -> number % e == 0);
    }

    // the sum of square root of prime numbers from 2 to a given number
    public static double getSumOfSqrts(int number) {
        return IntStream.rangeClosed(0, number)
                .boxed()
                .parallel()
                .filter(MainClass::isPrime)
                .mapToDouble(e -> e)
                .map(Math::sqrt)
                .reduce(0.0, Double::sum);
    }

    private static Integer firstEvenNumber() {

        return IntStream.rangeClosed(1, 10)
                .filter(e -> e % 2 == 0)
                .map(e -> e * 2)
                .findFirst()
                .orElse(0);
    }

    private static long countNumberOfPersonNamesStartsWithA() {
        return getPeople().stream()
                .filter(e -> e.name().toUpperCase().startsWith("A"))
                .count();
    }

    private List<String> removeAllEmptyStrings(List<String> strings) {
        return strings.stream()
                .filter(s -> nonNull(s) && s.isEmpty())
                .collect(toList());
    }

    private List<String> createAListWithStringMoreThanTwoCharacters(List<String> strings) {
        return strings.stream()
                .filter(e -> nonNull(e) && e.length() > 2)
                .collect(toList());
    }

    private String convertListOfStringsToUppercaseAndJoinThenWithComma(List<String> strings) {
        return strings.stream()
                .map(String::toUpperCase)
                .collect(Collectors.joining(","));
    }

    private List<Integer> createAListOfSquareOfAllDistinctNumbers(List<Integer> numbers) {

        return numbers.stream()
                .distinct()
                .map(e -> e * e)
                .collect(toList());
    }

    private static Integer getCountOfAllNumbers(List<Integer> numbers) {
        return numbers.stream()
                .reduce(0, Integer::sum);
    }

    private static IntSummaryStatistics getSummaryStatistics(List<Integer> numbers) {

        return numbers.stream()
                .mapToInt(e -> e)
                .summaryStatistics();
    }
}
