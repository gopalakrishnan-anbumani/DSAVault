//BestTimetoBuyandSellStockwithTransactionFee.java
//714. Best Time to Buy and Sell Stock with Transaction Fee
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/

class Solution {
    int[] prices = null;
    int fee = 0;
    int[][] dp = null;
    public int maxProfit(int[] price, int fees) {
        prices = price;
        fee = fees;
        dp = new int[price.length][2];
        for(int[] d : dp){
            Arrays.fill(d, -1);
        }
        return rec(0, 1);
    }
    //1>Buy
    //0> SELL
    public int rec(int index, int buying){
        if(index >= prices.length){
            return 0;
        }
        if(dp[index][buying] != -1){
            return dp[index][buying];
        }
        int res = 0;
        int common = rec(index+1,buying);
        if(buying == 1){
            int buy = rec(index+1, 0) - prices[index];
            res = Math.max(common, buy-fee);
        } else {
            int sell = rec(index+1, 1) + prices[index];
            res = Math.max(common, sell);
        }
        dp[index][buying] = res;
        return dp[index][buying];
    }
}