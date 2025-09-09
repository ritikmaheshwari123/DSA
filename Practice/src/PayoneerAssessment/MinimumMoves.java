package PayoneerAssessment;

// Bruce is shifting things from his old home to new.
// He can carry at most 2 items in one move,
// provided sum of weight is at most k otherwise he will carry 1.
// Write a java code to return min moves

import java.util.Arrays;

public class MinimumMoves {
    public static void main(String[] args) {
        int [] weights = {3, 5, 3, 4};
        int k = 6;

        Arrays.sort(weights);
        int i = 0, j = weights.length - 1;
        int moves = 0;

        while (i <= j) {
            if (weights[i] + weights[j] <= k) {
                // carry both items
                i++;
                j--;
            } else {
                // carry heavier item alone
                j--;
            }
            moves++;
        }

        System.out.println("Number of moves: "+ moves);
    }
}
