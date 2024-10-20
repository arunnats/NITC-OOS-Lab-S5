package ASSG9;

import java.util.Arrays;

public class Q9 {
    public static void main(String[] args) {
        String[] words = {"Arun", "nats", "Aditya", "kambe", "hafez", "kendrick", "Alen"};
        int totalCharacters = Arrays.stream(words)
                                    .mapToInt(String::length)
                                    .sum();
        System.out.println("Total characters: " + totalCharacters);
    }
}

