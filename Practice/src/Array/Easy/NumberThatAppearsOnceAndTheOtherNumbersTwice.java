package Array.Easy;

import java.util.HashMap;

public class NumberThatAppearsOnceAndTheOtherNumbersTwice {
    public static void main(String[] args) {
        int[] arr = {4, 1, 2, 1, 2};
        singleNumberUsingHashMap(arr);
    }

    private static void singleNumberUsingHashMap(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int j : arr) {
            map.put(j, map.getOrDefault(j, 0) + 1);
        }
        for(int key : map.keySet()){
            if(map.get(key) == 1){
                System.out.println("The number that appears only once is: " + key);
                break;
            }
        }
    }

//    Two important properties of XOR are the following:
//
//    XOR of two same numbers is always 0 i.e. a ^ a = 0. ←Property 1.
//    XOR of a number with 0 will result in the number itself i.e. 0 ^ a = a.  ←Property 2
    public static int getSingleElementUsingXOR(int []arr) {

        // XOR all the elements:
        int xorr = 0;
        for (int j : arr) {
            xorr = xorr ^ j;
        }
        return xorr;
    }
}


