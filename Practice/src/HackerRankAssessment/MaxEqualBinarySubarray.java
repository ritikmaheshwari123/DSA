package HackerRankAssessment;

/*
Given a list of integers which contains binary values only.
Implement a method findMaxSubarray(List<Integer> nums)
to return integer length of longest contiguous subarray
in which number 0 and 1 is equal in java
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxEqualBinarySubarray {
    public static int findMaxSubarray(List<Integer> nums) {
        Map<Integer, Integer> firstIndexMap = new HashMap<>();
        int sum = 0;
        int maxLen = 0;

        // Base case: sum 0 at index -1
        firstIndexMap.put(0, -1);

        for (int i = 0; i < nums.size(); i++) {
            sum += (nums.get(i) == 0) ? -1 : 1;

            if (firstIndexMap.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - firstIndexMap.get(sum));
            } else {
                firstIndexMap.put(sum, i);
            }
        }

        return maxLen;
    }

    // Example
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(0, 1, 0, 1, 1, 0, 0);
        System.out.println(findMaxSubarray(nums)); // Output: 6
    }
}
