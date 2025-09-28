package TuringAssessment;


/*
A grid of m*n size.
A robot is on upper left corner,
robot can move right and down only.
How many paths are there by which robot can reach bottom right corner of grid
 */
class Solution {


    public long factorial(int num){
        long result=1;
        for(int i=2;i<=num;i++){
            result*=i;
        }
        return result;
    }

    public long solution(int m, int n) {
        int totalMoves = m+n-2;
        int downMoves = n-1;
        return factorial(totalMoves)/(factorial(downMoves)*factorial(totalMoves-downMoves));
    }
}

class TopLeftToBottomRight {

    public static void main(String[] args) {
        System.out.println("Starting execution......");
        long ans = new Solution().solution(3,3);
        System.out.print(ans);
    }
}