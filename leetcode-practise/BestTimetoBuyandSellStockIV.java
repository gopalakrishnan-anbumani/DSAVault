//BestTimetoBuyandSellStockIV
//188. Best Time to Buy and Sell Stock IV
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/description/

import java.util.Arrays;

class BestTimetoBuyandSellStockIV {
    int[] prices = null;
    int k = 0;
    int[][][] dp = null;
    public int maxProfit(int k1, int[] prices1) {
        prices = prices1;
        k = k1;
        dp = new int[prices.length][2][k];
        for(int[][] d : dp){
            for(int[] d1 : d){
                Arrays.fill(d1, -1);
            }
        }
        return buySellIV(0, 1, 0);
    }

    public int buySellIV(int index, int buy, int count){
        if(index >= prices.length){
            return 0;
        }
        if(count >= k){
            return 0;
        }
        if(dp[index][buy][count] != -1){
            return dp[index][buy][count];
        }
        int res = 0;
        int hold = buySellIV(index+1, buy, count);
        if(buy == 1){
            res = Math.max(hold, (buySellIV(index+1, 0, count) - prices[index]));
        } else {
            res = Math.max(hold, (buySellIV(index+1, 1, count+1) + prices[index]));
        }
        dp[index][buy][count] = res;
        return dp[index][buy][count];
    }
}



