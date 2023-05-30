package com.example.demo.practice.streams;

import com.example.demo.model.Person;
import com.example.demo.practice.streams.model.Book;
import com.example.demo.practice.streams.model.Employee;
import com.example.demo.practice.streams.model.Order;
import com.example.demo.practice.streams.model.Product;
import com.example.demo.practice.streams.model.Transaction;

import java.time.Instant;
import java.util.Arrays;
import java.util.Currency;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.String.valueOf;
import static java.time.Duration.ofDays;
import static java.util.Arrays.asList;
import static java.util.Comparator.comparing;
import static java.util.Currency.getInstance;
import static java.util.stream.Collectors.averagingDouble;
import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.summingDouble;
import static java.util.stream.Collectors.toMap;

public class StreamProblems2 {

    public static void main(String[] args) {

        System.out.println(getAverageAge(getPeople()));

        System.out.println(getTotalSumOfTransactions(getTransactions()));

        System.out.println(getLongestWordStartingWithVowel(getWords()));

        System.out.println(getBookWithHighestRating(getBooks()));

        System.out.println(getTotalRevenueGenerated(getOrders(), 30));

        System.out.println(getSumOfSquares(getAListOfIntegersInRange(1, 10)));

        System.out.println(getNumberOfOccurrencesOfEachDistinctWordAndCount(getWords()));

        System.out.println(getTopNProducts(getProducts(), 3));

        System.out.println(getAverageSalary(getEmployees()));

        System.out.println(getProductOfNumbers(asList(5, 10, 15, 20, 25)));

        System.out.println(getAverageLengthOfNames(getEmployees()));

        System.out.println(getProductOfAllDistinctEvenNumbers(asList(1, 2, 3, 4, 4, 7)));

        System.out.println(getCountOfWordsInInt(getWords()));

        System.out.println(getCountOfWords(getWords()));

        System.out.println(getTotalSumOfTransactionAmounts(getTransactions()));

        System.out.println(getAverageAgeGroupByAge(getPeople()));
    }

    /**
     * Given a list of objects with properties "name" and "age," group the objects by age
     * and find the average age for each group.
     */
    public static Map<Integer, Double> getAverageAgeGroupByAge(List<Person> people){
        return people.stream()
                .collect(groupingBy(Person::age, averagingDouble(Person::age)));
    }

    /**
     * Given a list of transactions, find the total sum of the transaction amounts for each unique customer.
     */
    public static Map<Long, Double> getTotalSumOfTransactionAmounts(List<Transaction> transactions) {

        return transactions.stream()
                .collect(groupingBy(Transaction::getCustomerId, summingDouble(Transaction::getAmount)));
    }

    /**
     * Given a list of strings, count the number of occurrences of each unique word and store the result in a map.
     */
    public static Map<String, Long> getCountOfWords(List<String> strings) {
        return strings.stream()
                .collect(groupingBy(word -> word, counting()));
    }

    /**
     * Given a list of strings, count the number of occurrences of each unique word and store the result in a map of integers.
     */
    public static Map<String, Integer> getCountOfWordsInInt(List<String> strings) {

        return strings.stream()
                .collect(groupingBy(word -> word, Collectors.summingInt(count -> 1)));
    }

    /**
     * Given a list of integers, find the product of all distinct even numbers.
     */

    public static Integer getProductOfAllDistinctEvenNumbers(List<Integer> integers) {

        return integers.stream()
                .distinct()
                .filter(number -> number % 2 == 0)
                .reduce(1, (t, number) -> t * number);
    }

    /**
     * Find the average length of the names of all employees whose salary is above $50,000.
     *
     * @param employees
     * @return
     */
    public static Double getAverageLengthOfNames(List<Employee> employees) {

        return employees.stream()
                .filter(employee -> employee.getSalary() > 50000)
                .mapToDouble(employee -> employee.getName().length())
                .average()
                .orElse(0.0);
    }

    /**
     * Given a list of numbers, find the product of all numbers greater than 10.
     *
     * @return
     */
    public static Integer getProductOfNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number > 10)
                .reduce(1, (t, e) -> t * e);
    }

    private static List<Product> getProducts() {
        return List.of(new Product("Apple", 4),
                new Product("Orange", 10),
                new Product("Cucumber", 1));
    }

    private static List<Employee> getEmployees() {
        return List.of(new Employee("Treasury", 4, "John"),
                new Employee("Engineering", 10, "Sarah"),
                new Employee("Engineering", 500000, "Phoebe"),
                new Employee("HR", 3, "Daniel"),
                new Employee("HR", 100000, "David"));
    }

    /**
     * Given a list of employees, group them by department and calculate the average salary for each department.
     *
     * @return
     */
    public static Map<String, Double> getAverageSalary(List<Employee> employees) {
        return employees.stream()
                .collect(groupingBy(Employee::getDepartment, averagingDouble(Employee::getSalary)));
    }

    /**
     * Given a list of products, find the top 3 products with the highest prices
     */
    public static List<Product> getTopNProducts(List<Product> products, int maxSize) {

        return products.stream()
                .sorted(comparing(Product::getPrice).reversed())
                .limit(maxSize)
                .collect(Collectors.toList());
    }

    /**
     * Given a list of strings, find the number of occurrences of each distinct word and display the word along with its count.
     */
    public static Map<String, Long> getNumberOfOccurrencesOfEachDistinctWordAndCount(List<String> words) {
        return words.stream()
                .collect(groupingBy(Function.identity(), counting()));
    }

    /**
     * Given a list of integers, find the sum of the squares of all even numbers.
     *
     * @return
     */
    public static Integer getSumOfSquares(List<Integer> numbers) {

        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .mapToInt(num -> num * num)
                .sum();
    }

    private static List<Integer> getAListOfIntegersInRange(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .boxed()
                .collect(Collectors.toList());
    }

    /**
     * Given a list of orders, find the total revenue generated by orders that were placed in the last 30 days
     */
    public static Double getTotalRevenueGenerated(List<Order> orders, int days) {

        return orders.stream()
                .filter(order -> order.getDate().isAfter(Instant.parse("2023-05-27T10:15:30.00Z")
                        .minus(ofDays(days))))
                .mapToDouble(Order::getAmount)
                .sum();
    }

    private static List<Order> getOrders() {
        return asList(
                new Order(6, Instant.parse("2023-05-24T10:15:30.00Z")),
                new Order(5, Instant.parse("2023-05-26T10:15:30.00Z")),
                new Order(4.0, Instant.parse("2023-05-20T10:15:30.00Z")),
                new Order(2.3, Instant.parse("2023-05-01T10:15:30.00Z")),
                new Order(1.1, Instant.parse("2023-01-02T10:15:30.00Z"))
        );
    }

    /**
     * Given a list of books, find the book with the highest rating and display its title and author.
     *
     * @return
     */
    public static Book getBookWithHighestRating(List<Book> books) {

        return books.stream()
                .max(comparing(Book::getRating))
                .orElse(null);

    }

    private static List<Book> getBooks() {
        return asList(new Book("book 1", "Author 1", 1),
                new Book("book 2", "Author 2", 1),
                new Book("book 3", "Author 3", 5),
                new Book("book 4", "Author 4", 2));
    }

    public static List<String> getWords() {
        return asList("apple", "banana", "orange", "kiwi", "elephant", "ant", "ant-eater", "elephant");
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
        return asList(
                new Transaction(1234L, getInstance("GBP"), 100.50),
                new Transaction(1234L, getInstance("GBP"), 100),
                new Transaction(1235L, getInstance("EUR"), 75.25),
                new Transaction(3458L, getInstance("USD"), 50.75),
                new Transaction(32333L, getInstance("GBP"), 150.00),
                new Transaction(1237L, getInstance("EUR"), 125.50)
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
                .max(comparing(String::length))
                .orElse("Vowel not found!!");
    }
}
