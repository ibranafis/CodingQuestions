import java.util.Arrays;

public class LongestIncresingSubsequence {
    //Return the length of LIS from an int array
    public static void main(String args[]) {
        int arr[] = {1,3,2};
        System.out.println(LISbyDP(arr));
        System.out.print(LISByBS(arr));
    }

    private static int LISbyDP(int[] arr) {
        if(arr.length==0)
            return 0;
        int dp[]=new int[arr.length];
        Arrays.fill(dp,1);
        for(int i=1; i<arr.length; i++)
            for(int j=0; j<i; j++)
                if(arr[j]<arr[i] && dp[i]<=dp[j])
                    dp[i]=dp[j]+1;
         Arrays.sort(dp);
        return dp[arr.length-1];

    }

    private static int LISByBS(int[] arr) {
        int ans[]=new int[arr.length];
        int len=0;
        for(int n:arr)
        {
            int i=Arrays.binarySearch(ans,0, len, n);
            if(i<0)
                i=-(i+1);
            ans[i]=n;
            if(i==len)
                len++;
        }
        return len;
    }
}
