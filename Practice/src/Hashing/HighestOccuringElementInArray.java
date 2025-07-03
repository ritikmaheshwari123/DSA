package Hashing;

import java.util.HashMap;
import java.util.Map;

public class HighestOccuringElementInArray {
    public int maxFrequency1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        int maxFreq=0;
        int maxEle=0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int count = entry.getValue();
            int element = entry.getKey();

            if (count > maxFreq) {
                maxEle = element;
                maxFreq = count;
            } else if(count==maxFreq){
                if(maxEle>element){
                    maxEle = element;
                }
            }
        }
        return maxEle;
    }

    public static void main(String[] args) {
        HighestOccuringElementInArray sol = new HighestOccuringElementInArray();
        System.out.println(sol.maxFrequency1(new int[]{1, 2, 2, 3, 3, 3})); // 3
        System.out.println(sol.maxFrequency1(new int[]{4, 4, 5, 5, 6})); // 2
    }
}

