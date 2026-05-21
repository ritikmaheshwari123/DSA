package DynamicProgramming;

public class PartitionSubsetSum {

    /**
     * Checks if the array can be partitioned into two subsets with equal sums.
     */
    public static boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // If total sum is odd, it's impossible to divide into two equal integer sums
        if (totalSum % 2 != 0) {
            return false;
        }

        int target = totalSum / 2;
        int n = nums.length;

        // dp[j] will be true if a sum of 'j' can be formed from elements
        boolean[] dp = new boolean[target + 1];
        dp[0] = true; // Base case: A sum of 0 is always possible (empty subset)

        for (int num : nums) {
            // Update the DP table backwards to ensure each number is used only once
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 5, 11, 5};
        int[] arr2 = {1, 2, 3, 5};

        System.out.println("Can partition {1, 5, 11, 5}? " + canPartition(arr1)); // Expected: true
        System.out.println("Can partition {1, 2, 3, 5}? " + canPartition(arr2));  // Expected: false
    }
}
