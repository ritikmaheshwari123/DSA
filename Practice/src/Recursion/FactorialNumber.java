package Recursion;

public class FactorialNumber {
    public static void main(String[] args) {
        int n = 0;
        System.out.println("Factorial of "+ n + " is: "+ factorial(n));
    }
    public static int factorial(int n){
        if(n == 0){
            return 1;
        } else if(n>=1){
            return n * factorial(n-1);
        } else {
            return -1;
        }
    }
}
