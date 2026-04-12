package Array;

public class RotateArray {

    /*
    Time Complexity = O(n*k)
    Space Complexity = O(1)
     */
    public static int[] rotateArrayBruteForce(int [] arr, int k){
        int n = arr.length;
        k=k%n;
        for(int i = 0; i < k; i++){
            int last = arr[n-1];
            for (int j = n - 1; j > 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[0] = last;
        }
        return arr;
    }

    /*
    Time Complexity = O(n)
    Space Complexity = O(n)
     */
    public static int[] rotateArrayExtraSpace(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int[] temp = new int[n];

        for (int i = 0; i < n; i++) {
            temp[(i + k) % n] = nums[i];
        }

        return temp;
    }

    /*
    Time Complexity = O(n)
    Space Complexity = O(1)
     */
    public static int[] rotateArrayOptimalReverseArray(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        // Three reversals to achieve rotation
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);

        return nums;
    }

    private static void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int [] arr1 = rotateArrayBruteForce(new int[]{1,2,3,4,5,6,7},3);
        for(int i : arr1){
            System.out.print(i+" ");
        }
        System.out.println();
        int [] arr2 = rotateArrayExtraSpace(new int[]{1,2,3,4,5,6,7},3);
        for(int i : arr2){
            System.out.print(i+" ");
        }
        System.out.println();
        int [] arr3 = rotateArrayOptimalReverseArray(new int[]{1,2,3,4,5,6,7},3);
        for(int i : arr3){
            System.out.print(i+" ");
        }
    }

}
