package Array;

import java.util.Arrays;
import java.util.HashMap;

/*
Given an array arr of size n, return the majority element.
The majority element is the element that appears more than ⌊n / 2⌋ times.
You may assume that the majority element always exists in the array.
 */
public class MajorityElement {

    /*
    Time Complexity = O(n^2)
    Space Complexity = O(1)
     */
    public static int bruteForce(int[] arr) {
        for (int k : arr) {
            int count = 0;
            for (int i : arr) {
                if (k == i) {
                    count++;
                }
            }
            if (count > arr.length / 2) {
                return k;
            }
        }
        return -1;
    }

    /*
    Time Complexity = O(n)
    Space Complexity = O(n)
     */
    public static int usingHashMap(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i:arr){
            map.put(i,map.getOrDefault(i,0)+1);
            if(map.get(i)>arr.length/2){
                return i;
            }
        }
        return -1;
    }

    /*
    Time Complexity = O(nlogn) -> due to sorting
    Space Complexity = O(1) -> when using in-place sorting
     */
    public static int usingSorting(int[] arr) {
        Arrays.sort(arr);
        return arr[arr.length/2];
    }

    /*
    Time Complexity = O(n) -> due to sorting
    Space Complexity = O(1) -> when using in-place sorting
     */
    public static int boyerMooreVotingAlgorithm(int[] arr) {
        int candidate = 0;
        int count = 0;
        for(int i:arr){
            if(count == 0){
                candidate = i;
            }
            count = count + (candidate==i?1:-1);
        }
        return candidate;
    }

    public static void main(String[] args) {
        int [] arr = {2,2,1,1,1,2,2};
        System.out.println(bruteForce(arr));
        System.out.println(usingHashMap(arr));
        System.out.println(usingSorting(arr));
        System.out.println(boyerMooreVotingAlgorithm(arr));
    }
}
