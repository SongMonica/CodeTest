package org.example;

import java.util.ArrayList;
import java.util.List;

public class ConsecutiveCharacters {

    public static List<String> removeConsecutiveChars(String input) {
        List<String> output = new ArrayList<>();
        output.add(input);
        boolean changed;
        do {
            changed = false;
            int i = 0;
            while (i < output.get(output.size() - 1).length() - 2) {
                if (output.get(output.size() - 1).charAt(i) == output.get(output.size() - 1).charAt(i + 1) &&
                        output.get(output.size() - 1).charAt(i) == output.get(output.size() - 1).charAt(i + 2)) {
                    String temp = output.get(output.size() - 1).substring(0, i) +
                            output.get(output.size() - 1).substring(i + 3);
                    output.add(temp);
                    changed = true;
                } else {
                    i++;
                }
            }
        } while (changed);

        return output;

    }
    public static List<String> replaceConsecutiveChars(String str) {
        StringBuilder sb = new StringBuilder(str);
        List<String> resultList = new ArrayList<>();
        boolean changed;
        do {
            changed = false;
            for (int i = 0; i < sb.length() - 2; i++) {
                if (sb.charAt(i) == sb.charAt(i + 1) && sb.charAt(i) == sb.charAt(i + 2)) {
                    char replaceChar;
                    if (sb.charAt(i) == 'a') {
                        sb.delete(i, i + 3);
                    } else {
                        replaceChar = (char) (sb.charAt(i) - 1);
                        sb.delete(i, i + 3);
                        sb.insert(i, replaceChar);
                        resultList.add(sb.toString() + "," + new String(new char[]{sb.charAt(i), sb.charAt(i), sb.charAt(i)}) + " is replaced by " + replaceChar);
                        //System.out.printf("-> %s, %s is replaced by %s\n", sb.toString(), new String(new char[]{sb.charAt(i), sb.charAt(i), sb.charAt(i)}), replaceChar);
                    }
                    changed = true;
                    break;
                }
            }
        } while (changed);
        resultList.add(sb.toString());
        //System.out.println("-> " + sb.toString());
        return resultList;
    }



}
