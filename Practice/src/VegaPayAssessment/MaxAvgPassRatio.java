package VegaPayAssessment;

/*
There is a school that has classes of students and each class will be having a final exam.
You are given a 2D integer array classes, where classes[i] = [passi, totali].
You know beforehand that in the ith class, there are totali total students,
but only passi number of students will pass the exam.

You are also given an integer extraStudents.
There are another extraStudents brilliant students that are guaranteed to pass the exam of any class they are assigned to.
You want to assign each of the extraStudents students to a class in a way that maximizes the average pass ratio across all the classes.

The pass ratio of a class is equal to the number of students of the class that will pass the exam divided by the total number of students of the class.
The average pass ratio is the sum of pass ratios of all the classes divided by the number of the classes.

Return the maximum possible average pass ratio after assigning the extraStudents students.
Answers within 10-5 of the actual answer will be accepted.
Example 1:

Input: classes = [[1,2],[3,5],[2,2]], extraStudents = 2
Output: 0.78333
Explanation: You can assign the two extra students to the first class.
The average pass ratio will be equal to (3/4 + 3/5 + 2/2) / 3 = 0.78333.

Example 2:

Input: classes = [[2,4],[3,9],[4,5],[2,10]], extraStudents = 4
Output: 0.53485
*/

public class MaxAvgPassRatio {
    public static void main(String[] args) {
        int [][] classes = {{2,4},{3,9},{4,5},{2,10}};
        int extarStu = 4;
        double result = maxAverageRation(classes, extarStu);
        System.out.println(result);

    }

    public static double maxAverageRation(int[][] classes, int extraStu){
        int n = classes.length;

        for(int e=0;e<extraStu;e++) {
            int bestClassIndex = -1;
            double bestGain = -1;

            for (int i = 0; i < n; i++) {
                double nume = classes[i][0];
                double deno = classes[i][1];

                double current = nume / deno;
                double next = (nume + 1) / (deno + 1);
                double gain = next - current;

                if (gain > bestGain) {
                    bestGain = gain;
                    bestClassIndex = i;
                }
            }

            classes[bestClassIndex][0] += 1;
            classes[bestClassIndex][1] += 1;
        }
            double totalRatio = 0.0;
            for(int[] c: classes){
                totalRatio += (double) c[0]/c[1];
            }
            return totalRatio/n;
    }
}
