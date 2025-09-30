package Array.Medium;

public class StockBuyAndSell {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

    private static int maxProfit(int[] prices) {
        int maxProfit = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            int diff = 0;
            for (int j = i + 1; j < prices.length; j++) {
                diff = prices[j] - prices[i];
                if (diff > maxProfit) {
                    maxProfit = diff;
                }
            }
        }
        return maxProfit;
    }

    private static int maxProfitOptimized(int[] arr) {
        int maxPro = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int j : arr) {
            minPrice = Math.min(minPrice, j);
            maxPro = Math.max(maxPro, j - minPrice);
        }
        return maxPro;
    }
}
