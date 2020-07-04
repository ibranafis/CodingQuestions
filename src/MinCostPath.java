public class MinCostPath {
    /*A cost matrix will be given by the user. A program needs to be developed to find the minimum
    cost path from (0,0) position to (m,n) position i.e from the initial element to the final element
    in a given array. The path must be chosen such a way that total cost of traversing from initial
    position to the final position should be the least.
     */

    public static void main(String args[])
    {
        int mat[][]={{1,3,1},{1,5,1},{4,2,1}};
        int dstx=2, dsty=2;
        System.out.println(findMinCostPath(mat, dstx, dsty));
    }

    private static int findMinCostPath(int[][] mat, int m, int n) {
        int dp[][]=new int[m+1][n+1];
        dp[0][0]=mat[0][0];
        for(int i=1; i<=m; i++)
            dp[i][0] = dp[i-1][0] + mat[i][0];
        for(int j=1; j<=n; j++)
            dp[0][j] = dp[0][j-1] + mat[0][j];
        for(int i=1; i<=m; i++)
            for(int j=1; j<=n; j++)
                dp[i][j]=Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + mat[i][j]; //Moving diagonal, down and right respectively.
         return dp[m][n];
    }
}