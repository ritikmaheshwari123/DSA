package Array.Easy;

public class LargestElementInAnArray {
    public static void main(String[] args) {
        int[] arr ={3,3,0,99,-40};
        int max = arr[0];
        for (int j : arr) {
            if (max < j) {
                max = j;
            }
        }
        System.out.println("Largest element in array is: "+max);
    }
}
