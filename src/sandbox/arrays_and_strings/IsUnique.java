package sandbox.arrays_and_strings;

import java.util.Arrays;

/**
 * Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot sue additional data structures.
 */

public class IsUnique {

    private static boolean hasUniqueCharsBruteForce(String str) {
        // Brute force approach. Complexity n ^ 2.
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean hasUniqueCharsSorted(String str) {
        // Sort the array first. Complexity n log(n).
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                return false;
            }
        }
        return true;
    }

    private static boolean hasUniqueBest(String str) {
        // Complexity n.
        boolean[] char_val = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int character = str.charAt(i);
            if (char_val[character]) {
                return false;
            } else {
                char_val[character] = true;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String myString = "This is a really long string";
        String myOtherString = "No Duplicates";

        System.out.println("'" + myString + "' contains unique characters: " + hasUniqueBest(myString));
        System.out.println("'" + myOtherString + "' contains unique characters: " + hasUniqueBest(myOtherString));
    }

}
