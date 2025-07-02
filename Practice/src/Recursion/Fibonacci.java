package Recursion;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 4;
        System.out.println("Fibonacci number of " + n + " is : "+ fibonacci(n));
    }

    public static int fibonacci(int n){
        if(n==0||n==1) return n;
        return (fibonacci(n-1)+fibonacci(n-2));
    }
}
