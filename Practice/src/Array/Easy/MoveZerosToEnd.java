package Array.Easy;

public class MoveZerosToEnd {
    public static void main(String[] args) {
        int [] nums = {0, 1, 0, 3, 12};
        int  j=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                j=i;
                break;
            }
        }

        if(j!=-1){
            for(int i=j+1;i<nums.length;i++){
                if(nums[i]!=0){
                    int temp = nums[i];
                    nums[i]=nums[j];
                    nums[j]=temp;
                    j++;
                }
            }
        }

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
