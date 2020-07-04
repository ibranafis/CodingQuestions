public class FindTownJudge {
    /* In a town there are  n people. There is a town judge who trusts nobody, everybody trusts him.
    Given trust, an array of pairs trust[i]=[a,b] -> a trusts b. Return the label of town judge
     */
    public static void main(String args[])
    {
        int n=4;
        int arr[][]={{1,3},{1,4},{2,3},{2,4},{4,3}};
        System.out.println(findJudge(n,arr));
    }

    private static int findJudge(int n, int[][] arr) {
        int count[]=new int[n+1];
        for(int t[]:arr)
        {
            count[t[0]]--;
            count[t[1]]++;
        }
        for(int i=1; i<=n; i++)
            if(count[i]==n-1)
                return i;
        return -1;
    }
}
