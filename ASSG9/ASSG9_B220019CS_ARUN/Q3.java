package ASSG9.ASSG9_B220019CS_ARUN;

import java.util.Arrays;

public class Q3 {
    public static void main(String[] args) {
        String[] words = {"arun", "nats", "aditya", "kambe", "hafez", "kendrick"};
        String[] upperCaseWords = Arrays.stream(words)
                                        .map(word -> word.toUpperCase())
                                        .toArray(String[]::new);
        Arrays.stream(upperCaseWords).forEach(System.out::println);
    }
}
