public class HouseRobber {
    public static void main(String args[])
    {
        int arr[]={2,7,9,3,1};
        System.out.println(finMaxAmt(arr));
    }

    private static int finMaxAmt(int[] arr) {
        if(arr.length==0)
            return 0;
        int prev1=0, prev2=0;
        for(int n: arr)
        {
            int temp=prev1;
            prev1=Math.max(prev1, prev2+n);
            prev2=temp;
        }
        return prev1;
    }
}