public class BestTimeToBuyandSellStock {
    public static void main(String args[])
    {
        int stock[]={10, 7, 5, 8, 11};
        System.out.print(maxProfit(stock));
    }

    private static int maxProfit(int[] stock) {
        if(stock.length<2)
            return 0;
        int minPrice=stock[0];
        int maxProfit=stock[1]-stock[0];
        for(int i=1; i<stock.length; i++)
        {
            int currPrice=stock[i];
            int profit=currPrice-minPrice;
            maxProfit=Math.max(maxProfit, profit);
            minPrice=Math.min(minPrice, currPrice);
        }
        return maxProfit;
    }
}