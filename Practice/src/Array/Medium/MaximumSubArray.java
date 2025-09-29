package Array.Medium;

public class MaximumSubArray {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArrayUsingOptimal(nums));
    }

    private static int maxSubArrayUsingOptimal(int[] arr) {
        int n = arr.length;
        int maxi = Integer.MIN_VALUE; // maximum sum
        int sum = 0;

        int start = 0;
        int ansStart = -1, ansEnd = -1;
        for (int i = 0; i < n; i++) {

            if (sum == 0) start = i; // starting index

            sum += arr[i];

            if (sum > maxi) {
                maxi = sum;

                ansStart = start;
                ansEnd = i;
            }

            // If sum < 0: discard the sum calculated
            if (sum < 0) {
                sum = 0;
            }
        }

        //printing the subarray:
        System.out.print("The subarray is: ");
        for (int i = ansStart; i <= ansEnd; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // To consider the sum of the empty subarray
        // uncomment the following check:

        //if (maxi < 0) maxi = 0;

        return maxi;
    }
}
