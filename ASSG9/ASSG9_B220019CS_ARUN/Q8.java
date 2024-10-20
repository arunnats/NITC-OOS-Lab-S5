package ASSG9.ASSG9_B220019CS_ARUN;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Q8 {
    public static void main(String[] args) {
        String[] words = {"Arun", "nats", "Aditya", "kambe", "hafez", "kendrick", "Alen"};
        Predicate<String> startsWithA = word -> word.startsWith("A");
        List<String> wordsStartingWithA = Arrays.stream(words)
                                                .filter(startsWithA)
                                                .collect(Collectors.toList());
        System.out.println(wordsStartingWithA);
    }
}

