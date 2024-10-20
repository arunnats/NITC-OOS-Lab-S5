package ASSG9;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Q7 {
    public static void main(String[] args) {
        String[] words = {"Arun", "nats", "Aditya", "kambe", "hafez", "kendrick"};
        List<String> wordsStartingWithA = Arrays.stream(words)
                                                .filter(word -> word.startsWith("A"))
                                                .collect(Collectors.toList());
        System.out.println(wordsStartingWithA);
    }
}

