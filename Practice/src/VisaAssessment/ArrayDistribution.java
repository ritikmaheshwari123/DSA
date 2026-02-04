package VisaAssessment;

/*
Given an array of integers numbers
distribute all of its integers between two arrays,
first and second such that:
1. First number goes to first array
2. Second number goes to second array
3. Each following number, goes to array with the higher number of elements
that are strictly greater than the number.
In case of a tie, number goes to array with lower length.
If still tie number goes to first array.
 */

import java.util.*;

public class ArrayDistribution {

    public static int[] solution(int[] numbers) {
        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();

        // First two rules
        first.add(numbers[0]);
        if (numbers.length > 1) {
            second.add(numbers[1]);
        }

        // Process remaining numbers
        for (int i = 2; i < numbers.length; i++) {
            int current = numbers[i];

            int greaterInFirst = countGreater(first, current);
            int greaterInSecond = countGreater(second, current);

            if (greaterInFirst > greaterInSecond) {
                first.add(current);
            } else if (greaterInSecond > greaterInFirst) {
                second.add(current);
            } else {
                // Tie: smaller length
                if (first.size() < second.size()) {
                    first.add(current);
                } else if (second.size() < first.size()) {
                    second.add(current);
                } else {
                    // Still tie: first array
                    first.add(current);
                }
            }
        }

        // Merge first + second
        int[] result = new int[first.size() + second.size()];
        int index = 0;

        for (int num : first) {
            result[index++] = num;
        }
        for (int num : second) {
            result[index++] = num;
        }

        return result;
    }

    private static int countGreater(List<Integer> list, int value) {
        int count = 0;
        for (int num : list) {
            if (num > value) {
                count++;
            }
        }
        return count;
    }

    // ---- MAIN METHOD FOR TESTING ----
    public static void main(String[] args) {
        int[] numbers = {5, 3, 7, 2, 6};

        int[] result = solution(numbers);

        System.out.println(Arrays.toString(result));
    }
}
