package VisaAssessment;

/*
You are given an initial rating value and an array of integers representing changes to rating.
Your task is to calculate final rating and return level corresponding to that rating
Levels
rating<1000 - beginner
1000<= rating < 1500 - intermediate
1500<=rating<2000- advanced
2000<= - pro
Complete the method String solution(int initial, int [] changes) in java
 */

public class RatingCalculation {

    public static String solution(int initial, int[] changes) {
        int finalRating = initial;

        // Apply all rating changes
        for (int change : changes) {
            finalRating += change;
        }

        // Determine level based on final rating
        if (finalRating < 1000) {
            return "beginner";
        } else if (finalRating < 1500) {
            return "intermediate";
        } else if (finalRating < 2000) {
            return "advanced";
        } else {
            return "pro";
        }
    }

    public static void main(String[] args) {
        int initial = 1200;
        int[] changes = {100, -50, 200};

        String level = solution(initial, changes);
        System.out.println(level); // Output: intermediate
    }
}
