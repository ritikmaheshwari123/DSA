package Array.Medium;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        int k = 2;
        System.out.println(subarraySum(nums, k));
    }

    private static int subarraySum(int[] arr, int k) {
        int n = arr.length;
        Map<Integer, Integer> prefixCount = new HashMap<>();
        int prefixSum = 0;
        int count = 0;

        // Initialize with prefixSum = 0 having one count.
        prefixCount.put(0, 1);

        for (int i = 0; i < n; i++) {
            prefixSum += arr[i];

            // Check if (prefixSum - k) has appeared before
            count += prefixCount.getOrDefault(prefixSum - k, 0);

            // Store/Update prefixSum count
            prefixCount.put(prefixSum, prefixCount.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}
