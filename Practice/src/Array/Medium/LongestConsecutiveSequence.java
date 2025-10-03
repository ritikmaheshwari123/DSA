package Array.Medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] arr = {1,0,1,2};
        System.out.println(longestConsecutive(arr));
    }

    private static int longestConsecutive(int[] arr) {
        if(arr.length==0) return 0;
        int count = 0;
        int currentCount = 0;
        Arrays.sort(arr);
        for(int i=0;i< arr.length-1;i++){
            if(arr[i+1]-arr[i]==1){
                currentCount++;
                count = Math.max(count, currentCount);
            } else if(arr[i+1]-arr[i]!=1 && arr[i+1]-arr[i]!=0){
                currentCount = 0;
            }
        }
        return count+1;
    }

    private static int longestConsecutiveOptimal(int[] a) {
        int n = a.length;
        if (n == 0)
            return 0;

        int longest = 1;
        Set<Integer> set = new HashSet<>();

        // put all the array elements into set
        for (int j : a) {
            set.add(j);
        }

        // Find the longest sequence
        for (int it : set) {
            // if 'it' is a starting number
            if (!set.contains(it - 1)) {
                // find consecutive numbers
                int cnt = 1;
                int x = it;
                while (set.contains(x + 1)) {
                    x = x + 1;
                    cnt = cnt + 1;
                }
                longest = Math.max(longest, cnt);
            }
        }
        return longest;
    }
}
