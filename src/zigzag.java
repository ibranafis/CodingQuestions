public class zigzag {
    public static void main(String[] args) {
        int[] arr = {1,2,4,4,5,6};
        System.out.println(minSwaps(arr));

}

    private static int minSwaps(int[] arr) {
        int dp[][]=new int[arr.length][2];
        dp[0][0]=1;
        dp[0][1]=1;
        int min=0;
        for(int i=1; i<arr.length; i++)
        {
            for(int j=i-1; j>=0; j--)
            {
                if(arr[j]<arr[i])
                    dp[i][0]=Math.max(dp[j][1]+1, dp[i][0]);
                else if(arr[j]>arr[i])
                    dp[i][1]=Math.max(dp[j][0]+1, dp[i][1]);
            }
            min=Math.max(min, Math.max(dp[i][0],dp[i][1]));
        }
        return min;
    }
}
