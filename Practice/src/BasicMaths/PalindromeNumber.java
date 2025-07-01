package BasicMaths;

public class PalindromeNumber {
    public static void main(String[] args) {
        int x = 121;
        System.out.println("Reverse value is : "+ isPalindrome(x));
    }
    public static boolean isPalindrome(int x) {
        int temp=x;
        int rev =0;
        while(x>0){
            int rem= x%10;
            rev= rev*10+rem;
            x=x/10;
        }
        return rev == temp;
    }
}
