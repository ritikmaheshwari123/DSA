package Array.Easy;

import java.util.HashMap;
import java.util.Map;

public class MissingNumberInAnArray {
    public static void main(String[] args) {
        int [] numbs = {9,6,4,2,3,5,7,0,1};
        missingNumber(numbs);
    }

    private static void missingNumber(int[] numbs) {
        int n = numbs.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(i,0);
        }
        for (int num : numbs) {
            if (map.containsKey(num)) {
                map.put(num, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue()==0){
                System.out.println(entry.getKey());
            }
        }
    }

    public static int missingNumberUsingArray(int []a, int N) {

        int[] hash = new int[N + 1]; //hash array

        // storing the frequencies:
        for (int i = 0; i <= N; i++)
            hash[a[i]]++;

        //checking the frequencies for numbers 1 to N:
        for (int i = 0; i <= N+1; i++) {
            if (hash[i] == 0) {
                return i;
            }
        }

        // The following line will never execute.
        // It is just to avoid warnings.
        return -1;
    }

    public static int missingNumberUsingSummation(int []a, int N) {

        //Summation of first N numbers:
        int sum = (N * (N + 1)) / 2;

        //Summation of all array elements:
        int s2 = 0;
        for (int i = 0; i < N; i++) {
            s2 += a[i];
        }

        return sum - s2;
    }
}
