package Array.Easy;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 10};
        int target = 6;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                System.out.println("Element found at index: " + i);
                break;
            }
        }
        System.out.println("Element not found in the array.");
    }
}
