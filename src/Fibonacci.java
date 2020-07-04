import java.util.Arrays;

public class Fibonacci {
    public static void main(String args[])
    {
        int i=5;
        System.out.println(ithfib(i));
        System.out.println(ithfibFormula(i));
        System.out.println(DPfib(i));
    }

    private static int DPfib(int i) {
        int dp[]=new int[i+1];
        if(i==1)
            return 1;
        dp[1]=1;
        dp[2]=2;
        for(int j=3; j<=i; j++)
        dp[j]=dp[j-1]+dp[j-2];
        return dp[i-1];
    }

    private static int ithfibFormula(int i) {
        return (int) Math.round(Math.pow(((Math.sqrt(5)+1)/2),i)/Math.sqrt(5));
    }

    private static int ithfib(int i) {
        int arr[]=new int[i+1];
        Arrays.fill(arr, -1);
        return memo_fib(arr,i);
    }

    private static int memo_fib(int[] arr, int i) {
        if(arr[i]!=-1)
            return arr[i];
        if(i<=1)
            return i;
        arr[i]=memo_fib(arr,i-2)+memo_fib(arr, i-1);
        return arr[i];
    }
}