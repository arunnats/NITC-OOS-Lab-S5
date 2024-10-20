package ASSG9;

import java.util.Arrays;

public class Q1 {
    public static void main(String[] args) {
        String[] words = {"arun", "nats", "aditya", "kambe", "hafez", "kendrick"};
        Arrays.asList(words).forEach(word -> System.out.println(word));
    }
}