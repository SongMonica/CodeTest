package org.example;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static org.example.ConsecutiveCharacters.removeConsecutiveChars;
import static org.example.ConsecutiveCharacters.replaceConsecutiveChars;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Stage 1\nPlease enter an input string: ");
        //String input2 = "aabcccbbad ";
        String inputRemove = scanner.nextLine();
        // Stage 1
        System.out.println("Stage 1");
        List<Map.Entry<String, String>> listRemove = removeConsecutiveChars(inputRemove);
        for (Map.Entry<String, String> entry : listRemove) {
            System.out.println("-> " + entry.getKey() + entry.getValue());
        }
        // Stage 2
        //String input2 = "abcccbad ";
        System.out.print("Stage 2\nPlease enter an input string: ");
        String inputReplace = scanner.nextLine();
        List<Map.Entry<String, String>> listReplace = replaceConsecutiveChars(inputReplace);
        for (Map.Entry<String, String> entry : listReplace) {
            System.out.println("-> " + entry.getKey() + entry.getValue());
        }
    }
}
