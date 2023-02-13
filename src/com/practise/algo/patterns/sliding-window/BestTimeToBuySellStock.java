//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
//NeetCode Problem
//Sliding Window

class BestTimeToBuySellStock {
    public int maxProfit(int[] prices) {
        int result = 0;
        if(prices.length <= 1){
            return result;
        }
        int lastSmallValue = prices[0];
        for(int i=1; i<prices.length; i++){
            int price = prices[i];
            if(price - lastSmallValue > result){
                result = price - lastSmallValue;
            } 
            if(price < lastSmallValue){
                lastSmallValue = price;
            }
        }
        return result;
    }
}
