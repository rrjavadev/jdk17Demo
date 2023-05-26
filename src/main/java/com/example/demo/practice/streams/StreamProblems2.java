package com.example.demo.practice.streams;

import com.example.demo.model.Person;
import com.example.demo.practice.streams.model.Book;
import com.example.demo.practice.streams.model.Transaction;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Currency;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static java.lang.String.valueOf;
import static java.util.Currency.getInstance;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.summingDouble;

public class StreamProblems2 {

    public static void main(String[] args) {

        System.out.println(getAverageAge(getPeople()));

        System.out.println(getTotalSumOfTransactions(getTransactions()));

        System.out.println(getLongestWordStartingWithVowel(getWords()));

        System.out.println(getBookWithHighestRating(getBooks()));
    }

    /**
     * Given a list of books, find the book with the highest rating and display its title and author.
     * @return
     */
    public static Book getBookWithHighestRating(List<Book> books){

        return books.stream()
                .max(Comparator.comparing(Book::getRating))
                .orElse(null);

    }

    private static List<Book> getBooks(){
        return Arrays.asList(new Book("book 1", "Author 1", 1),
                new Book("book 2", "Author 2", 1),
                new Book("book 3", "Author 3", 5),
                new Book("book 4", "Author 4", 2));
    }

    public static List<String> getWords() {
        return Arrays.asList("apple", "banana", "orange", "kiwi", "elephant", "ant", "ant-eater");
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

    public static List<Transaction> getTransactions() {
        return Arrays.asList(
                new Transaction(getInstance("GBP"), 100.50),
                new Transaction(getInstance("EUR"), 75.25),
                new Transaction(getInstance("USD"), 50.75),
                new Transaction(getInstance("GBP"), 150.00),
                new Transaction(getInstance("EUR"), 125.50)
        );
    }

    /**
     * Find the average age of all people in a list of Person objects.
     *
     * @return
     */
    public static double getAverageAge(List<Person> people) {

        return people.stream()
                .mapToDouble(Person::age)
                .average()
                .orElse(0);
    }

    /**
     * Given a list of transactions, find the total sum of transactions for each distinct currency.
     *
     * @return
     */
    public static Map<Currency, Double> getTotalSumOfTransactions(List<Transaction> transactions) {

        return transactions.stream()
                .collect(groupingBy(Transaction::getCurrency, summingDouble(Transaction::getAmount)));

    }

    /**
     * Given a list of words, find the longest word that starts with a vowel.
     *
     * @return
     */
    public static String getLongestWordStartingWithVowel(List<String> words) {

        return words.stream()
                .filter(Objects::nonNull)
                .map(String::toLowerCase)
                .filter(string -> "aeiou".contains(valueOf(string.charAt(0))))
                .max(Comparator.comparing(String::length))
                .orElse("Vowel not found!!");
    }
}
