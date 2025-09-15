package Array.Easy;

public class SecondLargestElementInAnArray {
    public static void main(String[] args) {
        int[] arr ={3,3,0,99,-40,8};
        int large = Integer.MIN_VALUE;
        int second_large = Integer.MIN_VALUE;
        for (int j : arr) {
            if (j > large) {
                second_large = large;
                large = j;
            } else if (j > second_large && j != large) {
                second_large = j;
            }
        }
        System.out.println("Second largest element in array is: "+second_large);
    }
}
