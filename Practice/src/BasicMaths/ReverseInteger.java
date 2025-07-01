package BasicMaths;

public class ReverseInteger {
    public static void main(String[] args) {
        int x = 5478;
        System.out.println("Reverse value is : "+ reverse(x));
    }

    public static int reverse(int x) {
        int reversed = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;

            // Check for overflow/underflow before multiplying and adding
            // Integer.MAX_VALUE = 2,147,483,647
            if (reversed > Integer.MAX_VALUE / 10 || (reversed == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0; // Overflow
            }
            // Integer.MIN_VALUE = -2,147,483,648
            if (reversed < Integer.MIN_VALUE / 10 || (reversed == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0; // Underflow
            }

            reversed = reversed * 10 + pop;
        }
        return reversed;
    }
}
