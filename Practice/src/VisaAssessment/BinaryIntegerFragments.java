package VisaAssessment;

import java.util.HashMap;
import java.util.Map;

/*
This binary integer encapsulates fragments of a secret group.
Each fragment is represented as a positive integer in an array called fragments.
Intelligence suggests that the complete access code is a specific number called access code.
Your mission is to determine how many different ways the fragments can be paired
to form the complete access code.
The agency cryptography rules are:
1. When fragments are combined they are simply placed next to each other(not added mathematically)
2. Each specific pair of fragments(by position in array) counts as a unique combination
3. The fragments can be used in any order, but each fragment position can only be used once in a combination.
Ex if fragment "12" is followed by fragment "34" The result is "1234".
 */

public class BinaryIntegerFragments {

    // Function to count valid fragment pairs
    public static int solution(int[] fragments, int accessCode) {

        String target = String.valueOf(accessCode);

        // Store frequency of each fragment (as string)
        Map<String, Integer> freq = new HashMap<>();
        for (int f : fragments) {
            String s = String.valueOf(f);
            freq.put(s, freq.getOrDefault(s, 0) + 1);
        }

        int count = 0;

        // Try each fragment as the first part
        for (int f : fragments) {
            String first = String.valueOf(f);

            // Must match prefix of access code
            if (!target.startsWith(first)) {
                continue;
            }

            // Remaining suffix
            String remaining = target.substring(first.length());

            // Check if remaining fragment exists
            if (freq.containsKey(remaining)) {
                count += freq.get(remaining);

                // Avoid using the same array position twice
                if (remaining.equals(first)) {
                    count--;
                }
            }
        }

        return count;
    }

    // Test the solution
    public static void main(String[] args) {

        int[] fragments1 = {12, 34, 1, 234};
        int accessCode1 = 1234;
        System.out.println(solution(fragments1, accessCode1)); // Output: 2

        int[] fragments2 = {1, 1, 23};
        int accessCode2 = 123;
        System.out.println(solution(fragments2, accessCode2)); // Output: 2

        int[] fragments3 = {12, 12};
        int accessCode3 = 1212;
        System.out.println(solution(fragments3, accessCode3)); // Output: 2
    }
}
