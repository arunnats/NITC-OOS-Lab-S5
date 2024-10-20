package ASSG9.ASSG9_B220019CS_ARUN;

import java.util.Arrays;

public class Q6 {
    public static void main(String[] args) {
        String[] words = {"Arun", "nats", "Aditya", "kambe", "hafez", "kendrick"};
        Arrays.stream(words)
              .filter(word -> word.startsWith("A"))
              .forEach(System.out::println);
    }
}

