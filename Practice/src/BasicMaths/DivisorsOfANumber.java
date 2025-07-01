package BasicMaths;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class DivisorsOfANumber {
    public static int[] findDivisors(int n) {

//      It automatically sorts the numbers.
//      It avoids duplicates (in case i and n/i are the same).
        Set<Integer> divisors = new TreeSet<>();

        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                divisors.add(i);
                divisors.add(n / i);
            }
        }

        // Convert the sorted set to an array
        int[] result = new int[divisors.size()];
        int index = 0;
        for (int divisor : divisors) {
            result[index++] = divisor;
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 36;
//        If i divides n, then n / i is also a divisor.
        int[] result = findDivisors(n);

        System.out.print("Divisors of " + n + ": ");
        System.out.println(Arrays.toString(result));
    }
}
