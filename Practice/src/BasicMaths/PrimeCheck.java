package BasicMaths;

public class PrimeCheck {

    public static boolean isPrime(int n) {

//      Why i * i <= n?
//      If n has a factor larger than √n, it must also have a factor smaller than √n.
//      So we only need to check up to the square root of n.

//      Why check i and i + 2?
//      This is an optimization based on this:
//      All prime numbers greater than 3 can be written as 6k ± 1
//💡    Why?
//      Any integer can be written as one of:
//      6k, 6k+1, 6k+2, 6k+3, 6k+4, 6k+5
//      Now let's analyze:
//      6k → divisible by 6 → not prime
//      6k+2 → even → divisible by 2
//      6k+3 → divisible by 3
//      6k+4 → even again
//      So only 6k+1 and 6k+5 (which is 6k - 1) can possibly be primes.
//      That’s why we check i and i+2 in each loop iteration, which correspond to 6k - 1 and 6k + 1.

        if (n <= 1) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;

        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int number = 29;
        System.out.println(number + " is prime? " + isPrime(number));
    }
}
