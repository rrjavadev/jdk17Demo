package com.example.demo.practice.streams;

import com.example.demo.model.Employee;
import com.example.demo.model.LineItem;
import com.example.demo.model.Order;
import com.example.demo.model.Transaction;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class StreamProblems1Test {

    @Test
    void longestWordThatStartsWithAVowel() {
        //Given
        List<String> words = List.of("apple", "banana", "orange", "umbrella","coffee", "elephant");

        //When
        String result = StreamProblems1.longestWordThatStartsWithAVowel(words);

        //Then
        assertThat(result).isEqualTo("umbrella");
    }

    @Test
    void averageSalaryByDepartment() {
        //Given
        List<Employee> employees = List.of(
                new Employee("Alice", "Engineering", 70000),
                new Employee("Bob", "Engineering", 80000),
                new Employee("Charlie", "HR", 60000),
                new Employee("David", "HR", 50000)
        );

        //When
        Map<String, Double> averageSalary = StreamProblems1.averageSalaryByDepartment(employees);

        //Then
        assertThat(averageSalary).isEqualTo(Map.of("Engineering", 75000.0, "HR", 55000.0));
    }

    @Test
    void itemsByCustomerName(){
        //Given
        Map<String, Set<LineItem>> itemsByCustomerName = StreamProblems1.itemsByCustomerName(List.of(new Order("Rosh",
                Set.of(new LineItem("apple", 1, 1.5)))));

        //Then
        Assertions.assertThat(itemsByCustomerName)
                .isEqualTo(Map.of("Rosh", Set.of(new LineItem("apple", 1, 1.5))));
    }

    @Test
    void productOfAllNumbersGreaterThan10(){
        //Given
        List<Integer> numbers = List.of(5, 12, 15, 8, 20, 3);

        //When
        int product = StreamProblems1.productOfAllNumbersGreaterThan10(numbers);

        //Then
        assertThat(product).isEqualTo(3600); // 12 * 15 * 20 = 3600
    }

    @Test
    void topThreeProductsWithHighestPrice() {
        // Given
        List<LineItem> lineItems = List.of(
                new LineItem("apple", 2, 1.5),
                new LineItem("banana", 3, 0.5),
                new LineItem("orange", 1, 2.0),
                new LineItem("kiwi", 4, 1.0)
        );

        // When
        List<LineItem> topProducts = StreamProblems1.topThreeProductsWithHighestPrice(lineItems);

        // Then
        assertThat(topProducts).hasSize(3);
        assertThat(topProducts.get(0).pricePerUnit()).isEqualTo(2.0); // orange
        assertThat(topProducts.get(1).pricePerUnit()).isEqualTo(1.5); // apple
        assertThat(topProducts.get(2).pricePerUnit()).isEqualTo(1.0); // kiwi
    }

    /**
     Given a list of strings, find the number of occurrences of each distinct word and display the word along with its count.
     */
    @Test
    void countOfAllDistinctWords() {
        // Given
        List<String> words = List.of("apple", "banana", "apple", "orange", "banana", "apple");

        // When
        Map<String, Long> wordCount = StreamProblems1.countOfAllDistinctWords(words);

        // Then
        assertThat(wordCount).isEqualTo(Map.of("apple", 3L, "banana", 2L, "orange", 1L));
    }

    @Test
    void totalSumOfTransactionsOfADistinctCurrency(){
        // Given
        List<Transaction> transactions = List.of(
                new Transaction("USD", 1.5),
                new Transaction("USD", 0.5),
                new Transaction("EUR", 2.0),
                new Transaction("USD", 3.0),
                new Transaction("EUR", 1.0)
        );


        // When
        Map<String, Double> totalSum = StreamProblems1.totalSumOfTransactionsOfADistinctCurrency(transactions);

        // Then
        assertThat(totalSum).isEqualTo(Map.of("EUR", 3.0, "USD", 5.0)); // 1.5 + (2 * 0.5) + (3 * 2.0)
    }

}