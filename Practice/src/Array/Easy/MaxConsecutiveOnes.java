package Array.Easy;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int [] numbs = {1, 1, 0, 1, 1, 1};
        int maxConsecutiveOnes = findMaxConsecutiveOnes(numbs);
        System.out.println("Maximum number of consecutive 1s: " + maxConsecutiveOnes);
    }
    private static int findMaxConsecutiveOnes(int[] numbs) {
        int maxCount = 0;
        int currentCount = 0;
        for (int numb : numbs) {
            if (numb == 1) {
                currentCount++;
            } else {
                maxCount = Math.max(maxCount, currentCount);
                currentCount = 0;
            }
            maxCount = Math.max(maxCount, currentCount);
        }
        return maxCount;
    }
}
