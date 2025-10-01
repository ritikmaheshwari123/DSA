package Array.Medium;

public class RearrangeArrayElementsBySign {
    public static void main(String[] args) {
        int[] nums = {3, 1, -2, -5, 2, -4};
        int[] result = rearrangeArray(nums);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    private static int[] rearrangeArray(int[] nums) {
        int [] result = new int[nums.length];
        int posIndex = 0;
        int negIndex = 1;
        for(int num : nums){
            if(num >= 0){
                result[posIndex] = num;
                posIndex += 2;
            } else {
                result[negIndex] = num;
                negIndex += 2;
            }
        }
        return result;
    }
}
