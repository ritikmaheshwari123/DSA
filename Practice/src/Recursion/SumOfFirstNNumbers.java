package Recursion;

public class SumOfFirstNNumbers {
    public static void main(String[] args) {
        int n = 2;
        System.out.println("Sum of first "+ n + " Natural numbers is: "+ NnumbersSum(n));
    }

    public static int NnumbersSum(int N){
        if (N > 0) {
            return N + NnumbersSum(N - 1);
        } else {
            return 0;
        }
    }
}
