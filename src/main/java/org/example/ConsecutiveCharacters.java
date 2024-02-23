package org.example;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
public class ConsecutiveCharacters {
    // General method to process a string based on a predicate and a strategy
    public static List<Map.Entry<String, String>> processString(String input, Predicate<String> predicate, Strategy strategy) {
        List<Map.Entry<String, String>> output = new ArrayList<>();
        output.add(new AbstractMap.SimpleEntry<>(input, ""));

        boolean changed;
        do {
            changed = false;
            int i = 0;
            while (i < output.get(output.size() - 1).getKey().length() - 2) {
                if (predicate.test(output.get(output.size() - 1).getKey().substring(i, i + 3))) {
                    Map.Entry<String, String> result = strategy.apply(output.get(output.size() - 1).getKey(), i);
                    output.add(result);
                    changed = true;
                } else {
                    i++;
                }
            }
        } while (changed);

        return output;
    }

    public interface Strategy {
        Map.Entry<String, String> apply(String input, int index);
    }

    // Strategy for removing consecutive characters
    public static class RemoveConsecutiveStrategy implements Strategy {
        @Override
        public Map.Entry<String, String> apply(String input, int index) {
            String modifiedString = input.substring(0, index) + input.substring(index + 3);
            return new AbstractMap.SimpleEntry<>(modifiedString, "");
        }
    }

    // Strategy for replacing consecutive characters
    public static class ReplaceConsecutiveStrategy implements Strategy {
        @Override
        public Map.Entry<String, String> apply(String input, int index) {
            char replaceChar = (char) (input.charAt(index) - 1);
            char c = input.charAt(index);
            char d = (char) (input.charAt(index) - 1);
            StringBuilder resultBuilder = new StringBuilder(input.length() + 20); // Adjust initial capacity as needed
            String replacementMessage = "";
            // Append characters before the repeated sequence
            resultBuilder.append(input, 0, index);
            if(index!=0){
                // Append the replacement character
                resultBuilder.append(replaceChar);
                // Construct the replacement message
                replacementMessage = String.format(", %c%c%c is replaced by %c", c, c, c, d);
            }
            // Append characters after the repeated sequence
            resultBuilder.append(input, index + 3, input.length());
            return new AbstractMap.SimpleEntry<>(resultBuilder.toString(), replacementMessage);
        }
    }

    // Method to remove consecutive characters
    public static List<Map.Entry<String, String>> removeConsecutiveChars(String input) {
        Predicate<String> consecutivePredicate = s -> s.charAt(0) == s.charAt(1) && s.charAt(0) == s.charAt(2);
        List<Map.Entry<String, String>> result = processString(input, consecutivePredicate, new RemoveConsecutiveStrategy());
        result.remove(0);
        return result;
    }

    // Method to replace consecutive characters
    public static List<Map.Entry<String, String>> replaceConsecutiveChars(String input) {
        Predicate<String> consecutivePredicate = s -> s.charAt(0) == s.charAt(1) && s.charAt(0) == s.charAt(2);
        List<Map.Entry<String, String>> result = processString(input, consecutivePredicate, new ReplaceConsecutiveStrategy());
        result.remove(0); // Remove the initial input entry
        return result;
    }
}
