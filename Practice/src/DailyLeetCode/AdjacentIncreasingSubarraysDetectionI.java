package DailyLeetCode;

/*
Given an array nums of n integers and an integer k,
determine whether there exist two adjacent subarrays of length k
such that both subarrays are strictly increasing. Specifically,
check if there are two subarrays starting at indices a and b (a < b), where:

Both subarrays nums[a..a + k - 1] and nums[b..b + k - 1] are strictly increasing.
The subarrays must be adjacent, meaning b = a + k.
Return true if it is possible to find two such subarrays, and false otherwise.


Example 1:

Input: nums = [2,5,7,8,9,2,3,4,3,1], k = 3

Output: true

Explanation:

The subarray starting at index 2 is [7, 8, 9], which is strictly increasing.
The subarray starting at index 5 is [2, 3, 4], which is also strictly increasing.
These two subarrays are adjacent, so the result is true.
Example 2:

Input: nums = [1,2,3,4,4,4,4,5,6,7], k = 5

Output: false
 */

import java.util.List;

public class AdjacentIncreasingSubarraysDetectionI {
    public static void main(String[] args) {
        List<Integer> nums = List.of(2,5,7,8,9,2,3,4,3,1);
        int k = 3;
        System.out.println(hasIncreasingSubarraysOptimal(nums, k));
    }

    private static boolean areThereTwoAdjacentIncreasingSubarrays(List<Integer> nums, int k) {
        boolean result = false;
        for(int i = 0; i <= nums.size() - 2 * k; i++) {
            boolean firstSubarrayIncreasing = true;
            boolean secondSubarrayIncreasing = true;

            // Check first subarray
            for(int j = i; j < i + k - 1; j++) {
                if(nums.get(j) >= nums.get(j+1)) {
                    firstSubarrayIncreasing = false;
                    break;
                }
            }

            // Check second subarray
            for(int j = i + k; j < i + 2 * k - 1; j++) {
                if(nums.get(j) >= nums.get(j+1)) {
                    secondSubarrayIncreasing = false;
                    break;
                }
            }

            if(firstSubarrayIncreasing && secondSubarrayIncreasing) {
                result = true;
                break;
            }
        }
        return result;
    }

    public static boolean hasIncreasingSubarraysOptimal(List<Integer> nums, int k) {
        int prev = 0, increaseCount = 1;

        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i-1) < nums.get(i)) increaseCount++;
            else {
                prev = increaseCount;
                increaseCount = 1;
            }

            if (increaseCount / 2 >= k || prev / 2 >= k || Math.min(prev, increaseCount) >= k)
                return true;
        }
        return false;
    }
}
