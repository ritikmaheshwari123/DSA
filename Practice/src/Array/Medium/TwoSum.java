package Array.Medium;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int target = 6;
        int[] result = twoSumUsingTwoPointer(nums, target);
        System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
    }

    private static int[] twoSumBruteForce(int[] nums, int target) {
        int [] result = new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    result[0]=i;
                    result[1]=j;
                }
            }
        }
        return result;
    }

    public static int[] twoSumUsingHashMap(int n, int []arr, int target) {
        int[] ans = new int[2];
        ans[0] = ans[1] = -1;
        HashMap<Integer, Integer> mpp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            int moreNeeded = target - num;
            if (mpp.containsKey(moreNeeded)) {
                ans[0] = mpp.get(moreNeeded);
                ans[1] = i;
                return ans;
            }

            mpp.put(arr[i], i);
        }
        return ans;
    }

//   This approach works only when the array is sorted otherwise indices will not be correct
    public static int[] twoSumUsingTwoPointer(int []arr, int target) {
        int[] ans = new int[2];
        Arrays.sort(arr);
        int left = 0, right = arr.length-1;
        while(left<right){
            int sum = arr[left]+arr[right];
            if(sum==target){
                ans[0] = left;
                ans[1] = right;
                return ans;
            }
            else if(sum<target){
                left++;
            }
            else{
                right--;
            }
        }
        return ans;
    }
}
