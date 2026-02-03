package HackerRankAssessment;

/*
Given a list of integers which contains binary values only.
Implement a method findMaxSubarray(List<Integer> nums)
to return integer length of longest contiguous subarray
in which number 0 and 1 is equal.
 */

import java.util.*;

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

    /*
    Now, you may flip at most one element in list.
    Find length of longest subarray where 0 are equal to 1
    after 1 flip.
     */

    public static int findMaxSubarrayWithOneFlip(List<Integer> nums) {
        Map<Integer, Integer> firstIndexMap = new HashMap<>();
        int sum = 0;
        int maxLen = 0;

        // Base case
        firstIndexMap.put(0, -1);

        for (int i = 0; i < nums.size(); i++) {
            sum += (nums.get(i) == 0) ? -1 : 1;

            // Case 1: no flip (sum == 0)
            if (firstIndexMap.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - firstIndexMap.get(sum));
            }

            // Case 2: flip one 1 -> 0 (sum - 2)
            if (firstIndexMap.containsKey(sum - 2)) {
                maxLen = Math.max(maxLen, i - firstIndexMap.get(sum - 2));
            }

            // Case 3: flip one 0 -> 1 (sum + 2)
            if (firstIndexMap.containsKey(sum + 2)) {
                maxLen = Math.max(maxLen, i - firstIndexMap.get(sum + 2));
            }

            // Store first occurrence only
            firstIndexMap.putIfAbsent(sum, i);
        }

        return maxLen;
    }

    /*
    For the final task,
    find length of longest subarray with an equal number of 0s and 1s,
    such that every prefix of their subarray has the count of 1s greater than or equal to count of 0s.
     */

    public static int findMaxSubarrayWithCondition(List<Integer> nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1); // base index

        int maxLen = 0;

        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) == 1) {
                stack.push(i);
            } else { // nums.get(i) == 0
                stack.pop();

                if (stack.isEmpty()) {
                    // prefix condition violated, reset base
                    stack.push(i);
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        return maxLen;
    }

    // Example
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(0, 1, 0, 1, 1, 0, 0);
        System.out.println(findMaxSubarray(nums)); // Output: 6

        List<Integer> nums1 = Arrays.asList(0, 1, 1, 1, 0);
        System.out.println(findMaxSubarrayWithOneFlip(nums1)); // Output: 4

        List<Integer> nums2 = Arrays.asList(0,1,1,0);
        System.out.println(findMaxSubarrayWithCondition(nums2));
    }
}
