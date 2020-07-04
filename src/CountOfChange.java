public class CountOfChange {
    //Number of ways we can make a given amount of money with given denominations
    public static void main(String args[]) {
        int money = 10;
        int denomination[] = {1,2, 5};
        System.out.println(findNoOfWays(money, denomination));
    }

    private static int findNoOfWays(int money, int[] denomination) {
        int count[]=new int[money+1];
        count[0]=1;
        for(int coin: denomination)
        {
            for(int higherAmt=coin; higherAmt<=money; higherAmt++)
            {
                int rem=higherAmt-coin;
                count[higherAmt]+=count[rem];
            }
        }
        return count[money];
    }
}