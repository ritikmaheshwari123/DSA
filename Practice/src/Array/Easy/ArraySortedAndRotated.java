package Array.Easy;

public class ArraySortedAndRotated {
    public static void main(String[] args) {
        int [] nums ={3,4,5,1,2};
        boolean result = check(nums);
        System.out.println("Array is sorted/rotated: "+ result);
    }
    public static boolean check(int[] nums) {
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            // Compare current with next (using modulo for circular check)
            if (nums[i] > nums[(i + 1) % n]) {
                count++;
            }
            // More than one drop means not a rotated sorted array
            if (count > 1) {
                return false;
            }
        }

        return true;
    }
}
