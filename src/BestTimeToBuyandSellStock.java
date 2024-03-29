class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length<2)
            return 0;
        int maxProfit=prices[1]-prices[0];
        int minPrice=prices[0];

        for(int i=1; i<prices.length; i++)
        {
            int currentPrice=prices[i];
            int currentProfit=currentPrice-minPrice;
            maxProfit=Math.max(maxProfit, currentProfit);
            minPrice=Math.min(minPrice, currentPrice);
        }
        return maxProfit<0?0:maxProfit;
    }
}