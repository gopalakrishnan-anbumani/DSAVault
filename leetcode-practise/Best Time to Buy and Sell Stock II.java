//122. Best Time to Buy and Sell Stock II
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/

class Solution {
    public int maxProfit(int[] prices) {
        int overAllProfit = 0;
        int stock = prices[0];
        int pProfit = 0;
        for(int i=1; i<prices.length; i++){
            int todayPrice = prices[i];
            int sellProfit = todayPrice - stock;
            if(sellProfit <= 0 || sellProfit < pProfit){
                    overAllProfit+=pProfit;
                    stock = prices[i];
                    pProfit = 0;
            } else {
                    pProfit = sellProfit;
            }
        }
        return overAllProfit+=pProfit;
    }
}



