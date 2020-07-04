public class RodCutting {
    //Given an integer, break it into the sum of at least 2 positive integers and maximize the product
    public static void main(String args[])
    {
        int n=10;
        System.out.println(finMaxByMath(n));
        System.out.println(finMaxByDP(n));
    }

    private static int finMaxByDP(int n) {
        if(n>3)
            n++;
        int dp[]=new int[n+1];
        dp[1]=1;
        for(int i=2; i<=n; i++)
            for(int j=1; j<i; j++)
                dp[i]=Math.max(j*dp[i-j], dp[i]);
        return dp[n];
    }

    private static int finMaxByMath(int n) {
        if(n==1 || n==2)
            return 1;
        if(n==3)
            return 2;
        int prod=1;
        while(n>4)
        {
            prod*=3;
            n-=3;
        }
        prod*=n;
        return prod;
    }
}