package DailyLeetCode;

import java.util.Arrays;

public class SuccessfulPairsofSpellsAndPotions {
    public static void main(String[] args) {
        int[] spells = {5, 1, 3};
        int[] potions = {1, 2, 3, 4, 5};
        long success = 7;
        int [] result = successfulPairs(spells, potions, success);
        for (int res : result) {
            System.out.print(res + " ");
        }
    }

    private static int[] successfulPairs(int[] spells, int[] potions, long success) {
        int [] result = new int[spells.length];
        int n = spells.length;
        int m = potions.length;
        for(int i = 0; i < n; i++) {
            int count = 0;
            for(int j = 0; j < m; j++) {
                long product = (long) spells[i] * (long) potions[j];
                if(product >= success) {
                    count++;
                }
            }
            result[i] = count;
        }
        return result;
    }

    public int[] successfulPairsOPtimal(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length;
        int ans[] = new int[n];

        for (int i = 0; i < n; i++) {
            int idx = bs(potions, spells[i], success);
            if (idx != -1) ans[i] = potions.length - idx;
        }

        return ans;
    }
    int bs(int potions[], long strength, long success) {
        int low = 0, high = potions.length - 1, idx = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if ((long) potions[mid] * strength >= success) {
                idx = mid;
                high = mid - 1; // find smaller index
            } else {
                low = mid + 1;
            }
        }
        return idx;
    }
}
