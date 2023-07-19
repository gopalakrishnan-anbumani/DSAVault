//BestTimetoBuyandSellStockwithCooldown.java
//309. Best Time to Buy and Sell Stock with Cooldown
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/

class Solution {
    int[][] dp = null;
    public int maxProfit(int[] prices) {
        dp = new int[prices.length][2];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        return rec(prices, 0, -1, 0);
    }
    public int rec(int[] prices, int index, int buy){
        if(index >= prices.length){
            return 0;
        }
        int cooldown = rec(prices, index+1, buy);
        //Buy
        if(buy == 1){
            int buy = rec(prices, index+1, 0) - prices[index];
        }
        if(buy == 0){
            int sell = rec(prices, index+1, 0) - prices[index];
        }n res;
    }
}
