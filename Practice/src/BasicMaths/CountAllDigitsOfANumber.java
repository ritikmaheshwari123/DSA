package BasicMaths;

public class CountAllDigitsOfANumber {
    public static void main(String[] args) {
        int number = 1000;
        int count = 0;
        while(number>0){
            number=number/10;
            count++;
        }
        System.out.println(count);
    }
    public int optimal_solution(int n){
        return (int) (Math.log10(n) + 1);
    }
}
