//PerfectSquares
//279. Perfect Squares
//https://leetcode.com/problems/perfect-squares/description/

import java.util.Arrays;

class PerfectSquares {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, n);
        dp[0] = 0;

        for(int target=1; target<=n; target++){
            for(int s=1; s <= target; s++){
                int sqrt = s * s;
                if(target - sqrt < 0){
                    break;
                }
                dp[target] = Math.min(dp[target], 1+dp[target-sqrt]);
            }
        }
        return dp[n];
    }
}