class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        char t1[]=text1.toCharArray();
        char t2[]=text2.toCharArray();
        int m=t1.length;
        int n=t2.length;
        int memo[]=new int[n+1];
        for(int i=1; i<=m; i++)
        {
            int prev=0;
            for(int j=1; j<=n; j++)
            {
                int temp=memo[j];
                if(t1[i-1]==t2[j-1])
                    memo[j]=prev+1;
                else
                    memo[j]=Math.max(memo[j], memo[j-1]);
                prev=temp;
            }
        }
        return memo[n];
    }
}