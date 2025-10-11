package InfosysAssessment;

import java.util.ArrayList;

public class Convert3By3ArrayToListAndPrintOddNumbers {
    public static void main(String[] args) {
        int [][] arr = {{1,2,3},{4,5,6},{7,8,9}};
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0;i< arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                list.add(arr[i][j]);
            }
        }

        System.out.println("List: "+ list);

        for(int num: list){
            if(num%2!=0){
                System.out.println(num);
            }
        }
    }
}
