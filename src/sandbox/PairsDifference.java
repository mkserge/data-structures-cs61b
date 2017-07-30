package sandbox;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

/**
 * Given an array of distinct integer values, count the number of pairs of integers that have difference {@code k}.
 *
 * For example, given the array {@code {1, 7, 5, 9, 2, 12, 3}} and the difference {@code k = 2}, there are four pairs
 * with difference 2: {@code (1, 3)m (3, 5), (5, 7) and (7, 9)}
 *
 * @author  Sergey Mkrtchyan
 */

public class PairsDifference {

    private static int numberOfPairsWithDifferenceBruteForce(int[] array, int difference) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[i] - array[j] == difference || array[j] - array[i] == difference) {
                    count++;
                }
            }
        }
        return count;
    }

    private static int numberOfPairsWithDifferenceSorting(int[] array, int difference) {
        int count = 0;
        // First, we sort the array in order to do a binary search later.
        Arrays.sort(array);
        // If we are looking at element x, then the other pair that we are looking
        // at is either x + difference, or x - difference. Look it up in the array
        // using binary search.
        for (int i = 0; i < array.length; i++) {
            if (Arrays.binarySearch(array, i, array.length, array[i] + difference) >= 0 ||
                    Arrays.binarySearch(array, i, array.length, array[i] - difference) >= 0) {
                count++;
            }
        }
        return count;
    }

    private static int numberOfPairsWithHashTables(int[] array, int difference) {
        int count = 0;
        Set<Integer> elements = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            elements.add(array[i]);
        }
        for (int i = 0; i < array.length; i++) {
            if (elements.contains(array[i] - difference)) {
                count++;
            }
            if (elements.contains(array[i] + difference)) {
                count++;
            }
        }
        return count / 2;
    }



    public static void main(String[] args) {

        int[] myArray = {1, 7, 5, 9, 2, 12, 3};
        int difference = 2;

        System.out.println("There are " + numberOfPairsWithDifferenceBruteForce(myArray, difference) + " pairs with difference " + difference);
        System.out.println("There are " + numberOfPairsWithDifferenceSorting(myArray, difference) + " pairs with difference " + difference);
        System.out.println("There are " + numberOfPairsWithHashTables(myArray, difference) + " pairs with difference " + difference);
    }
}
