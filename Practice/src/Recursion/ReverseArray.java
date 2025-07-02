package Recursion;

public class ReverseArray {

    // Recursive function to reverse the array
    public static void reverseArray(int[] arr, int start, int end) {
        if (start >= end) {
            return; // Base case: when start >= end, stop recursion
        }

        // Swap elements at start and end
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;

        // Recursive call
        reverseArray(arr, start + 1, end - 1);
    }

    // Helper method to print the array
    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    // Main method to test
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        System.out.println("Original array:");
        printArray(arr);

        reverseArray(arr, 0, arr.length - 1);

        System.out.println("Reversed array:");
        printArray(arr);
    }
}
