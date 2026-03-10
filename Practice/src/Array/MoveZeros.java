package Array;

/*
Given an integer array num_arr,
move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 */

public class MoveZeros {
    /*
    Time Complexity = O(n)
    Space Complexity = O(n)
     */
    public static void moveZerosToEndBruteForceWithExtraSpace(int[] num_arr){
        int [] result = new int [num_arr.length];
        int j=0;
        for (int value : num_arr) {
            if (value != 0) {
                result[j] = value;
                j++;
            }
        }
        for(int k=j;k<num_arr.length;k++){
            result[k]=0;
            j++;
        }

        for(int i:result){
            System.out.print(i+" ");
        }
    }

    /*
        Time Complexity = O(n)
        Space Complexity = O(1)
    */
    public static void moveZerosToEndTwoPassInPlace(int[] num_arr){
        int writePos = 0;
        for(int i:num_arr){
            if(i!=0){
                num_arr[writePos++]=i;
            }
        }
        while(writePos<num_arr.length){
            num_arr[writePos++]=0;
        }

        for(int i:num_arr){
            System.out.print(i+" ");
        }
    }

    /*
        Time Complexity = O(n)
        Space Complexity = O(1)
    */
    public static void moveZerosToEndOptimalTwoPointerWithSwapping(int[] num_arr){
        int writePos = 0;
        for(int readPos=0;readPos<num_arr.length;readPos++){
            if(num_arr[readPos]!=0){
                if(readPos!=writePos){
                    int tmp =num_arr[writePos];
                    num_arr[writePos]=num_arr[readPos];
                    num_arr[readPos]=tmp;
                }
                writePos++;
            }
        }

        for(int i:num_arr){
            System.out.print(i+" ");
        }
    }
    public static void main(String[] args) {
        int [] num_arr = {0, 1, 0, 3, 12};
        moveZerosToEndBruteForceWithExtraSpace(num_arr);
        System.out.println();
        moveZerosToEndTwoPassInPlace(num_arr);
        System.out.println();
        moveZerosToEndOptimalTwoPointerWithSwapping(num_arr);
    }
}
