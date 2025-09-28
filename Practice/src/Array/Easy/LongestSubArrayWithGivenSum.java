package Array.Easy;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithGivenSum {
    public static void main(String[] args) {
        int [] arr = {10, 5, 2, 7, 1, 9};
        int target = 10;
        int maxLength = findLongestSubArrayWithSumBruteforce(arr, target);
        System.out.println("Length of the longest sub-array with sum " + target + " is: " + maxLength);
    }

    private static int findLongestSubArrayWithSumBruteforce(int[] arr, int target) {
        int n = arr.length;
        int maxLength = 0;
        for(int i=0;i<n;i++){
            int sum = 0;
            for(int j=i;j<n;j++){
                sum += arr[j];
                if(sum == target){
                    maxLength = Math.max(maxLength, j-i+1);
                }
            }
        }
        return maxLength;
    }

    public static int getLongestSubArrayUsing2Pointer(int []a, long k) {
        int n = a.length; // size of the array.

        int left = 0, right = 0; // 2 pointers
        long sum = a[0];
        int maxLen = 0;
        while (right < n) {
            // if sum > k, reduce the subArray from left
            // until sum becomes less or equal to k:
            while (left <= right && sum > k) {
                sum -= a[left];
                left++;
            }

            // if sum = k, update the maxLen i.e. answer:
            if (sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }

            // Move forward thw right pointer:
            right++;
            if (right < n) sum += a[right];
        }

        return maxLen;
    }

    public static int getLongestSubArrayUsingHashing(int []a, long k) {
        int n = a.length; // size of the array.

        Map<Long, Integer> preSumMap = new HashMap<>();
        long sum = 0;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            //calculate the prefix sum till index i:
            sum += a[i];

            // if the sum = k, update the maxLen:
            if (sum == k) {
                maxLen = Math.max(maxLen, i + 1);
            }

            // calculate the sum of remaining part i.e. x-k:
            long rem = sum - k;

            //Calculate the length and update maxLen:
            if (preSumMap.containsKey(rem)) {
                int len = i - preSumMap.get(rem);
                maxLen = Math.max(maxLen, len);
            }

            //Finally, update the map checking the conditions:
            if (!preSumMap.containsKey(sum)) {
                preSumMap.put(sum, i);
            }
        }

        return maxLen;
    }
}
