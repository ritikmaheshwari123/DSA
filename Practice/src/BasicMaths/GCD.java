package BasicMaths;

public class GCD {
    public static void main(String[] args) {
        int num1 = 48;
        int num2 = 18;
        // Euclidean Algorithm: BasicMaths.GCD(a, b) = BasicMaths.GCD(b, a % b)
        // LCM(a,b) * GCD(a,b) = a*b
        int gcd = findGCD(num1, num2);
        System.out.println("BasicMaths.GCD of " + num1 + " and " + num2 + " is: " + gcd);
    }
    // Method to calculate BasicMaths.GCD of two numbers
    public static int findGCD ( int n1, int n2){
        while (n2 != 0) {
            int temp = n2;
            n2 = n1 % n2;
            n1 = temp;
        }
        return Math.abs(n1); // Ensure BasicMaths.GCD is always positive
    }
}
