package ASSG9;

import java.util.Arrays;

public class Q5 {
    public static void main(String[] args) {
        String[] words = {"arun", "nats", "aditya", "kambe", "hafez", "kendrick"};
        Arrays.stream(words)
              .map(String::length)
              .forEach(System.out::println);
    }
}

