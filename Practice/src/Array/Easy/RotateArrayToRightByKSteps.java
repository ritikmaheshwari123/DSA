package Array.Easy;

public class RotateArrayToRightByKSteps {
    public static void main(String[] args) {
        int[] sortArr = {1,2,3,4,5,6,7,8,9,10};
        int k=3;
        int n = sortArr.length;
        k = k % n;
        Reverse(sortArr, 0, n - 1);
        Reverse(sortArr, 0, k - 1);
        Reverse(sortArr, k, n - 1);

        for (int j : sortArr) {
            System.out.print(j + " ");
        }
    }

    static void Reverse(int[] nums, int s, int e) {
        while (e > s) {
            int temp = nums[s];
            nums[s] = nums[e];
            nums[e] = temp;
            s++;
            e--;
        }
    }
}
