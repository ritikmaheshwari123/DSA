package Array;

/*
Given an integer array nums sorted in non-decreasing order,
remove the duplicates in-place such that each unique element appears only once.
The relative order of the elements should be kept the same.
Then return the number of unique elements in nums.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class RemoveDuplicatesFromSortedArray {
    /*
    Time Complexity = O(nlogn)
    Space Complexity = O(n)
     */
    public static int removeDuplicatesUsingHashSet(int[] arr) {
        HashSet<Integer> seen = new HashSet<>();
        for(int i:arr){
            seen.add(i);
        }
        List<Integer> unique =  new ArrayList<>(seen);
        Collections.sort(unique);

        for(int i=0;i<unique.size();i++){
            arr[i]=unique.get(i);
        }
        return unique.size();
    }

    /*
    Time Complexity = O(n)
    Space Complexity = O(1)
     */
    public static int removeDuplicatesUsingTwoPointers(int [] arr){
        int pos = 1;
        for(int i=1;i<arr.length;i++){
            if(arr[i]!=arr[pos-1]){
                arr[pos]=arr[i];
                pos++;
            }
        }
        return pos;
    }
    public static void main(String[] args) {
        int[] arr = {0,0,0,1,1,2,2,3,3,3,3,3,4};
        int[] arr1 = {0,0,0,1,1,2,2,3,3,3,3,3,4};
        System.out.println(removeDuplicatesUsingHashSet(arr));
        System.out.println(removeDuplicatesUsingTwoPointers(arr1));
    }
}
