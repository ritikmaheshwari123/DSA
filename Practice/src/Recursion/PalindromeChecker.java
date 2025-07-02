package Recursion;

public class PalindromeChecker {
    public static void main(String[] args) {
        PalindromeChecker checker = new PalindromeChecker();
        System.out.println(checker.isPalindrome("A man, a plan, a canal: Panama")); // true
        System.out.println(checker.isPalindrome("race a car")); // false
    }

    public boolean isPalindrome(String s) {
        // Clean the string: lowercase and remove non-alphanumeric characters
        String cleaned = cleanString(s);
        return isPalindromeRecursive(cleaned, 0, cleaned.length() - 1);
    }

    // Helper method to clean the string
    private String cleanString(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }
        return sb.toString();
    }

    // Recursive method to check palindrome
    private boolean isPalindromeRecursive(String s, int left, int right) {
        if (left >= right) {
            return true;
        }
        if (s.charAt(left) != s.charAt(right)) {
            return false;
        }
        return isPalindromeRecursive(s, left + 1, right - 1);
    }
}
