package org.example;

import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Stage 1\nPlease enter an input string: ");
        //String input2 = "aabcccbbad ";
        String inputRemove = scanner.nextLine();
        // Stage 1
        System.out.println("Stage 1");
        List<String> listRemove = ConsecutiveCharacters.removeConsecutiveChars(inputRemove);
        listRemove.stream().forEach(s -> System.out.println("-> " + s));
        // Stage 2
        //String input2 = "abcccbad ";
        System.out.print("Stage 2\nPlease enter an input string: ");
        String inputReplace = scanner.nextLine();
        List<String>listReplace=ConsecutiveCharacters.replaceConsecutiveChars(inputReplace);
        listReplace.stream().forEach(s -> System.out.println("-> " + s));
    }
}
