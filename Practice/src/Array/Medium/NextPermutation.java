package Array.Medium;

public class NextPermutation {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        nextPermutation(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

//    We need to find the first decreasing element from the right of the list.
//    Then, we need to find the smallest element from the right side that is greater than the first decreasing element.
//    We swap these two elements
//    Finally we reverse the sublist from the first decreasing element to the end of the list.

    private static void nextPermutation(int[] nums) {
        int i = nums.length - 1;
        while (i > 0 && nums[i-1] >= nums[i]) {
            i--;
        }
        if (i == 0) {
            reverse(nums, 0, nums.length-1);
            return;
        }
        int j = nums.length - 1;
        while (j >= i && nums[j] <= nums[i-1]) {
            j--;
        }
        swap(nums, i-1, j);
        reverse(nums, i, nums.length-1);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
