package Array.Medium;

public class LeadersInAnArray {
    public static void main(String[] args) {
        int[] arr = {16, 17, 4, 3, 5, 2};
        printLeadersOptimal(arr);
    }

    private static void printLeaders(int[] arr) {
        for(int i=0;i< arr.length;i++){
            boolean isLeader = true;
            for(int j=i+1;j< arr.length;j++){
                if(arr[j]>arr[i]){
                    isLeader = false;
                    break;
                }
            }
            if(isLeader){
                System.out.print(arr[i]+" ");
            }
        }
    }

    private static void printLeadersOptimal(int[] arr) {
        int max = arr[arr.length-1];
        System.out.print(max+" ");
        for(int i=arr.length-2;i>=0;i--){
            if(arr[i]>max){
                max = arr[i];
                System.out.print(max+" ");
            }
        }
    }
}
