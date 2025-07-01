package BasicMaths;

public class ArmstrongNumberChecker {
    public static boolean isArmstrong(int n) {
        int originalNumber = n;
        int numberOfDigits = String.valueOf(n).length();
        int sum = 0;

        while (n > 0) {
            int digit = n % 10;
            sum += (int) Math.pow(digit, numberOfDigits);
            n /= 10;
        }

        return sum == originalNumber;
    }

    public static void main(String[] args) {
        int number = 153; // Example input
        System.out.println(isArmstrong(number)); // Output: true
    }
}
