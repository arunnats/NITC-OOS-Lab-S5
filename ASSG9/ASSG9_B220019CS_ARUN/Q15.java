package ASSG9.ASSG9_B220019CS_ARUN;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Customer {
    String name;
    String fruit;

    Customer(String name, String fruit) {
        this.name = name;
        this.fruit = fruit;
    }
}

class Fruit {
    String name;
    double pricePerKg;

    Fruit(String name, double pricePerKg) {
        this.name = name;
        this.pricePerKg = pricePerKg;
    }
}

public class Q15 {
    public static void main(String[] args) {
        List<Customer> customers = Arrays.asList(
            new Customer("Arun", "Apple"),
            new Customer("Aditya", "Banana"),
            new Customer("Hafeez", "Cherry"),
            new Customer("Alen", "Apple")
        );

        List<Fruit> fruits = Arrays.asList(
            new Fruit("Apple", 2.5),
            new Fruit("Banana", 1.2),
            new Fruit("Cherry", 3.0)
        );

        Map<String, Double> fruitPrices = fruits.stream()
                                                .collect(Collectors.toMap(fruit -> fruit.name, fruit -> fruit.pricePerKg));

        Map<String, Long> fruitCounts = customers.stream()
                                                 .collect(Collectors.groupingBy(customer -> customer.fruit, Collectors.counting()));

        Map<String, Double> totalSales = fruitCounts.entrySet().stream()
                                                    .collect(Collectors.toMap(
                                                        Map.Entry::getKey,
                                                        entry -> entry.getValue() * fruitPrices.get(entry.getKey())
                                                    ));

        System.out.println("Total sales per fruit: " + totalSales);
    }
}
