package DailyLeetCode;

public class TakingMaximumEnergyFromTheMysticDungeon {
    public static void main(String[] args) {
        int[] energy = {-2,-3,-1};
        int k=2;
        System.out.println(maximumEnergyOptimal(energy, k));
    }

    private static int maximumEnergy(int[] energy, int k) {
        int maxEnergy = Integer.MIN_VALUE;
        int n = energy.length;
        // Try all combinations of taking from the front and back
        for (int i = 0; i < n; i++) {
            int currentSum = 0;
            for(int j=i; j < n; j=j+k){
                currentSum = currentSum + energy[j];
            }
            maxEnergy = Math.max(maxEnergy, currentSum);
        }
        return maxEnergy;
    }

    private static int maximumEnergyOptimal(int[] energy, int k) {
        int n = energy.length;
        int ans = Integer.MIN_VALUE;
        int dp[] = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            dp[i] = energy[i] + (i + k < n ? dp[i + k] : 0);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
