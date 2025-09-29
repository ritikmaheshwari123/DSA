package Array.Medium;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {3, 2, 3};
        System.out.println("Majority element is: "+ majorityElementUsingHashMap(nums));
    }

    private static int majorityElementUsingHashMap(int[] v) {
        //size of the given array:
        int n = v.length;

        //declaring a map:
        HashMap<Integer, Integer> mpp = new HashMap<>();

        //storing the elements with its occurnce:
        for (int j : v) {
            int value = mpp.getOrDefault(j, 0);
            mpp.put(j, value + 1);
        }

        //searching for the majority element:
        for (Map.Entry<Integer, Integer> it : mpp.entrySet()) {
            if (it.getValue() > (n / 2)) {
                return it.getKey();
            }
        }

        return -1;
    }

    private static int majorityElement(int[] v) {
        //size of the given array:
        int n = v.length;

        for (int k : v) {
            //selected element is v[i]
            int cnt = 0;
            for (int i : v) {
                // counting the frequency of v[i]
                if (i == k) {
                    cnt++;
                }
            }

            // check if frquency is greater than n/2:
            if (cnt > (n / 2))
                return k;
        }

        return -1;
    }

    public static int majorityElementBoyerMoore(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }


}
