//122. Best Time to Buy and Sell Stock II
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/

class Solution {
    
    //Simple Logic
    public int maxProfit(int[] prices) {
        int profit = 0;
        for(int i=1;i<prices.length;i++){
            if(prices[i] - prices[i-1] > 0){
                profit += prices[i] - prices[i-1];
            }
        }
        return profit;
    }

    //Added more conditios to check
    public int maxProfit1(int[] prices) {
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



