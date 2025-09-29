package Array.Medium;

public class MaximumSubArraySum {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArrayUsingBruteForce(nums));
    }

    private static int maxSubArrayUsingBruteForce(int[] arr) {
        int n = arr.length;
        int maxi = Integer.MIN_VALUE; // maximum sum

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                // current subarray = arr[i.....j]

                //add the current element arr[j]
                // to the sum i.e. sum of arr[i...j-1]
                sum += arr[j];

                maxi = Math.max(maxi, sum); // getting the maximum
            }
        }

        return maxi;

    }

    private static int maxSubArrayUsingKadanesAlgorithm(int[] arr) {
        int maxi = Integer.MIN_VALUE; // maximum sum
        int sum = 0; // current sum

        for (int j : arr) {
            sum += j;

            maxi = Math.max(maxi, sum); // getting the maximum

            if (sum < 0) {
                sum = 0; // reset the sum if it becomes negative
            }
        }

        return maxi;
    }
}
