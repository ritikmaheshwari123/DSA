package Array;

/*
You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock
and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */

public class BestTimeToBuyAndSellStock {

    /*
    Time Complexity = O(n^2)
    Space Complexity = O(1)
     */
    public static int bruteForce(int[] arr){
        int maxProfit = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = i+1; j < arr.length; j++){
                int profit = arr[j]-arr[i];
                maxProfit = Math.max(maxProfit, profit);
            }
        }
        return maxProfit;
    }

    /*
    Time Complexity = O(n)
    Space Complexity = O(1)
     */
    public static int onepass(int[] arr){
        int maxProfit = 0;
        int min_price = Integer.MAX_VALUE;
        for (int j : arr) {
            if (j < min_price) {
                min_price = j;
            } else {
                maxProfit = Math.max(maxProfit, j - min_price);
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        System.out.println(bruteForce(arr));
        System.out.println(onepass(arr));
    }
}
